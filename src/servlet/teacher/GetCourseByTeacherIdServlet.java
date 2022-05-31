package servlet.teacher; /**
 * Author: nyq
 * Date：2022/5/30
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.Course;
import entity.Result;
import service.CommonService;
import service.CourseService;
import service.impl.CommonServiceImpl;
import service.impl.CourseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "GetCourseByTeacherIdServlet", value = "/tch/getCourseByTeacherIdServlet")
public class GetCourseByTeacherIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseService courseService = new CourseServiceImpl();
        int number = Integer.parseInt(request.getParameter("pageSize"));//每页条数
        int page = Integer.parseInt(request.getParameter("pageNumber"));//页码
        String teacherNo = (String)request.getParameter("teacherNo");
        String course = request.getParameter("course");

        //获取总记录数
        CommonService commonService = new CommonServiceImpl();
        long total = commonService.getCourseAllByTeacherId(course,teacherNo);
         List<Course> courseList = courseService.getAllByTeacherNo(page,number,course,teacherNo);
        //组装json
        Result result = new Result();
        result.setTotal(total);
        result.setRows(Arrays.asList(courseList.toArray()));
        String json = JSONUtil.toJsonStr(result);
        //返回json数据
        response.getWriter().write(json);
    }
}
