package com.org.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Handle implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //        是否登录判断
        if (request.getSession().getAttribute("users") == null){
//            此时没有登录，转发到登录页面，并给出提示
            request.setAttribute("x","请先登录");
//            转发
            request.getRequestDispatcher("login.html").forward(request,response);
            return false;
        }
//        放行
        return true;
    }


}
