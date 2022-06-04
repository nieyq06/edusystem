package servlet.stu; /**
 * Author: nyq
 * Date：2022/6/3
 * Description: 介绍
 * Version： 1.0
 */

import service.CommonService;
import service.CourseService;
import service.impl.CommonServiceImpl;
import service.impl.CourseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StuAddCourseServlet", value = "/StuAddCourseServlet")
public class StuAddCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        String stuNo = request.getParameter("stuNo");
        CourseService courseService = new CourseServiceImpl();
        int result = courseService.stuAdd(stuNo,courseId);
        String res = "{\"res\":\"" + result + "\"}";
        response.getWriter().write(res);
    }
}
