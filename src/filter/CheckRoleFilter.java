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
 * Date：2022/5/20
 * Description: 用户角色过滤器
 * Version： 1.0
 */
@WebFilter(value = "/admin/*")
public class CheckRoleFilter implements Filter {
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
        String role = user.getRoleId();
//        System.out.println(role);
        if(role!=null && (role.equals("1")||role.equals("2"))){
            filterChain.doFilter(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/login.jsp");
//            response.sendRedirect("/login.jsp");
        }

    }

    @Override
    public void destroy() {

    }
}
