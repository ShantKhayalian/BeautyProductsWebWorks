package BeautyIt.BP.AdminEmailController;

import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Dao.UsersDao;
import BeautyIt.BP.Localization.Controller.CheckLanguageAndCurrency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

@WebServlet("/ReplayAdminMessages")
public class ReplayAdminMessages extends HttpServlet {
    private String userEmail = null;
    private String emailId = null;
    private int emailIdFromString = 0;
    private String PageCurrency = null;
    private String language = null;
    private String country = null;
    private String Pagelanguage = null;
    private String pageLanguageName = null;
    private String flag = null;
    private String currency = null;
    private String currencySymbol = null;
    private int userWebId = 0;
    private int userToWebId = 0;
    private String pageName = null;
    private String uri = null;
    private UsersDao usersDao = new UsersDao();
    private String pagelanguage = null;
    private String isEmailRead = null;
    private int CountMessages = 0;
    private String toUserEmail = null;
    private String messageTitle= null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ReplayToMessages(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ReplayToMessages(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ReplayToMessages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("adminuser"));
        System.out.println("userEmail : " + userEmail);
        toUserEmail = request.getParameter("MessageTo");
        System.out.println("toUserEmail : " + toUserEmail);
        emailId = request.getParameter("emailId");
        System.out.println("emailId : " + emailId);

        UsersDao usersDao = new UsersDao();
        List<Messaging> mesageById = usersDao.getMessagesById(Integer.parseInt(emailId));
        for (int i = 0; i <mesageById.size() ; i++) {
            messageTitle = mesageById.get(i).getMessageTitle();
        }
        sendToPage(request, response);

    }

    private void sendToPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("messageTitle",messageTitle);
        request.setAttribute("toUserEmail", toUserEmail);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("CountMessages", CountMessages);

        request.getRequestDispatcher("/WEB-INF/Admin/AdminEmailReplay.jsp").forward(request, response);
    }


}
