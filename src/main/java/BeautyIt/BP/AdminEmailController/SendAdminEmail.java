package BeautyIt.BP.AdminEmailController;

import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
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

@WebServlet("/SendAdminEmail")
public class SendAdminEmail extends HttpServlet {
    private String userEmail = null;
    private String emailTo = null;
    private String emailTitle = null;
    private String emailBody = null;
    private UsersDao usersDao = new UsersDao();
    private Messaging messaging;
    private String emailFrom = null;
    private String emailRead = null;
    private String emailImportant = null;
    private int sendEmail = 0;
    private int UserWebId = 0;
    private int userId = 0;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            sendAdminEmail(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            sendAdminEmail(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sendAdminEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        getSession(request);
        getParametersFromWeb(request);
        getUserId(emailTo);
        getAdminId(userEmail);
        addToDatabase(request, response);

    }

    private void getUserId(String emailTo) {
        List<Users> usersList = usersDao.LoadUsersInfo(emailTo);
        for (int i = 0; i <usersList.size() ; i++) {
            userId = usersList.get(i).getUserWebId();
        }
    }

    private int getAdminId(String userEmail) {
        AdminDao adminDao = new AdminDao();
        List<Admin> adminList = adminDao.LoadAdminByEmail(userEmail);
        for (int i = 0; i < adminList.size(); i++) {
            UserWebId = adminList.get(i).getAdminId();
        }
        return UserWebId;
    }

    private void addToDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        messaging = new Messaging(userId, emailFrom, emailTitle, emailBody, emailRead, emailTo, emailImportant);
        sendEmail = usersDao.SendEmail(messaging);
        if (sendEmail == 0) {
            String errorMessage = "Something went wrong";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("/WEB-INF/Admin/AdminSendMessage.jsp").forward(request, response);

        } else {
            String okMessage = "Your Message sent successfully.";
            request.setAttribute("rigth", okMessage);
            request.getRequestDispatcher("/WEB-INF/Admin/AdminSendMessage.jsp").forward(request, response);
        }

    }

    private void getParametersFromWeb(HttpServletRequest request) {
        emailTo = request.getParameter("emailTo");
        System.out.println("emailto : " + emailTo);
        emailTitle = request.getParameter("emailSubject");
        System.out.println("emailSubject : " + emailTitle);
        emailBody = request.getParameter("emailBody");
        emailFrom = userEmail;
        System.out.println("emailFrom : " + emailFrom);
        emailRead = "false";
        emailImportant = "false";
    }

    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("adminuser"));
        System.out.println("userEmail : " + userEmail);
    }

}
