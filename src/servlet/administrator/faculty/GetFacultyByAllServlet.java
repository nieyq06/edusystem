package servlet.administrator.faculty; /**
 * Author: nyq
 * Date：2022/5/27
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.Course;
import entity.Faculty;
import entity.Result;
import service.CommonService;
import service.CourseService;
import service.FacultyService;
import service.impl.CommonServiceImpl;
import service.impl.CourseServiceImpl;
import service.impl.FacultyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "GetFacultyByAllServlet", value = "/admin/safe/getFacultyByAllServlet")
public class GetFacultyByAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int number = Integer.parseInt(request.getParameter("pageSize"));//每页条数
        int page = Integer.parseInt(request.getParameter("pageNumber"));//页码
        String facultyId = request.getParameter("facultyId").toString();//模糊查询
        String facultyName = request.getParameter("facultyName").toString();//二级学院


        FacultyService facultyService = new FacultyServiceImpl();
        List<Faculty> faculty = facultyService.getByAll(page,number,facultyId,facultyName);
        //获取总记录数
        CommonService commonService = new CommonServiceImpl();
        long total = commonService.facultyCount(facultyId,facultyName);
        //组装json
        Result result = new Result();
        result.setTotal(total);
        result.setRows(Arrays.asList(faculty.toArray()));
        String json = JSONUtil.toJsonStr(result);
        //返回json数据
        response.getWriter().write(json);
    }
}
