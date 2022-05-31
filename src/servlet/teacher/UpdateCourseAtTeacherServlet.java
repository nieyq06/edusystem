package servlet.teacher; /**
 * Author: nyq
 * Date：2022/5/30
 * Description: 介绍
 * Version： 1.0
 */

import entity.Course;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCourseAtTeacherServlet", value = "/tch/updateCourseAtTeacherServlet")
public class UpdateCourseAtTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseService courseService = new CourseServiceImpl();
        Course course = new Course();
        course.setCourseId((String) request.getParameter("infoCourseId"));
        course.setCourseName((String) request.getParameter("infoCourseName"));
        course.setFacultyId((String) request.getParameter("infoFacultyId"));
        course.setCredit(Double.parseDouble(request.getParameter("infoCredit")));
        course.setTeacherNo( (String) request.getParameter("infoTeacherNo"));
        int result = courseService.update(course);
        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
