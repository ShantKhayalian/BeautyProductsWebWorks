package BeautyIt.BP.EmailController;

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
import java.util.List;
import java.util.Locale;

@WebServlet("/ReplayMessages")
public class ReplayMessages extends HttpServlet {
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
    private int SerllerID =0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReplayToMessages(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ReplayToMessages(request, response);

    }

    private void ReplayToMessages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));
        toUserEmail =  request.getParameter("MessageTo");
        pagelanguage = request.getParameter("Pagelanguage");
        checkWebPageLanguage(Pagelanguage, request);
        sendToPage(request, response);

    }

    private void sendToPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("toUserEmail", toUserEmail);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
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
        // Request Dispatcher to Index.Jsp
    }

    private void sendToUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/UserReplay.jsp").forward(request, response);

    }

    private void sendToSellerPage(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/SellerReplay.jsp").forward(request, response);
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


    private void checkWebPageLanguage(String pagelanguage, HttpServletRequest request) {
        if (request.getParameter("Pagelanguage") != null) {
            String[] pLangauge = request.getParameter("Pagelanguage").split("_");
            language = pLangauge[0];
            country = pLangauge[1];
            Locale locale = new Locale(language, country);
            // Getting page name
            uri = request.getRequestURI();
            pageName = uri.substring(uri.lastIndexOf("/") + 1);
            // Calling currencyChecker
            CheckLanguageAndCurrency checkLanguageAndCurrency = new CheckLanguageAndCurrency();
            // responding currency value from String query
            currency = request.getParameter("PageCurrency");
            // Sending currency value for further check
            PageCurrency = checkLanguageAndCurrency.checkCurrency(currency);
            currencySymbol = checkLanguageAndCurrency.ShowCurrencySimbole(currency);
            // Sending language value for further check
            Pagelanguage = checkLanguageAndCurrency.checkLanguage(language);
            flag = checkLanguageAndCurrency.flagValue(country);
            pageLanguageName = checkLanguageAndCurrency.checkLanguageName(language);
        }
    }

}
