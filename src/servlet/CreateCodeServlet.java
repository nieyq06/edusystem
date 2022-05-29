package servlet; /**
 * Author: nyq
 * Date：2022/5/19
 * Description: 生成验证码
 * Version： 1.0
 */

import cn.dsna.util.images.ValidateCode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateCodeServlet", value = "/createCode")
public class CreateCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidateCode validateCode =new ValidateCode(200,30,4,20);
        String codes = validateCode.getCode();
        HttpSession session = request.getSession();
        session.setAttribute("codes",codes);
        //将验证码图片响应给前端
        validateCode.write(response.getOutputStream());
    }
}
