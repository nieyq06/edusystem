package servlet.administrator.faculty; /**
 * Author: nyq
 * Date：2022/5/27
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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetFacultyByIdServlet", value = "/admin/safe/getFacultyByIdServlet")
public class GetFacultyByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacultyService facultyService = new FacultyServiceImpl();
        String id = (String) request.getParameter("facultyId");
        Faculty faculty = facultyService.getById(id);
        String json_tch = JSONUtil.toJsonStr(faculty);
        response.getWriter().write(json_tch);
    }
}
