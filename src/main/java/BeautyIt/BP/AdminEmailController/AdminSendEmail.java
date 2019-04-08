package BeautyIt.BP.AdminEmailController;

import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
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

@WebServlet("/AdminSendEmail")
public class AdminSendEmail extends HttpServlet {
    private String emailTo= null;
    private String  emailTitle = null;
    private String emailBody = null;
    private String userEmail = null;
    private UsersDao usersDao = new UsersDao();
    private int gettingUSerId = 0;
    private String emailFrom =null;
    private String emailRead = null;
    private String emailImportant = null;
    private int sendEmail = 0;
    private Messaging messaging;
    private int UserWebId =0;
    private int userWebId =0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        userEmail = (String) session.getAttribute("adminuser");
        emailTo = request.getParameter("emailTo");
        if(emailTo.toLowerCase().trim().equals("admin")){
            UserWebId = 1;
        }else {
            getUserId(emailTo);
        }
        try {
            goToComposeEmail(request, response,userEmail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getUserId(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            UserWebId = usersList.get(i).getUserWebId();
        }
        return UserWebId;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void goToComposeEmail(HttpServletRequest request, HttpServletResponse response, String userEmail) throws ServletException, IOException, SQLException {
        emailTo = request.getParameter("emailTo");
        emailTitle = request.getParameter("emailSubject");
        emailBody = request.getParameter("emailBody");
        emailFrom = userEmail;
        emailRead ="false";
        emailImportant = "false";


        messaging = new Messaging(UserWebId,emailFrom,emailTitle,emailBody,emailRead,emailTo,emailImportant);
        //System.out.println(emailBody + " " + MessageTitle + " " + emailTo + " " + emailRead + " " + emailImportant);
        //`UserWebId`, `FromUser`, `MessageTitle`,`Messageen`,`emailRead`,`MessageTo`,`emailImportant`
        sendEmail = usersDao.SendEmail(messaging);
        if(sendEmail==0){
            String errorMessage = "Something went wrong";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("/WEB-INF/Admin/AdminEmailSent.jsp").forward(request, response);

        }else{
            String okMessage = "Your Message sent successfully.";
            request.setAttribute("rigth", okMessage);
            request.getRequestDispatcher("/WEB-INF/Admin/AdminEmailSent.jsp").forward(request, response);
        }

    }


}
