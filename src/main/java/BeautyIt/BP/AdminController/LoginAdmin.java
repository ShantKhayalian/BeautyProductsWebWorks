package BeautyIt.BP.AdminController;

import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Dao.AdminDao;
import BeautyIt.BP.Dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
    private  AdminDao AdminDao = new AdminDao();
    private UsersDao usersDao = new UsersDao();
    private String username = null;
    private String password = null;
    private  String AdminSession =null;
    private int adminId = 0;
    private int CountAdminMessages =0;
    private List<Admin> adminList;
    private List<Messaging> messagingList;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdminLogin(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdminLogin(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void AdminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        username = request.getParameter("username");
        password = request.getParameter("password");

        boolean isValidUser = AdminDao.validateAdminUsers(username, password);
        // check if user is invalid and set up an error message
        if(isValidUser){
            //set up the HTTP session
            HttpSession session = request.getSession();
            //set the username as an attribute
            session.setAttribute("adminuser", username);
            AdminSession = String.valueOf(session.getAttribute("adminuser"));
            GetAllAdminInfo(username);
            sendToPage(request,response);
        } else {
            sendToLoginPage(request,response);

        }
    }

    private void sendToLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorMessage="Invalid Credentials, please login again!";
        request.setAttribute("error", errorMessage);
        request.getRequestDispatcher("/Administration/SignIn.jsp").forward(request, response);
    }

    private void sendToPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        checkEmailCount();
        request.setAttribute("adminuser",username);
        request.setAttribute("CountAdminMessages",CountAdminMessages);
        request.setAttribute("AdminPanelUsers", adminList);
        request.getRequestDispatcher("/WEB-INF/Admin/index.jsp").forward(request, response);
    }

    private void checkEmailCount() throws SQLException {
        messagingList = usersDao.getMessagesByUserWebId(adminId);
        for (int i = 0; i <messagingList.size() ; i++) {
            if(messagingList.get(i).getMessageRead().toLowerCase().trim().equals("false")){
                CountAdminMessages++;
            }
        }
    }

    private int GetAllAdminInfo(String username) {
        adminList = AdminDao.LoadAdmin(username);
        for (Admin admin : adminList) {
            adminId = admin.getAdminId();
        }
        return adminId;
    }

}
