package servlet.administrator.course; /**
 * Author: nyq
 * Date：2022/5/27
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

@WebServlet(name = "UpdateCourseServlet", value = "/admin/safe/updateCourseServlet")
//web/WEB-INF/classes/servlet/administrator/course/UpdateCourseServlet.class
public class UpdateCourseServlet extends HttpServlet {
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
        System.out.println(course.getCourseId()+course.getCourseName()+course.getFacultyId()+course.getCredit());
        int result = courseService.update(course);
        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
