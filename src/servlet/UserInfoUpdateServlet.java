package servlet; /**
 * Author: nyq
 * Date：2022/5/29
 * Description: 介绍
 * Version： 1.0
 */

import cn.hutool.json.JSONUtil;
import entity.User;
import service.AuthorService;
import service.CommonService;
import service.impl.AuthorServiceImpl;
import service.impl.CommonServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserInfoUpdateServlet", value = "/userInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommonService commonService = new CommonServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();

        User user = new User();
        String role = (String) request.getParameter("role");
        if(role.equals("admin")){
            user.setUserNo((String) request.getParameter("no"));
            user.setPassword((String) request.getParameter("pwd"));
            user.setTel((String) request.getParameter("tel"));
        }else if(role.equals("tch")){

        }else if(role.equals("stu")){

        }
        int result = commonService.userInfoUpdate(user,role);
        //如果修改成功则重写session
        if(result==1){
            HttpSession session = request.getSession();
            User u = authorService.login(user.getUserNo(), user.getPassword());
            String userjson = JSONUtil.toJsonStr(u);
            session.removeAttribute ("userInfo");
            session.setAttribute("userInfo",userjson);
        }

        String res = "{\"res\":\"" + result + "\"}";
        response.getWriter().write(res);
    }
}
