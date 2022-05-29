package servlet; /**
 * Author: nyq
 * Date：2022/5/29
 * Description: 介绍
 * Version： 1.0
 */

import service.CommonService;
import service.impl.CommonServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserUpdatePwdServlet", value = "/userUpdatePwdServlet")
public class UserUpdatePwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userNo = request.getParameter("userNo");
        String newPwd = request.getParameter("newPwd");
        String oldPwd = request.getParameter("oldPwd");
        CommonService commonService = new CommonServiceImpl();
        int result = commonService.userUpdatePwd(newPwd,oldPwd,userNo);
        String res = "{\"res\":\"" + result + "\"}";
        response.getWriter().write(res);

    }
}
