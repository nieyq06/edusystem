package servlet.administrator.faculty; /**
 * Author: nyq
 * Date：2022/5/27
 * Description: 介绍
 * Version： 1.0
 */

import service.CourseService;
import service.FacultyService;
import service.impl.CourseServiceImpl;
import service.impl.FacultyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteFacultyServlet", value = "/admin/safe/deleteFacultyServlet")
public class DeleteFacultyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacultyService facultyService = new FacultyServiceImpl();
        String id = (String) request.getParameter("facultyId");
        int result = facultyService.delete(id);

        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
