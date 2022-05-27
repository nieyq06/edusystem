package servlet; /**
 * Author: nyq
 * Date：2022/5/19
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.Course;
import entity.Faculty;
import entity.Subject;
import entity.User;
import service.AuthorService;
import service.CourseService;
import service.FacultyService;
import service.SubjectService;
import service.impl.AuthorServiceImpl;
import service.impl.CourseServiceImpl;
import service.impl.FacultyServiceImpl;
import service.impl.SubjectServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuthorLoginServlet", value = "/author/AuthorLoginServlet")
public class AuthorLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.收参
        String userno = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");
        //System.out.println(username+":"+password+":"+inputVcode);
        //2.校验验证码
        String codes = (String) request.getSession().getAttribute("codes");
        System.out.println(userno+"\t"+password+"\t"+inputVcode);
        System.out.println("验证码");
        System.out.println(codes);
        if (!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)) {
            //调用业务逻辑实现登录
            AuthorService authorService = new AuthorServiceImpl();
            FacultyService facultyService = new FacultyServiceImpl();
            CourseService courseService = new CourseServiceImpl();
            SubjectService subjectService = new SubjectServiceImpl();

            User user = authorService.login(userno, password);
            System.out.println(user);
            if (user != null) {
                //登录成功
                //存储在session作用域
                //获取用户
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                //获取二级学院信息
                List<Faculty> faculty = facultyService.getByAll_cache();
                session.setAttribute("faculty", faculty);
                //获取课程信息
                List<Course> courses = courseService.getByAll_cache();
                String coursesjson = JSONUtil.toJsonStr(courses);
                session.setAttribute("courses", coursesjson);
                //获取所有专业信息
                List<Subject> subjects = subjectService.getByAll_cache();
                String subjectsjson = JSONUtil.toJsonStr(subjects);
                session.setAttribute("subjects", subjectsjson);


                //登录成功后返回角色id
                String res = "{\"role\":\"" + user.getRoleId() + "\",\"u\":\"0\"}";
                response.getWriter().write(res);

            } else {
                String res = "{\"role\":\"\",\"u\":\"-1\"}";
                response.getWriter().write(res);
            }
        }else {
            String res = "{\"role\":\"\",\"u\":\"-2\"}";
            response.getWriter().write(res);

        }
    }
}
