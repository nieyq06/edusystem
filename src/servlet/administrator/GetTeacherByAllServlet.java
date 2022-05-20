package servlet.administrator; /**
 * Author: nyq
 * Date：2022/5/19
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import entity.TeacherInfo;
import entity.User;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetTeacherByAllServlet", value = "/admin/safe/getTeacherByAllServlet")
public class GetTeacherByAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用业务逻辑实现获取所有教师信息
        TeacherService teacherService = new TeacherServiceImpl();
        List<TeacherInfo> tchs =teacherService.getByAll();

        request.setAttribute("tchs",tchs);
        String json = JSONUtil.toJsonStr(tchs);
        response.getWriter().write(json);

        System.out.println("json："+ json);
    }
}
