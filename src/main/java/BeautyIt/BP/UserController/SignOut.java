package BeautyIt.BP.UserController;

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
import java.util.Random;

@WebServlet("/SignOut")
public class SignOut extends HttpServlet {
    private String userEmail = null;
    private String Pagelanguage = null;
    private String currency = null;
    private String language = null;
    private String country = null;
    private String uri = null;
    private String pageName = null;
    private CheckLanguageAndCurrency checkLanguageAndCurrency = new CheckLanguageAndCurrency();
    private String PageCurrency = null;
    private String currencySymbol = null;
    private String flag = null;
    private String pageLanguageName = null;
    private int userWebId = 0;
    private UsersDao usersDao = new UsersDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        signOut(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        signOut(request, response);
    }

    private void signOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getSession(request, response);
        getParameters(request);
        checkWebPageLanguage(Pagelanguage, request);
        checkCurrency();
        getPageName(request);
        getUserId(userEmail);
        gotoPage(request, response);

    }

    private void getSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        userEmail = String.valueOf(session.getAttribute("UserName"));
        session.invalidate();
        System.out.println("User name in profile servlet  :" + request.getSession().getAttribute("username"));



    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        request.getRequestDispatcher("SignOut.jsp").forward(request, response);
    }

    private int getUserId(String userEmail) {

        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
        }
        return userWebId;
    }

    private void checkCurrency() {
        PageCurrency = checkLanguageAndCurrency.checkCurrency(currency);
        currencySymbol = checkLanguageAndCurrency.ShowCurrencySimbole(currency);
        // Sending language value for further check
        Pagelanguage = checkLanguageAndCurrency.checkLanguage(language);
        flag = checkLanguageAndCurrency.flagValue(country);
        pageLanguageName = checkLanguageAndCurrency.checkLanguageName(language);
    }

    private void getPageName(HttpServletRequest request) {
        uri = request.getRequestURI();
        pageName = uri.substring(uri.lastIndexOf("/") + 1);
    }

    private void getParameters(HttpServletRequest request) {
        Pagelanguage = request.getParameter("Pagelanguage");
        currency = request.getParameter("PageCurrency");
    }

    private void checkWebPageLanguage(String pagelanguage, HttpServletRequest request) {
        if (request.getParameter("Pagelanguage") != null) {
            String[] pLangauge = request.getParameter("Pagelanguage").split("_");
            language = pLangauge[0];
            country = pLangauge[1];
        }
        Locale locale = new Locale(language, country);
    }
}
