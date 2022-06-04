package servlet.teacher; /**
 * Author: nyq
 * Date：2022/6/3
 * Description: 介绍
 * Version： 1.0
 */

import entity.Course;
import service.CourseService;
import service.TeacherService;
import service.impl.CourseServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GradeEntryServlet", value = "/tch/gradeEntryServlet")
public class GradeEntryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherServiceImpl();
        String stuNo = (String) request.getParameter("stuNo");
        String courseId = (String) request.getParameter("courseId");
        double score = Double.parseDouble(request.getParameter("score"));
        int result = teacherService.updateScore(stuNo,score,courseId);
        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
