package BeautyIt.BP.EmailController;

import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.AdminDao;
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

@WebServlet("/SendUserEmail")
public class SendUserEmail extends HttpServlet {
    private String userEmail = null;
    private UsersDao usersDao = new UsersDao();
    private String PageCurrency = null;
    private String Pagelanguage = null;
    private String pageLanguageName = null;
    private String flag = null;
    private String currencySymbol = null;
    private String pageName = null;
    private int UserWebToId = 0;
    private String MessageTo = null;
    private int userWebId = 0;
    private int CountMessages = 0;
    private int SerllerID = 0;
    private String emailTitle = null;
    private String emailBody = null;
    private AdminDao adminDao = new AdminDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            goToComposeEmail(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            goToComposeEmail(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void goToComposeEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        getParameters(request);
        getSession(request);
        checkWebPageLanguage(Pagelanguage, request);
        userWebId = getUserId(userEmail);
        UserWebToId = getUserToId(MessageTo);
        countMessages();
        checkIfUserToSendExsist(UserWebToId,request,response);

    }

    private void checkIfUserToSendExsist(int userWebToId,HttpServletRequest request,HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<Users> usersList = usersDao.LoadUsersByID(userWebToId);
        List<Admin> adminList = adminDao.LoadAdminById(UserWebToId);
        if (usersList.size() == 0 && adminList.size() == 0 ) {
                String message= " No Such user to email";
                sendNotFound(request,response,message);
        }else{
            SendingEmail(request, response);
        }
    }

    private void sendNotFound(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        request.getRequestDispatcher("/WEB-INF/UserChangingResults.jsp").forward(request, response);
    }

    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));
    }

    private void getParameters(HttpServletRequest request) {
        emailTitle = request.getParameter("emailSubject");
        emailBody = request.getParameter("emailBody");
        MessageTo = request.getParameter("emailTo");
        String pagelanguage = request.getParameter("Pagelanguage");


    }

    private void countMessages() throws SQLException {
        List<Messaging> messagingAdminsList = usersDao.getMessagesByUserWebId(userWebId);
        for (Messaging messaging1 : messagingAdminsList) {
            String isEmailRead = messaging1.getMessageRead();
            if (isEmailRead.toLowerCase().trim().equals("false")) {
                CountMessages++;
            } else {
                CountMessages = 0;
            }
        }
    }

    private void SendingEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String emailFrom = userEmail;
        String emailRead = "false";
        String emailImportant = "false";
        String emailTo = MessageTo;

        Messaging messaging = new Messaging(UserWebToId, emailFrom, emailTitle, emailBody, emailRead, emailTo, emailImportant);
        int sendEmail = usersDao.SendEmail(messaging);
        if (sendEmail == 0) {
            String message = "Something went wrong";
            gotoRequests(request, response, message);
        } else {
            String message = "Your Message sent successfully.";
            gotoRequests(request, response, message);

        }
    }

    private void gotoRequests(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        if (checkIsSeller(userEmail)) {
            sendToSellerPage(request, response);
        } else {
            sendToUserPage(request, response);
        }
    }

    private int getUserToId(String messageTo) {
        if (messageTo.toLowerCase().trim().equals("info@beautyproducts.am")) {
            UserWebToId = 1;
        } else {
            UsersDao usersDao = new UsersDao();
            List<Users> usersList = usersDao.LoadUsersInfo(messageTo);
            for (Users users : usersList) {
                UserWebToId = users.getUserWebId();
            }
        }
        return UserWebToId;
    }

    private void checkWebPageLanguage(String pagelanguage, HttpServletRequest request) {
        if (request.getParameter("Pagelanguage") != null) {
            String[] pLangauge = request.getParameter("Pagelanguage").split("_");
            String language = pLangauge[0];
            String country = pLangauge[1];
            Locale locale = new Locale(language, country);
            // Getting page name
            String uri = request.getRequestURI();
            pageName = uri.substring(uri.lastIndexOf("/") + 1);
            // Calling currencyChecker
            CheckLanguageAndCurrency checkLanguageAndCurrency = new CheckLanguageAndCurrency();
            // responding currency value from String query
            String currency = request.getParameter("PageCurrency");
            // Sending currency value for further check
            PageCurrency = checkLanguageAndCurrency.checkCurrency(currency);
            currencySymbol = checkLanguageAndCurrency.ShowCurrencySimbole(currency);
            // Sending language value for further check
            Pagelanguage = checkLanguageAndCurrency.checkLanguage(language);
            flag = checkLanguageAndCurrency.flagValue(country);
            pageLanguageName = checkLanguageAndCurrency.checkLanguageName(language);
        }
    }

    private int getUserId(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (Users users : usersList) {
            userWebId = users.getUserWebId();
        }
        return userWebId;
    }

    private void sendToUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/UserMessageSend.jsp").forward(request, response);
    }

    private void sendToSellerPage(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/SellerMessageSend.jsp").forward(request, response);
    }

    private boolean checkIsSeller(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            SerllerID = usersList.get(i).getSellerID();
        }
        if (SerllerID != 0) {
            return true;
        } else {
            return false;
        }
    }
}
