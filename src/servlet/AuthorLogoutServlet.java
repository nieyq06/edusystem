package servlet; /**
 * Author: nyq
 * Date：2022/5/28
 * Description: 介绍
 * Version： 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthorLogoutServlet", value = "/author/authorLogoutServlet")
public class AuthorLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("进入 logout.do 请求");
        session.removeAttribute("user");
        session.invalidate(); //设置session 失效
        String res = "{\"status\":\"logout\"}";
        response.getWriter().write(res);
    }
}
