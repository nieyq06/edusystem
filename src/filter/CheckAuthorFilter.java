package filter;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: nyq
 * Date：2022/6/9
 * Description: 介绍
 * Version： 1.0
 */
@WebFilter(value = {"/admin/*","/tch/*","/stu/*"})
public class CheckAuthorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //权限验证
        //向下转型 拆箱
//        System.out.println("管理员");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user");
//        System.out.println(role);
        if(user == null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
