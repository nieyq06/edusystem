package servlet; /**
 * Author: nyq
 * Date：2022/6/3
 * Description: 介绍
 * Version： 1.0
 */

import service.AuthorService;
import service.CourseService;
import service.impl.AuthorServiceImpl;
import service.impl.CourseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterCheckServlet", value = "/registerCheckServlet")
public class RegisterCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userno = request.getParameter("userno");
        AuthorService authorService = new AuthorServiceImpl();
        long result = authorService.registerCheck(userno);
        String res = "{\"res\":\"" + result + "\"}";
        response.getWriter().write(res);
    }
}
