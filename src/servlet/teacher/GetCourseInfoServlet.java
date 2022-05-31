package servlet.teacher; /**
 * Author: nyq
 * Date：2022/5/30
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.Course;
import entity.Faculty;
import service.CourseService;
import service.FacultyService;
import service.impl.CourseServiceImpl;
import service.impl.FacultyServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetCourseInfoServlet", value = "/tch/getCourseInfoServlet")
public class GetCourseInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseService courseService = new CourseServiceImpl();
//        System.out.println((String) request.getParameter("courseId"));
        String id = (String) request.getParameter("courseId");
        Course course = courseService.getById(id);
        String json_tch = JSONUtil.toJsonStr(course);
        response.getWriter().write(json_tch);
    }
}
