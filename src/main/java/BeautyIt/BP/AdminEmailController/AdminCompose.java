package BeautyIt.BP.AdminEmailController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AdminCompose")
public class AdminCompose extends HttpServlet {
    private int userWebId = 0;
    private String userEmail = null;
    private String AdminEmail =null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adminCompose(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adminCompose(request, response);
    }

    private void adminCompose(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getSession(request);
        getParameters(request,response);
        gotoRequestPage(request,response);
    }

    private void gotoRequestPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("AdminEmail",AdminEmail);
        request.setAttribute("userWebId",userWebId);
        request.setAttribute("userEmail",userEmail);
        request.getRequestDispatcher("/WEB-INF/Admin/AdminCompose.jsp").forward(request, response);
    }

    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        AdminEmail = String.valueOf(session.getAttribute("adminuser"));
        System.out.println("adminuser : " + userEmail);
    }

    private void getParameters(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        if(userEmail != null && userWebId != 0) {
            userWebId = Integer.parseInt(request.getParameter("userWebId"));
            userEmail = request.getParameter("userEmail");
        }else{
            gotoRequestPage(request,response);
        }
    }
}
