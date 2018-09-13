package org.driving.school.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.driving.school.common.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @date 2018-07-13
 * @desc 未登录访问拦截
 * @author yangpengcheng
 *
 */
public class MyInterceptor implements HandlerInterceptor {
	
    Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("------preHandle------");
        //获取session
        HttpSession session = request.getSession(true);
        //判断用户是否存在，不存在就跳转到登录界面
        if(session.getAttribute(Constants.USER_SESSION) == null){
            logger.info("------:跳转到login页面！");
//            request.setAttribute("msg", "请先登录！");
//            request.getRequestDispatcher("/login").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }else{
            //session.setAttribute(Constants.USER_SESSION, session.getAttribute(Constants.USER_SESSION));
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub
    }

}