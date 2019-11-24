package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginInterceptor implements HandlerInterceptor {
    private static final String GUEST = "guest";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getSession().getId());
        HttpSession session = request.getSession();
        String username = (String) Optional.ofNullable(session.getAttribute("username")).orElse(GUEST);
        if (GUEST.equals(username)) {
            throw new Exception("请登录");
        }
        return true;
    }
}
