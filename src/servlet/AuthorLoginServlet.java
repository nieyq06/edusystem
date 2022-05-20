package servlet; /**
 * Author: nyq
 * Date：2022/5/19
 * Description: 介绍
 * Version： 1.0
 */

import entity.Faculty;
import entity.User;
import service.AuthorService;
import service.FacultyService;
import service.impl.AuthorServiceImpl;
import service.impl.FacultyServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuthorLoginServlet", value = "/author/AuthorLoginServlet")
public class AuthorLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.收参
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");
        System.out.println(username+":"+password+":"+inputVcode);
        //2.校验验证码
        String codes = (String) request.getSession().getAttribute("codes");
        if(!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)){
            //调用业务逻辑实现登录
            AuthorService authorService = new AuthorServiceImpl();
            FacultyService facultyService = new FacultyServiceImpl();
            User user = authorService.login(username,password);
            if (user != null) {
                //登录成功
                //存储在session作用域
                HttpSession session = request.getSession();
                session.setAttribute("user",user);

                //session.setAttribute("role",user.getRoleId());
                //System.out.println(session.getAttribute("role"));

                List<Faculty> faculty = facultyService.getByAll();
                request.setAttribute("faculty",faculty);

                //跳转到首页
                if(user.getRoleId().equals("1")){
                    response.sendRedirect(request.getContextPath() + "/mgr/index.jsp");
                }else if(user.getRoleId().equals("2")){
                    response.sendRedirect(request.getContextPath() + "/tch/index.jsp");
                }else if(user.getRoleId().equals("3")){
                    response.sendRedirect(request.getContextPath() + "/stu/index.jsp");
                }
            }else{
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
