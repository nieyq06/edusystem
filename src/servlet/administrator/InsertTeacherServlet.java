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

@WebServlet(name = "InsertTeacherServlet", value = "/admin/safe/insertTeacherServlet")
public class InsertTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        User user = new User();
        user.setUserNo(request.getParameter("UserId").toString());
        user.setUserName(request.getParameter("UserName").toString());
        user.setSex(request.getParameter("Sex").toString());
        user.setTel(request.getParameter("Tel").toString());
        user.setFacultyId(request.getParameter("FacultyId").toString());
        user.setMajorCourse(request.getParameter("CourseId").toString());

        int result = adminService.insertTeacher(user);
        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
