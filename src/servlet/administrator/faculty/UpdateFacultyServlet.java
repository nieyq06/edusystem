package servlet.administrator.faculty; /**
 * Author: nyq
 * Date：2022/5/27
 * Description: 介绍
 * Version： 1.0
 */

import entity.Faculty;
import service.FacultyService;
import service.FacultyService;
import service.impl.FacultyServiceImpl;
import service.impl.FacultyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateFacultyServlet", value = "/admin/safe/updateFacultyServlet")
public class UpdateFacultyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacultyService facultyService = new FacultyServiceImpl();
        Faculty faculty = new Faculty();
        faculty.setFacultyId((String) request.getParameter("infoFacultyId"));
        faculty.setFacultyName((String) request.getParameter("infoFacultyName"));

        int result = facultyService.update(faculty);
        String res = "{\"res\":\""+result+"\"}";
        response.getWriter().write(res);
    }
}
