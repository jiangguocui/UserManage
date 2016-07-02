package com.usermanage.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.usermanage.entity.Tmanager;

public class MoginInterceptor extends HandlerInterceptorAdapter {
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        	String path = request.getContextPath();
        	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        		 if (request.getSession().getAttribute("mloginUser") == null){
        			 System.out.println(request.getSession().getAttribute("loginUser"));
        			 response.sendRedirect(basePath+"index.jsp");
        			 return false;
        	}else{
        		System.out.println("sdsjkd");
        		 return true;
        	}
            	
            //request.getRequestDispatcher("redirect:toIndexHome").forward(request, response);
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	
        super.postHandle(request, response, handler, modelAndView);
       
    }
}
