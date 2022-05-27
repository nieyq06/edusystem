package servlet.administrator.teacher; /**
 * Author: nyq
 * Date：2022/5/23
 * Description: 介绍
 * Version： 1.0
 */

import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteTeacherServlet", value = "/admin/safe/deleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        int userid = Integer.parseInt(request.getParameter("userid"));
        int result = adminService.deleteTeacher(userid);
        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
