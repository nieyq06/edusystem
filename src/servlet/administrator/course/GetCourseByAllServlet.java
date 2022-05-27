package servlet.administrator.course; /**
 * Author: nyq
 * Date：2022/5/27
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.Course;
import entity.Result;
import entity.StudentInfo;
import service.AdminService;
import service.CommonService;
import service.CourseService;
import service.impl.AdminServiceImpl;
import service.impl.CommonServiceImpl;
import service.impl.CourseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "GetCourseByAllServlet", value = "/admin/safe/getCourseByAllServlet")
public class GetCourseByAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int number = Integer.parseInt(request.getParameter("pageSize"));//每页条数
        int page = Integer.parseInt(request.getParameter("pageNumber"));//页码
        String fuzzy = request.getParameter("selectFuzzy").toString();//模糊查询
        String faculty = request.getParameter("selectFaculty").toString();//二级学院


        CourseService courseService = new CourseServiceImpl();
        List<Course> courses =courseService.getByAll(page,number,fuzzy,faculty);
        //获取总记录数
        CommonService commonService = new CommonServiceImpl();
        long total = commonService.courseCount(fuzzy,faculty);
        //组装json
        Result result = new Result();
        result.setTotal(total);
        result.setRows(Arrays.asList(courses.toArray()));
        String json = JSONUtil.toJsonStr(result);
        //返回json数据
        response.getWriter().write(json);
    }
}
