package servlet.stu; /**
 * Author: nyq
 * Date：2022/6/3
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.Result;
import entity.StuSelectCourse;
import service.CommonService;
import service.CourseService;
import service.TeacherService;
import service.impl.CommonServiceImpl;
import service.impl.CourseServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "StuCourseSelectionServlet", value = "/stu/stuCourseSelectionServlet")
public class StuCourseSelectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("pageSize"));//每页条数
        int page = Integer.parseInt(request.getParameter("pageNumber"));//页码


        String selectC = request.getParameter("selectC").toString();

        CourseService courseService = new CourseServiceImpl();
        List<StuSelectCourse> ress =courseService.xsxk(page,number,selectC);
        CommonService commonService = new CommonServiceImpl();
        long total = commonService.xsxk(selectC);
        //获取总记录数
        Result result = new Result();
        result.setTotal(total);
        result.setRows(Arrays.asList(ress.toArray()));
        String json = JSONUtil.toJsonStr(result);

        //返回json数据
        response.getWriter().write(json);
    }
}
