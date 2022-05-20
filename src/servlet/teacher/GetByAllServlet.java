package servlet.teacher; /**
 * Author: nyq
 * Date：2022/5/19
 * Description: 艹，json-lib-2.4-jdk15.jar和servlet-api.jar一起用会冲突，浪费了我2天时间！！！！改用=>hutool-all-5.8.1.jar
 * Version： 1.0
 */

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import entity.TeacherInfo;
import entity.User;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetByAllServlet", value = "/admin/getByAllServlet")
public class GetByAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherServiceImpl();
        List<TeacherInfo> tchs =teacherService.getByAll();

        request.setAttribute("tchs",tchs);
        String json = JSONUtil.toJsonStr(tchs);
        //System.out.println("json："+ json);

    }
}
