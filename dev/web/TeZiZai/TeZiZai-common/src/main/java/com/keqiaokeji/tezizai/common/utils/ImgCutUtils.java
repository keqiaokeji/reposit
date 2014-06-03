package com.keqiaokeji.tezizai.common.utils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.util.Iterator;


/**
 * 图片剪辑处理
 */
public class ImgCutUtils {


    /**
     * 将图片压缩到指定的宽高，并转换为指定的格式
     * 如果图片的宽高比例和给定的比例不协调，则会首先将原图修剪为指定的比例然后压缩
     *
     * @param sourceImgPath 被压缩文件的路径
     * @param saveImgPath   压缩之后保存路径
     * @param formatName    指定的格式
     * @param width         压缩后的宽度
     * @param height        压缩后的高度
     */
    public static void compressWithCut(String sourceImgPath, String saveImgPath, String formatName, int width, int height) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(new File(sourceImgPath));
        int imgWidth = bufferedImage.getWidth();
        int imgHeight = bufferedImage.getHeight();

        //计算修建图片所需的参数
        float tempWidth = imgHeight * (new Integer(width).floatValue() / height);//假设高度不变，按照指定的压缩比例，算出需要的宽度
        float tempHeight = imgWidth / (new Integer(width).floatValue() / height);//假设宽度不变，按照指定的压缩比例，算出需要的高度
        float startX = 0, startY = 0;//修剪图片的起点坐标
        float newWidth = imgWidth, newHeight = imgHeight;//修剪之后剩余的宽高
        if (tempWidth <= imgWidth) {//如果计算出的宽度在当前图片宽度范围之内则说明可以按高度不变，宽度以计算出的宽度进行修剪图片
            startX = (imgWidth - tempWidth) / 2;//两边各修剪掉一半宽度，计算出修剪的起始x坐标
            newWidth = tempWidth;
        } else if (tempHeight <= imgHeight) {
            startY = (imgHeight - tempHeight) / 2;
            newHeight = tempHeight;
        }

