package BeautyIt.BP.AdminEmailController;

import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdminEmailUsersList")
public class AdminEmailUsersList extends HttpServlet {
    private String userEmail =null;
    UsersDao usersDao = new UsersDao();
    private  List<Users> usersList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adminEmailUsersList(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adminEmailUsersList(request,response);
    }

    private void adminEmailUsersList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getSession(request);
        getUsersListToSendEmail();
        gotoRequestPage(request,response);

    }

    private void gotoRequestPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usersList",usersList);
        request.getRequestDispatcher("/WEB-INF/Admin/AdminToSendUsersEmail.jsp").forward(request, response);
    }

    private void getUsersListToSendEmail() {
       usersList = usersDao.LoadAllUsers();
    }

    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("adminuser"));
        System.out.println("adminuser : " + userEmail);
    }
}
