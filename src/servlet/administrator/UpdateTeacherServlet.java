package servlet.administrator; /**
 * Author: nyq
 * Date：2022/5/23
 * Description: 介绍
 * Version： 1.0
 */

import entity.User;
import service.AdminService;
import service.TeacherService;
import service.impl.AdminServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateTeacherServlet", value = "/admin/safe/updateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        User user = new User();
        user.setUserId(Integer.parseInt(request.getParameter("infoUserId")));
        user.setUserNo(request.getParameter("infoUserNo"));
        user.setUserName(request.getParameter("infoUsername"));
        user.setSex(request.getParameter("infoSex"));
        user.setTel(request.getParameter("infoTel"));
        user.setFacultyId(request.getParameter("infoFaculty"));
        user.setMajorCourse(request.getParameter("infoCourse"));
        int result= adminService.updateTeacher(user);

        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
