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
import java.util.Random;

@WebServlet("/SellerAddNewBrand")
public class SellerAddNewBrand extends HttpServlet {
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
    private String BrandName = null;
    private String BrandCategory = null;
    private String BrandType = null;
    private String BrandAddress1 = null;
    private String BrandAddress2 = null;
    private String BrandCountry = null;
    private String BrandCity = null;
    private String BrandZipCode = null;
    private String BrandState = null;
    private String BrandPhoneNumber = null;
    private int brandWebId = 0;
    private int brandOwnerId = 0;
    private String brandOwnerEmail = null;
    private Random random = new Random();
    private String brandOwnerName = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            sellerAddNewBrand(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            sellerAddNewBrand(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sellerAddNewBrand(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        getSession(request);
        getParameters(request);
        getUserId(userEmail);
        getSellerId(userWebId);
        checkIfBrandInfoExciste(SellerId);
        checkCurrency();
        checkWebPageLanguage(Pagelanguage, request);
        getPageName(request);
        checkEmailCount();
        if (checkBrandOwnerShip(SellerId, brandOwnerId, userEmail, brandOwnerEmail)) {
            if (CheckBrandNameing(BrandName, brandOwnerName, request, response)) {
                if (!BrandName.isEmpty()) {
                    UpdateBrandData(request, response);
                } else {
                    AddNewBrandToData(request, response);
                }
            } else {
                String message = "Sorry the brand already excise";
                requestPage(request, response, message);
            }
        }else {
            String message = "Sorry something went wrong";
            requestPage(request, response, message);
        }

    }

    private void UpdateBrandData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brands brands = new Brands(brandOwnerEmail, BrandCategory, BrandAddress1, BrandAddress2, BrandCountry, BrandCity, BrandState, BrandZipCode, BrandPhoneNumber, BrandType);
        int brandAddedTpData = brandsDao.UpdateBrandById(brands, brandWebId);
        if (brandAddedTpData == 0) {
            String message = "Something went wrong please try later";
            requestPage(request, response, message);
        } else {
            String message = "Congratulations your brand updated.";
            requestPage(request, response, message);
        }

    }

    private boolean CheckBrandNameing(String brandName, String brandOwnerName, HttpServletRequest request, HttpServletResponse response) {
        return brandName.equals(brandOwnerName);
    }

    private void AddNewBrandToData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        brandWebId = random.nextInt(100000) + 9999999;
        Brands brands = new Brands(brandWebId, SellerId, userEmail, BrandName, BrandCategory, BrandAddress1, BrandAddress2, BrandCountry, BrandCity, BrandState, BrandZipCode, BrandPhoneNumber, BrandType);
        int brandAddedTpData = brandsDao.AddBrand(brands);
        if (brandAddedTpData == 0) {
            String message = "Something went wrong please try later";
            requestPage(request, response, message);
        } else {
            String message = "Congratulations your brand added and you are ready for next steps.";
            requestPage(request, response, message);
        }
    }

    private void requestPage(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.setAttribute("brandsList", brandsList);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        request.getRequestDispatcher("WEB-INF/SellerChangingResults.jsp").forward(request, response);

    }

    private boolean checkBrandOwnerShip(int sellerId, int brandOwnerId, String userEmail, String brandOwnerEmail) {
        return sellerId == brandOwnerId || userEmail.equals(brandOwnerEmail);

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

    private void getPageName(HttpServletRequest request) {
        uri = request.getRequestURI();
        pageName = uri.substring(uri.lastIndexOf("/") + 1);
    }


    private void checkWebPageLanguage(String pagelanguage, HttpServletRequest request) {
        if (request.getParameter("Pagelanguage") != null) {
            String[] pLangauge = request.getParameter("Pagelanguage").split("_");
            language = pLangauge[0];
            country = pLangauge[1];
        }
        Locale locale = new Locale(language, country);
    }

    private void checkCurrency() {
        PageCurrency = checkLanguageAndCurrency.checkCurrency(currency);
        currencySymbol = checkLanguageAndCurrency.ShowCurrencySimbole(currency);
        // Sending language value for further check
        Pagelanguage = checkLanguageAndCurrency.checkLanguage(language);
        flag = checkLanguageAndCurrency.flagValue(country);
        pageLanguageName = checkLanguageAndCurrency.checkLanguageName(language);
    }


    private int checkIfBrandInfoExciste(int userWebId) {
        brandsList = brandsDao.LoadBrandsByOwnerId(userWebId);
        for (int i = 0; i < brandsList.size(); i++) {
            brandWebId = brandsList.get(i).getBrandWebId();
            brandOwnerId = brandsList.get(i).getBrandOwnerId();
            brandOwnerEmail = brandsList.get(i).getBrandOwnerEmail();
            brandOwnerName = brandsList.get(i).getBrandName();
            listSizeCount++;
        }
        return listSizeCount;
    }

    private int getSellerId(int userWebId) {
        usersListSellerId = usersDao.LoadUsersByID(userWebId);
        for (int i = 0; i < usersListSellerId.size(); i++) {
            SellerId = usersListSellerId.get(i).getSellerID();
        }
        return SellerId;
    }


    private int getUserId(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
        }
        return userWebId;
    }

    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));

    }

    private void getParameters(HttpServletRequest request) {
        Pagelanguage = request.getParameter("Pagelanguage");
        currency = request.getParameter("PageCurrency");
        BrandName = request.getParameter("BrandName");
        BrandCategory = request.getParameter("BrandCategory");
        BrandType = request.getParameter("BrandType");
        BrandAddress1 = request.getParameter("BrandAddress1");
        BrandAddress2 = request.getParameter("BrandAddress2");
        BrandCountry = request.getParameter("BrandCountry");
        BrandCity = request.getParameter("BrandCity");
        BrandZipCode = request.getParameter("BrandZipCode");
        BrandState = request.getParameter("BrandState");
        BrandPhoneNumber = request.getParameter("BrandPhoneNumber");
    }
}
