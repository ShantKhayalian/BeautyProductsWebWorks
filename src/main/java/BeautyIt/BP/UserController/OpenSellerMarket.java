package BeautyIt.BP.UserController;

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
import java.util.List;
import java.util.Locale;
import java.util.Random;

@WebServlet("/OpenSellerMarket")
public class OpenSellerMarket extends HttpServlet {

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
    private Random random = new Random();
    private int SellerNewID = 0;
    private int UserAdded = 0;
    private UsersDao usersDao = new UsersDao();
    private String isEmailRead =null;
    private int CountMessages =0;
    private String brandName = null;
    private String brandCategory = null;
    private String brandAddress1 = null;
    private String brandAddress2 = null;
    private String brandCountry = null;
    private String brandCity = null;
    private String brandState = null;
    private String brandZipCode = null;
    private String brandPhoneNumber = null;
    private String brandKind = null;
    private int checkaddingToDatabase = 0;
    private BrandsDao brandsDao = new BrandsDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            openSellerMarket(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            openSellerMarket(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void openSellerMarket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        getSession(request);
        getParameters(request);
        checkWebPageLanguage(Pagelanguage, request);
        checkCurrency();
        getPageName(request);
        getUserId(userEmail);
        checkEmailCount();
        createNewSellerCode();
        createSellerBRandSectionInDtaa(request, response);
        addSellerAccount(request,response);
        getSellerWebId(userWebId);

    }

    private void checkEmailCount() throws SQLException {
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

    private int getSellerWebId(int userWebId) {
        List<Users> usersList = usersDao.LoadUsersByID(userWebId);
        for (int i = 0; i < usersList.size(); i++) {
            SellerNewID = usersList.get(i).getSellerID();
        }
        return SellerNewID;
    }

    private int createNewSellerCode() {
        SellerNewID = random.nextInt(10000) + 99999;
        return SellerNewID;
    }

    private void addSellerAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdded = usersDao.ChangeUSerToSeller(userWebId, SellerNewID);
        if (UserAdded == 0) {
            String message = "Something went wrong Please try again";
            gotoPage(request, response,message);

        } else {
            String message = "You successfully activate your Seller account, \n please logout and reSign in to take affect";
            gotoPage(request, response,message);
        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response,String message) throws ServletException, IOException {
        request.setAttribute("rigth", message);
        request.setAttribute("error", message);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        // Request Dispatcher to UserInbox.Jsp
        request.getRequestDispatcher("WEB-INF/ConfirmSellerAccount.jsp").forward(request, response);

    }

    private void createSellerBRandSectionInDtaa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        brandName = "null";
        brandCategory = "null";
        brandAddress1 = "null";
        brandAddress2 = "null";
        brandCountry = "null";
        brandCity = "null";
        brandState = "null";
        brandZipCode = "null";
        brandZipCode = "null";
        brandKind = "null";
        brandPhoneNumber = "0";

        Brands brands = new Brands(SellerNewID, userWebId, userEmail, brandName, brandCategory, brandAddress1, brandAddress2, brandCountry, brandCity, brandState, brandZipCode, brandPhoneNumber, brandKind, "false", "false", "false");
        checkaddingToDatabase = brandsDao.AddBrand(brands);
    }


    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));
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
