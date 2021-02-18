package com.timberliu.springboot.springmvc.handlerinterceptor.interceptors;

import com.timberliu.springboot.springmvc.handlerinterceptor.annotation.AccessLimit;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * created by Timber in 2020/7/1
 */
public class FangshuaInteceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;

            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }

            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean login = accessLimit.needLogin();
            String key = request.getRequestURI();
            if (login) {
                // 获取登录的 session 判断
                // 假设 userId 为 1
                key += "1";
            }

            Integer count = 0;
            // 从 redis 中获取用户访问的次数
            // ···
            if (count == null) {
                // 第一次访问，设置次数为 1
                // ...
            } else if (count < maxCount) {
                // 访问次数加 1
                // ...
            } else {
                // 超过访问次数
                render(response, null);
                return false;
            }
        }

        return true;
    }

    private void render(HttpServletResponse response, Object obj) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        // 返回对象转换为 JSON 串
        String str  = "";
        out.write(str.getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
    }

}
