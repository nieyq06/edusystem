package servlet.administrator; /**
 * Author: nyq
 * Date：2022/5/26
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.StudentInfo;
import entity.TeacherInfo;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetStudentByIdServlet", value = "/admin/safe/getStudentByIdServlet")
public class GetStudentByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        int id = Integer.parseInt( request.getParameter("userid"));
        StudentInfo tch = adminService.getStudentById(id);
        String json_tch = JSONUtil.toJsonStr(tch);
        response.getWriter().write(json_tch);
    }
}
