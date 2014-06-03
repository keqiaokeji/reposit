package com.keqiaokeji.tezizai.common.cache.verifycode;

import com.keqiaokeji.tezizai.common.character.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-15
 * Time: 下午11:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/anonymous/cache")
public class VerifyCodeController {
    private int width = 95;//定义图片的width
    private int height = 25;//定义图片的height
    private int codeCount = 4;//定义图片上显示验证码的个数
    private int fontHeight = 18;//字体大小
    private int interferingLineNum = 20;//干扰线的条数
    private int interferingLineLength = 12;//干扰线的长度
    private int codeX = 15;//每个验证码字符所占的宽度
    private int codeY = 20;//每个验证码自负所占的高度
    char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'}; //去掉了字幕o和数字0这两个容易混淆的字符

    @Autowired
    VerifyCodeCache verifyCodeCache;


    @ResponseBody
    @RequestMapping("/getVerifyCode")
    public VerifyCodeInfo getVerifyCode(String codeKey, HttpServletRequest req) throws IOException {
        if(StringUtils.isNotBlank(codeKey)){
            verifyCodeCache.removeVerifyCode(codeKey);//将原有的二维码从缓存中移除掉
        }

        VerifyCodeInfo imgCodeInfo = new VerifyCodeInfo();
        Random random = new Random();// 创建一个随机数生成器类
        List<String> codeContents = new ArrayList<String>();
        for (int i = 0; i < codeCount; i++) {
            String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length-1)]);
            codeContents.add(code);
        }
        String newCodeKey = StringUtils.getUUID();
        String imgUrl = "http://" + req.getServerName() + ":" + req.getServerPort() +  req.getContextPath() + "/anonymous/cache/getVerifyCodeImg.do?codeKey=" + newCodeKey;
        imgCodeInfo.setCodeKey(newCodeKey);
        imgCodeInfo.setImgUrl(imgUrl);
        verifyCodeCache.addVerifyCode(newCodeKey, codeContents, imgUrl);
        return imgCodeInfo;
    }

    @ResponseBody
    @RequestMapping("/checkVerifyCode")
    public boolean checkVerifyCode(String codeKey, String codeContent) throws IOException {
        return verifyCodeCache.checkVerifyCode(codeKey, codeContent);
    }


    @RequestMapping("/getVerifyCodeImg")
    public void getVerifyCodeImg(HttpServletRequest req, HttpServletResponse resp, String codeKey) throws IOException {
        VerifyCodeInfo imgCodeInfo = verifyCodeCache.getVerifyCodeInfo(codeKey);
        if (imgCodeInfo == null) {//如果验证码的键不存在则直接返回
            System.out.println("不存在验证码的键为：" + codeKey);
            return;
        }


        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        Graphics2D gd = buffImg.createGraphics();//用于绘制更加复杂的图形
//        Graphics2D gd = (Graphics2D) buffImg.getGraphics();
        Graphics gd = buffImg.getGraphics();
        Random random = new Random();// 创建一个随机数生成器类
        gd.setColor(Color.WHITE); // 将图像填充为白色
        gd.fillRect(0, 0, width, height);


        Font font = new Font("Fixedsys", Font.BOLD, fontHeight); // 创建字体，字体的大小应该根据图片的高度来定。
        gd.setFont(font);

        // 画边框。
        gd.setColor(Color.gray);
        gd.drawRect(0, 0, width - 1, height - 1);//绘制矩形
        gd.setColor(Color.gray);

        // 随机产生指定条数的干扰线，使图象中的认证码不易被其它程序探测到。
        for (int i = 0; i < interferingLineNum; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(interferingLineLength);
            int yl = random.nextInt(interferingLineLength);
            gd.drawLine(x, y, x + xl, y + yl);//在此图形上下文的坐标系中，使用当前颜色在点 (x, y) 和 (x+xl, y+yl) 之间画一条线
        }

        int red = 0, green = 0, blue = 0;
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            gd.setColor(new Color(red, green, blue));// 用随机产生的颜色将验证码绘制到图像中。
            gd.drawString(imgCodeInfo.getCodeContents().get(i), (i + 1) * codeX, codeY);//三个参数的意思依次是：要绘制的文字、X坐标、Y坐标
        }
        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        //图片类型为jpeg
        resp.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }


}
