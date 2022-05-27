package servlet.administrator.course; /**
 * Author: nyq
 * Date：2022/5/27
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.Course;
import entity.StudentInfo;
import service.AdminService;
import service.CourseService;
import service.impl.AdminServiceImpl;
import service.impl.CourseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetCourseByIdServlet", value = "/admin/safe/getCourseByIdServlet")
public class GetCourseByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseService courseService = new CourseServiceImpl();
        String id = (String) request.getParameter("courseId");
        Course course = courseService.getById(id);
        String json_tch = JSONUtil.toJsonStr(course);
        response.getWriter().write(json_tch);
    }
}
