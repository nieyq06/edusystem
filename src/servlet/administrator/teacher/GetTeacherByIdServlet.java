package servlet.administrator.teacher; /**
 * Author: nyq
 * Date：2022/5/23
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.TeacherInfo;
import service.AdminService;
import service.TeacherService;
import service.impl.AdminServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetTeacherByIdServlet", value = "/admin/safe/getTeacherByIdServlet")
public class GetTeacherByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        int id = Integer.parseInt( request.getParameter("userid"));
        TeacherInfo tch = adminService.getTeacherById(id);
        String json_tch = JSONUtil.toJsonStr(tch);
        response.getWriter().write(json_tch);
        System.out.println(json_tch);

    }
}
