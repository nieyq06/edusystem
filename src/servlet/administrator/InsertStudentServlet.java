package servlet.administrator; /**
 * Author: nyq
 * Date：2022/5/26
 * Description: 介绍
 * Version： 1.0
 */

import entity.User;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertStudentServlet", value = "/admin/safe/insertStudentServlet")
public class InsertStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        User user = new User();
        user.setUserNo(request.getParameter("UserId").toString());
        System.out.println(request.getParameter("UserId").toString());

        user.setUserName(request.getParameter("UserName").toString());
        System.out.println(request.getParameter("UserName").toString());
        user.setSex(request.getParameter("Sex").toString());
        System.out.println(request.getParameter("Sex").toString());
        user.setTel(request.getParameter("Tel").toString());
        System.out.println(request.getParameter("Tel").toString());
        user.setFacultyId(request.getParameter("FacultyId").toString());
        System.out.println(request.getParameter("FacultyId").toString());
        user.setSubjectId(request.getParameter("SubjectId").toString());
        System.out.println(request.getParameter("SubjectId").toString());

        int result = adminService.insertStudent(user);
        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
