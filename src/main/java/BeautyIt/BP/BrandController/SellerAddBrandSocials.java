package BeautyIt.BP.BrandController;

import BeautyIt.BP.Bean.Brands;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.BrandsDao;
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

@WebServlet("/SellerAddBrandSocials")
public class SellerAddBrandSocials extends HttpServlet {

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
    private String isEmailRead = null;
    private int CountMessages = 0;
    private BrandsDao brandsDao = new BrandsDao();
    private List<Brands> brandsList = new ArrayList<>();
    private List<Users> usersListSellerId = new ArrayList<>();
    private int SellerId = 0;
    private int listSizeCount = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            sellerAddBrandSocials(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            sellerAddBrandSocials(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sellerAddBrandSocials(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        getSession(request);
        getParameters(request);
        getUserId(userEmail);
        getSellerId(userWebId);
        checkIfBrandInfoExciste(SellerId);
        checkCurrency(request);
        checkWebPageLanguage(Pagelanguage, request);
        getPageName(request);
        checkEmailCount();
        gotoPage(request,response);

    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("brandsList", brandsList);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        // Request Dispatcher to UserInbox.Jsp
        request.getRequestDispatcher("WEB-INF/AddSellerSocialMedia.jsp").forward(request, response);
    }

    private int getSellerId(int userWebId) {
        usersListSellerId = usersDao.LoadUsersByID(userWebId);
        for (int i = 0; i < usersListSellerId.size(); i++) {
            SellerId = usersListSellerId.get(i).getSellerID();
        }
        return SellerId;
    }

    private int checkIfBrandInfoExciste(int userWebId) {
        brandsList = brandsDao.LoadBrandsByOwnerId(userWebId);
        for (int i = 0; i < brandsList.size(); i++) {
            listSizeCount++;
        }
        return listSizeCount;
    }

    private void checkEmailCount() throws SQLException {
        CountMessages = 0;
        List<Messaging> messagingAdminsList = usersDao.getMessagesByUserWebId(userWebId);
        for (int i = 0; i < messagingAdminsList.size(); i++) {
            isEmailRead = messagingAdminsList.get(i).getMessageRead();
            if (isEmailRead.toLowerCase().trim().equals("false")) {
                CountMessages++;
            } else {
                CountMessages = 0;
            }
        }
    }

    private int getUserId(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
        }
        return userWebId;
    }

    private void checkCurrency(HttpServletRequest request) {
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

    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));

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
