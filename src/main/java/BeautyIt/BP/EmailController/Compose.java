package BeautyIt.BP.EmailController;

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

@WebServlet("/Compose")
public class Compose extends HttpServlet {
    // Declaring variables for Currency And Language
    private String PageCurrency = null;
    private String language = null;
    private String country = null;
    private String Pagelanguage = null;
    private String pageLanguageName = null;
    private  String flag = null;
    private String currency = null;
    private String currencySymbol = null;
    private String userEmail =null;
    private int UserWebId = 0;
    private UsersDao usersDao = new UsersDao();
    private int CountMessages = 0;
    private int SerllerID =0;


    private List<Messaging> AdminMessagesToUsers = new ArrayList<Messaging>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            goToCompose(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            goToCompose(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void goToCompose(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        // Getting Session
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));
        System.out.println(userEmail);
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i <usersList.size(); i++) {
            UserWebId = usersList.get(i).getUserWebId();
        }
        if(UserWebId != 0){
            getLanguageAndCurrancy(request,response);
        }else {
            request.getRequestDispatcher("/WEB-INF/Admin/UserCompose.jsp").forward(request, response);
        }
    }


    private void getLanguageAndCurrancy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        // Getting Session
        HttpSession session = request.getSession(false);
        // Getting page name
        String uri = request.getRequestURI();
        String pageName = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println("pageName : " + pageName);

        // Calling currencyChecker
        CheckLanguageAndCurrency checkLanguageAndCurrency = new CheckLanguageAndCurrency();

        // responding currency value from String query
        currency = request.getParameter("PageCurrency");

        if (request.getParameter("Pagelanguage") != null) {
            String[] pLangauge = request.getParameter("Pagelanguage").split("_");
            language = pLangauge[0];
            country = pLangauge[1];
            Locale locale = new Locale(language, country);
        }

        // Sending currency value for further check
        PageCurrency = checkLanguageAndCurrency.checkCurrency(currency);
        System.out.println("PageCurrency in BP : " + PageCurrency);

        // currencySymbol = checkLanguageAndCurrency.ShowCurrencySimbole(currency);
        System.out.println("currencySymbol in BP : " + currencySymbol);

        // Sending language value for further check
        Pagelanguage = checkLanguageAndCurrency.checkLanguage(language);
        System.out.println("Pagelanguage in BP : " + Pagelanguage);

        flag = checkLanguageAndCurrency.flagValue(country);
        System.out.println("flag in BP : " + flag);
        System.out.println("Country in BP : " + country);

        pageLanguageName = checkLanguageAndCurrency.checkLanguageName(language);
        System.out.println("pageLanguageName in BP : " + pageLanguageName);

       List<Messaging> messageList = usersDao.getMessagesByUserWebId(UserWebId);
        for (int j = 0; j < messageList.size(); j++) {
            CountMessages++;
        }
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        if(checkIsSeller(userEmail)) {
            sendToSellerPage(request, response);
        }else {
            sendToUserPage(request, response);
        }
        // Request Dispatcher to Index.Jsp

    }
    private void sendToUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/UserCompose.jsp").forward(request, response);
    }

    private void sendToSellerPage(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/SellerCompose.jsp").forward(request, response);
    }
    private boolean checkIsSeller(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            SerllerID = usersList.get(i).getSellerID();
        }
        if(SerllerID != 0){
            return true;
        }else{
            return false;
        }

    }

}
