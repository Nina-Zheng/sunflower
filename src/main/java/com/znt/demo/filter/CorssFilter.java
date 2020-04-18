package com.znt.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(filterName="CorssFilter",urlPatterns="/*")
public class CorssFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //设置跨域请求
        HttpServletResponse response = (HttpServletResponse) res;
        //此处ip地址为需要访问服务器的ip及端口号
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type,Token,Accept, Connection, User-Agent, Cookie");
        response.setHeader("Access-Control-Max-Age", "3628800");

        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(request.getParameter("name"));
        System.out.println("设置跨域请求");
        chain.doFilter(req, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("过滤器初始化");
    }


}
