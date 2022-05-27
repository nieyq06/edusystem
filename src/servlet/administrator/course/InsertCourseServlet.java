package servlet.administrator.course; /**
 * Author: nyq
 * Date：2022/5/27
 * Description: 介绍
 * Version： 1.0
 */

import entity.Course;
import entity.User;
import service.AdminService;
import service.CourseService;
import service.impl.AdminServiceImpl;
import service.impl.CourseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertCourseServlet", value = "/admin/safe/insertCourseServlet")
public class InsertCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseService courseService = new CourseServiceImpl();
        Course course = new Course();
        course.setCourseId(request.getParameter("CourseId").toString());
        course.setCourseName(request.getParameter("CourseName").toString());
        course.setFacultyId(request.getParameter("FacultyId").toString());
        course.setCredit( Double.parseDouble(request.getParameter("Credit").toString()));

        int result = courseService.insert(course);
        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
