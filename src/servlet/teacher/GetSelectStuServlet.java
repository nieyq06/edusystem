package servlet.teacher; /**
 * Author: nyq
 * Date：2022/6/3
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.Result;
import entity.StuSelectCourse;
import entity.TeacherInfo;
import service.AdminService;
import service.CommonService;
import service.TeacherService;
import service.impl.AdminServiceImpl;
import service.impl.CommonServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "GetSelectStuServlet", value = "/tch/getSelectStuServlet")
public class GetSelectStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int number = Integer.parseInt(request.getParameter("pageSize"));//每页条数
        int page = Integer.parseInt(request.getParameter("pageNumber"));//页码


        String stuNo = request.getParameter("stuNo").toString();
        String stuName = request.getParameter("stuName").toString();
        String teacherNo = request.getParameter("teacherNo").toString();

        TeacherService teacherService = new TeacherServiceImpl();
        List<StuSelectCourse> ress =teacherService.STU_SELECT_COURSES(page,number,stuNo,stuName,teacherNo);
        CommonService commonService = new CommonServiceImpl();
        long total = commonService.cjlrCountByTeacherNo(stuNo,stuName,teacherNo);
        //获取总记录数
        Result result = new Result();
        result.setTotal(total);
        result.setRows(Arrays.asList(ress.toArray()));
        String json = JSONUtil.toJsonStr(result);

        //返回json数据
        response.getWriter().write(json);
    }
}
