package servlet.administrator; /**
 * Author: nyq
 * Date：2022/5/26
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.Result;
import entity.StudentInfo;
import entity.TeacherInfo;
import service.AdminService;
import service.CommonService;
import service.impl.AdminServiceImpl;
import service.impl.CommonServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "GetStudentByAllServlet", value = "/admin/safe/getStudentByAllServlet")
public class GetStudentByAllServlet extends HttpServlet {
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

        //调用业务逻辑实现获取所有教师信息
        AdminService adminService = new AdminServiceImpl();
        //获取学生信息
        List<StudentInfo> tchs =adminService.getStudentByAll(page,number,fuzzy,faculty);
        //获取总记录数
        CommonService commonService = new CommonServiceImpl();
        long total = commonService.studentCount(fuzzy,faculty);
        System.out.println(total);
        Result result = new Result();
        result.setTotal(total);
        result.setRows(Arrays.asList(tchs.toArray()));
        String json = JSONUtil.toJsonStr(result);

        //返回json数据
        response.getWriter().write(json);

    }
}
