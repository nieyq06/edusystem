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
        System.out.println((String) request.getParameter("CourseId"));
        System.out.println((String) request.getParameter("CourseName"));
        System.out.println((String) request.getParameter("FacultyId"));
        System.out.println((String) request.getParameter("Credit"));
        System.out.println((String) request.getParameter("TeacherNo"));


        course.setCourseId( (String) request.getParameter("CourseId"));
        course.setCourseName( (String) request.getParameter("CourseName"));
        course.setFacultyId( (String) request.getParameter("FacultyId"));
        course.setCredit( Double.parseDouble(request.getParameter("Credit")));
        course.setTeacherNo( (String) request.getParameter("TeacherNo"));

        int result = courseService.insert(course);
        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
