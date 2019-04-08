package BeautyIt.BP.UserController;

import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
    private String PageCurrency = null;
    private String Pagelanguage = null;
    private String pageLanguageName = null;
    private String flag = null;
    private String currency = null;
    private String currencySymbol = null;
    private String language = null;
    private String country = null;
    private String UserFirstName = null;
    private String UserLastName = null;
    private int userWebID = 0;
    private int CountMessages = 0;
    private int SellerId = 0;
    private String pageName = null;
    private String uri = null;
    private String isVerifiedEmail = null;
    private String emailAddress = null;
    private String Password = null;
    private String userEmail = null;
    private String isEmailRead = null;

    private List<Messaging> AdminMessagesToUsers = new ArrayList<Messaging>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkLogin(request, response);
    }


    private List<Messaging> getMessagingAdmins(int userWebID, List<Messaging> adminMessagesToUsers) {
        UsersDao userDao = new UsersDao();
        try {
            adminMessagesToUsers = userDao.getMessagesByUserWebId(userWebID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Messaging.NotificationMessageOne(language,request);
        return adminMessagesToUsers;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkLogin(request, response);
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting parameters from web site
        emailAddress = request.getParameter("emailAddress");
        Password = request.getParameter("Password");

        if (request.getParameter("PageLanguage") != null) {
            String[] pLangauge = request.getParameter("PageLanguage").split("_");
            language = pLangauge[0];
            country = pLangauge[1];
            Locale locale = new Locale(language, country);
        }

        // responding currency value from String query
        currency = request.getParameter("PageCurrency");
        // Calling currencyChecker
        CheckLanguageAndCurrency checkLanguageAndCurrency = new CheckLanguageAndCurrency();
        // Sending currency value for further check
        PageCurrency = checkLanguageAndCurrency.checkCurrency(currency);
        currencySymbol = checkLanguageAndCurrency.ShowCurrencySimbole(currency);

        // Sending language value for further check
        Pagelanguage = checkLanguageAndCurrency.checkLanguage(language);
        flag = checkLanguageAndCurrency.flagValue(country);
        pageLanguageName = checkLanguageAndCurrency.checkLanguageName(language);
        uri = request.getRequestURI();
        pageName = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println("pageName : " + pageName);

        if (request.getParameter("RememberMeCheck") != null) {
            System.out.println("RememberMeCheck in CHECKLOGIN.java : Checked");
        } else {
            System.out.println("RememberMeCheck in CHECKLOGIN.java : Not Checked");
        }
        UsersDao usersDao = new UsersDao();
        boolean isValidUser = usersDao.validateUsersLogin(emailAddress, Password);
        // check if user is invalid and set up an error message
        if (isValidUser) {
            getSession(request);
            // get adminuserName and all other infos
            List<Users> UsersList = usersDao.LoadUsersInfo(emailAddress);
            for (int i = 0; i < UsersList.size(); i++) {
                SellerId = UsersList.get(i).getSellerID();
                isVerifiedEmail = UsersList.get(i).getIsUserEmailVerified();
                if (SellerId != 0 && isVerifiedEmail.toLowerCase().trim().equals("true")) {
                    UserFirstName = UsersList.get(i).getUserFirstName();
                    UserLastName = UsersList.get(i).getUserLastName();
                    userWebID = UsersList.get(i).getUserWebId();
                    checkEmailCount();
                    getRequests(request);

                    request.getRequestDispatcher("/WEB-INF/SellerAccount.jsp?Pagelanguage=" + Pagelanguage + "&PageCurrency=" + PageCurrency)
                            .forward(request, response);
                } else {
                    UserFirstName = UsersList.get(i).getUserFirstName();
                    UserLastName = UsersList.get(i).getUserLastName();
                    userWebID = UsersList.get(i).getUserWebId();
                    AdminMessagesToUsers = getMessagingAdmins(userWebID, AdminMessagesToUsers);
                    checkEmailCount();
                    getRequests(request);

                    request.getRequestDispatcher("/WEB-INF/UsersAccount.jsp?Pagelanguage=" + Pagelanguage + "&PageCurrency=" + PageCurrency)
                            .forward(request, response);
                }
            }

        } else {
            BeautyIt.BP.Messaging.Messaging.NotificationErrorMessage(language, request, Pagelanguage);
            BeautyIt.BP.Messaging.Messaging.emailVerificationCodeErrorMessages(language, Pagelanguage, PageCurrency, request);
            getRequests(request);
            request.getRequestDispatcher("/Account.jsp?Pagelanguage=" + Pagelanguage + "&PageCurrency=" + PageCurrency)
                    .forward(request, response);
        }
    }

    private void getRequests(HttpServletRequest request) {
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("AdminMessagesToUsers", AdminMessagesToUsers);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);

    }

    private void getSession(HttpServletRequest request) {
        // set up the HTTP session
        HttpSession session = request.getSession();
        // set the username as an attribute
        session.setAttribute("UserName", emailAddress);
        userEmail = String.valueOf(session.getAttribute("UserName"));
        System.out.println("UserName in Session : " + session.getAttribute("UserName"));


    }

    private void checkEmailCount() {
        AdminMessagesToUsers = getMessagingAdmins(userWebID, AdminMessagesToUsers);
        for (int j = 0; j < AdminMessagesToUsers.size(); j++) {
            isEmailRead = AdminMessagesToUsers.get(j).getMessageRead();
            if (isEmailRead.toLowerCase().trim().equals("false")) {
                CountMessages++;
            }
        }
    }
}
