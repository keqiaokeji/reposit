package com.keqiaokeji.tezizai.svc.interceptor;


import com.alibaba.fastjson.JSON;
import com.keqiaokeji.tezizai.common.app.JsonResultContants;
import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: keqiaokeji
 * Date: 14-5-18
 * Time: 下午10:13
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CheckTokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    CacheCtrl cacheCtrl;

    /**
     * 拦截处理
     *
     * @param request  请求信息
     * @param response 响应信息
     * @param handler  代理
     * @return true：未通过拦截器，不再继续往下走，false：通过了拦截器，将会继续往下走
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String token = request.getParameter("token");
        if (null == token || !cacheCtrl.getTokenCtrl().checkTokenTimeOutAndInitThreadLocal(token)) {// 未登录或Token过期
            PrintWriter out = response.getWriter();
            String jsonString = JSON.toJSONString(new JsonResult(JsonResultContants.TOKEN_TIME_OUT, JsonResultContants.TOKEN_TIME_OUT_MSG));
            out.print(jsonString);
            out.flush();
            out.close();
            return false;
        } else {
            return super.preHandle(request, response, handler);
        }
//        return true;//也可以使用返回true通过本次拦截
    }
}