        BufferedImage bufferedImageCut = cut(bufferedImage, (int) Math.rint(startX), (int) Math.rint(startY), (int) Math.rint(newWidth), (int) Math.rint(newHeight));//修剪图片
        BufferedImage compressBufferedImage = zoom(bufferedImageCut, width, height);//压缩图片
        ImageIO.write(compressBufferedImage, formatName, new File(saveImgPath));
    }

    /**
     * 缩放图像（按比例缩放）
     *
     * @param sourceImgPath 被缩放的文件的路径
     * @param saveImgPath   缩放之后的保存路径
     * @param zoomValue     缩放比例值（整数为放大，负数为缩小）
     */
    public static void zoom(String sourceImgPath, String saveImgPath, float zoomValue) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(new File(sourceImgPath)); // 读入文件
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        if (zoomValue > 0) {// 放大
            width = (int) Math.rint(width * zoomValue);
            height = (int) Math.rint(height * zoomValue);
        } else {// 缩小
            zoomValue = Math.abs(zoomValue);
            width = (int) Math.rint(width / zoomValue);
            height = (int) Math.rint(height / zoomValue);
        }
        BufferedImage compressBufferedImage = zoom(bufferedImage, width, height);
        ImageIO.write(compressBufferedImage, getFormatName(sourceImgPath), new File(saveImgPath));
    }

    /**
     * 将图片缩放缩放为指定的宽高（如果缩放后的宽高比例和实际宽高比例不同则图片会失真）
     *
     * @param sourceImgPath 被缩放的图片路径
     * @param saveImgPath   缩放之后存储路径
     * @param width         缩放之后的宽度
     * @param height        缩放之后的高度
     * @throws Exception
     */
    public static void zoom(String sourceImgPath, String saveImgPath, int width, int height) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(new File(sourceImgPath));
        BufferedImage compressBufferedImage = zoom(bufferedImage, width, height);
        ImageIO.write(compressBufferedImage, getFormatName(sourceImgPath), new File(saveImgPath));
    }

    /**
     * 将图片缩放缩放为指定的宽高（如果缩放后的宽高比例和实际宽高比例不同则图片的宽度或高度其中有一个会小于给定的值，但是图片不会失真）
     *
     * @param sourceImgPath 被缩放的图片路径
     * @param saveImgPath   缩放之后存储路径
     * @param width         缩放之后的宽度
     * @param height        缩放之后的高度
     * @param useWhiteBg    是否使用白色作为图片背景色
     * @throws Exception
     */
    public static void zoom(String sourceImgPath, String saveImgPath, int width, int height, boolean useWhiteBg) throws Exception {
        double ratio = 0.0; // 缩放比例
        BufferedImage bufferedImage = ImageIO.read(new File(sourceImgPath));
        Image image = bufferedImage.getScaledInstance(width, height, bufferedImage.SCALE_SMOOTH);
        //计算比例
        if ((bufferedImage.getHeight() > height) || (bufferedImage.getWidth() > width)) {
            if (bufferedImage.getHeight() > bufferedImage.getWidth()) {
                ratio = (new Integer(height)).doubleValue() / bufferedImage.getHeight();
            } else {
                ratio = (new Integer(width)).doubleValue() / bufferedImage.getWidth();
            }
            AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
            image = op.filter(bufferedImage, null);
        }
        if (useWhiteBg) {//补白
            BufferedImage bufferedImageBg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = bufferedImageBg.createGraphics();
            graphics.setColor(Color.white);
            graphics.fillRect(0, 0, width, height);
            if (width == image.getWidth(null)) {
                graphics.drawImage(image, 0, (height - image.getHeight(null)) / 2, image.getWidth(null), image.getHeight(null), Color.white, null);
            } else {
                graphics.drawImage(image, (width - image.getWidth(null)) / 2, 0, image.getWidth(null), image.getHeight(null), Color.white, null);
            }
            graphics.dispose();
            image = bufferedImageBg;
        }
        ImageIO.write((BufferedImage) image, getFormatName(sourceImgPath), new File(saveImgPath));
    }

    /**
     * 剪切指定模块的图片
     *
     * @param sourceImgPath 被剪切的图片
     * @param saveImgPath   剪切之后保存路径
     * @param x             起始位置的X坐标
     * @param y             起始位置的Y坐标
     * @param width         剪切的宽度
     * @param height        剪切的高度
     * @throws Exception
     */
    public static void cut(String sourceImgPath, String saveImgPath, int x, int y, int width, int height) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(new File(sourceImgPath));
        BufferedImage bufferedImageCut = cut(bufferedImage, x, y, width, height);
        ImageIO.write(bufferedImageCut, getFormatName(sourceImgPath), new File(saveImgPath));
    }

    /**
     * 将图片转换为指定的格式
     *
     * @param sourceImgPath 被转换的图片
     * @param saveImgPath   转换之后保存路径
     * @param formatName    转换的格式（如JPEG，PNG，GIF等）
     * @throws Exception
     */
    public static void convert(String sourceImgPath, String saveImgPath, String formatName) throws Exception {
        File file = new File(sourceImgPath);
        file.canRead();
        file.canWrite();
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIO.write(bufferedImage, formatName, new File(saveImgPath));
    }

    /**
     * 彩色转为黑白
     *
     * @param sourceImgPath 被转换的图片
     * @param saveImgPath   转换之后保存路径
     */
    public static void gray(String sourceImgPath, String saveImgPath) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(new File(sourceImgPath));
        ColorSpace colorSpace = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp colorConvertOp = new ColorConvertOp(colorSpace, null);
        bufferedImage = colorConvertOp.filter(bufferedImage, null);
        ImageIO.write(bufferedImage, getFormatName(sourceImgPath), new File(saveImgPath));
    }


    /**
     * 给图片添加文字水印
     *
     * @param sourceImgPath 源图像地址
     * @param saveImgPath   目标图像地址
     * @param text          水印文字
     * @param fontName      水印的字体名称
     * @param fontStyle     水印的字体样式
     * @param color         水印的字体颜色
     * @param fontSize      水印的字体大小
     * @param x             X坐标
     * @param y             Y坐标
     * @param alpha         透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public static void watermarkWithText(String sourceImgPath, String saveImgPath, String text, String fontName,
                                         int fontStyle, Color color, int fontSize, int x, int y, float alpha) throws Exception {
        File img = new File(sourceImgPath);
        Image src = ImageIO.read(img);
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.drawImage(src, 0, 0, width, height, null);
        graphics2D.setColor(color);
        graphics2D.setFont(new Font(fontName, fontStyle, fontSize));
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        // 在指定坐标绘制水印文字
        graphics2D.drawString(text, (width - (getContentLength(text) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);
        graphics2D.dispose();
        ImageIO.write(image, getFormatName(sourceImgPath), new File(saveImgPath));// 输出到文件流
    }

    /**
     * 给图片添加图片水印
     *
     * @param sourceImgPath    源图像地址
     * @param saveImgPath      目标图像地址
     * @param watermarkImgPath 水印图片的地址
     * @param x                X坐标，默认在中间
     * @param y                Y坐标， 默认在中间
     * @param alpha            透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
     */
    public static void watermarkWithImg(String sourceImgPath, String saveImgPath, String watermarkImgPath, int x, int y, float alpha) throws Exception {
        Image image = ImageIO.read(new File(sourceImgPath));
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, width, height, null);
        // 水印文件
        Image watermarkImg = ImageIO.read(new File(watermarkImgPath));
        int watermarkImgWidth = watermarkImg.getWidth(null);
        int watermarkImgHeight = watermarkImg.getHeight(null);
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        graphics2D.drawImage(watermarkImg, (width - watermarkImgWidth) / 2, (height - watermarkImgHeight) / 2, watermarkImgWidth, watermarkImgHeight, null);
        // 水印文件结束
        graphics2D.dispose();
        ImageIO.write(bufferedImage, getFormatName(sourceImgPath), new File(saveImgPath));
    }



    private static int getContentLength(String content) {
        int length = 0;
        for (int i = 0; i < content.length(); i++) {
            if (new String(content.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }


    private static BufferedImage cut(BufferedImage bufferedImage, int x, int y, int width, int height) throws Exception {
        int imgWidth = bufferedImage.getWidth();
        int imgHeight = bufferedImage.getHeight();
        Image image = bufferedImage.getScaledInstance(imgWidth, imgHeight, Image.SCALE_DEFAULT);
        ImageFilter cropFilter = new CropImageFilter(x, y, width, height);// 四个参数分别为图像起点坐标和宽高
        Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
        BufferedImage bufferedImageCut = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImageCut.getGraphics();
        graphics.drawImage(img, 0, 0, width, height, null);// 绘制切割后的图
        graphics.dispose();
        return bufferedImageCut;
    }


    private static BufferedImage zoom(BufferedImage bufferedImage, int width, int height) throws Exception {
        Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage compressBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = compressBufferedImage.getGraphics();
        graphics.drawImage(image, 0, 0, null); // 绘制缩小后的图
        graphics.dispose();
        return compressBufferedImage;
    }

    private static String getFormatName(String fileName) throws Exception {
        String formatName;
        ImageInputStream iis = ImageIO.createImageInputStream(new File(fileName));
        Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
        ImageReader reader = iter.next();
        formatName = reader.getFormatName();
        iis.close();
        return formatName;
    }

    public static void main(String[] args) throws Exception {
        String sourceImgPath = "/Users/keqiaokeji/Desktop/img/1.jpg";
//        compressWithCut(sourceImgPath, "/Users/keqiaokeji/Desktop/img/compressWithCut.png", "png", 100, 100);//将图片压缩到指定的宽高，并转换为指定的格式
        System.out.println(getFormatName(sourceImgPath));


    }


}
