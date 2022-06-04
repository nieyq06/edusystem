package servlet; /**
 * Author: nyq
 * Date：2022/6/3
 * Description: 介绍
 * Version： 1.0
 */

import entity.User;
import service.AuthorService;
import service.impl.AuthorServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setUserNo((String) request.getParameter("userno"));
        user.setPassword((String) request.getParameter("password"));
        user.setUserName((String) request.getParameter("username"));
        user.setSex((String) request.getParameter("sex"));
        user.setSubjectId((String) request.getParameter("subjectId"));
        user.setFacultyId((String) request.getParameter("facultyId"));
        user.setTel((String) request.getParameter("tel"));

        AuthorService authorService = new AuthorServiceImpl();
        long result = authorService.register(user);
        String res = "{\"res\":\"" + result + "\"}";
        response.getWriter().write(res);
    }
}
