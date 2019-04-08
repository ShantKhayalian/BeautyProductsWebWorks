package BeautyIt.BP.UserController;

import BeautyIt.BP.Bean.AddressBox;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.AddressBoxDao;
import BeautyIt.BP.Dao.UsersDao;
import BeautyIt.BP.EmailController.SendingVerificationEmail;
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

@WebServlet("/RegisterUser")

public class RegisterUser extends HttpServlet {
    // Declaring Variables
    private String PageCurrency = null;
    private String Pagelanguage = null;
    private String pageLanguageName = null;
    private String flag = null;
    private String currency = null;
    private String currencySymbol = null;
    private String language = null;
    private String country = null;
    private Users users;
    private Messaging messaging;
    private Messaging messagingWelcome;
    private int AddUser = 0;
    private int AddMessages = 0;
    private String enMessage = null;
    private String MessageRead = null;
    private String MessageDelete = null;
    private String messageTilte = null;
    private String messageFrom = null;
    private int addressBoxAddInfoCheck = 0;
    private int addressBoxAddSupportCheck = 0;
    private String seesionID = null;
    private AddressBoxDao addressBoxDao = new AddressBoxDao();
    private String uri = null;
    private String pageName = null;
    private String RegisterEmail = null;
    private String RegisterPassword = null;
    private Random rand = new Random();
    private UsersDao ud = new UsersDao();
    private CheckLanguageAndCurrency checkLanguageAndCurrency = new CheckLanguageAndCurrency();
    private int userWebID = 0;
    private String randomNumberForAddress = null;
    private String randomNumberForPhone = null;
    private List<Users> CheckUSerEmailInput = new ArrayList<>();
    private AddressBox addressBoxAddInfo;
    private AddressBox addressBoxAddSupport;
    private String LanguageWithEmail = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registerUser(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registerUser(request, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCarachterOfWeb(response);
        gettingSession(request);
        getingPageName(request);
        getParameters(request);
        getLanguage(request);
        checkLanguage();
        randomiseVerifications();

        checkUserEmailInput(request, response);
    }


    /**
     * Method to filter the web page for UTF-8
     * @param response
     */
    private void setCarachterOfWeb(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
    }

    /**
     * Checking of the user email already in the database at register
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void checkUserEmailInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckUSerEmailInput = ud.LoadUserEmailForChecking(RegisterEmail);
        if (CheckUSerEmailInput.size() != 0) {

            BeautyIt.BP.Messaging.Messaging.NotificationErrorCheckUSerEmailInput(language, request, pageLanguageName);
            // Send Responses to page
            request.setAttribute("currencySymbol", currencySymbol);
            request.setAttribute("pageLanguageName", pageLanguageName);
            request.setAttribute("PageCurrency", PageCurrency);
            request.setAttribute("flag", flag);
            request.setAttribute("Pagelanguage", Pagelanguage);
            request.setAttribute("PageName", pageName);
            request.getRequestDispatcher("/RegistrationComplite.jsp?language=" + Pagelanguage + "&PageCurrency=" + PageCurrency).forward(request, response);
        } else {
            UserEmailInputPassedWithNon(request, response);
        }
    }

    /**
     * If user email not registered in the database prepare new emails to send to the inbox in the user admin panel
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void UserEmailInputPassedWithNon(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        addressBoxAddInfo = new AddressBox(userWebID, "null", RegisterEmail, 1, "Admin(info)", "Informations");
        addressBoxAddSupport = new AddressBox(userWebID, "null", RegisterEmail, 1, "Admin(support)", "Support");
        prepareEmailsAndAddToDatabase(request, response);

    }

    /**
     * Write 2 emails and send it to the database to be checked by user in user panel and add user to database
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void prepareEmailsAndAddToDatabase(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        users = new Users(userWebID, RegisterEmail, RegisterPassword, "false", "false", "false", seesionID,
                randomNumberForAddress, randomNumberForPhone);

        messageFrom = "info@beautyproducts.am";
        messageTilte = "Welcome to our web Site";
        enMessage = "Welcome to our web Site";
        MessageRead = "false";
        MessageDelete = "false";
        messaging = new Messaging(userWebID, messageFrom, messageTilte, enMessage, MessageRead, RegisterEmail, "true");
        //Welcome message
        enMessage = "Please finish your profile.";
        messageTilte = "Please finish your profile.";
        MessageRead = "false";
        MessageDelete = "false";
        messageFrom = "info@beautyproducts.am";
        messagingWelcome = new Messaging(userWebID, messageFrom, messageTilte, enMessage, MessageRead, RegisterEmail, "true");
        try {
            addressBoxAddInfoCheck = addressBoxDao.AddToAddressBox(addressBoxAddInfo);
            addressBoxAddSupportCheck = addressBoxDao.AddToAddressBox(addressBoxAddSupport);
            AddMessages = ud.AddMessagesFromAdmin(messaging);
            AddMessages = ud.AddMessagesFromAdmin(messagingWelcome);
        } catch (SQLException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }
        AddUser = ud.AddUser(users);
        if (AddUser == 0) {
        } else {
            sendEmailVerificationToUser(request, response,LanguageWithEmail);
        }
    }

    /**
     * Calling send email method to send verification email to user email inbox
     * @param request
     * @param response
     * @param LanguageWithEmail
     * @throws IOException
     * @throws ServletException
     */
    private void sendEmailVerificationToUser(HttpServletRequest request, HttpServletResponse response, String LanguageWithEmail) throws IOException, ServletException {
        SendingVerificationEmail.SendVerificationEmail(userWebID, seesionID, language, RegisterEmail, request, response,
                currency, LanguageWithEmail);
        gotoPage(request, response);

    }

    /**
     * After alll finished sending user to proper page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void gotoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BeautyIt.BP.Messaging.Messaging.NotificationOkCheckUSerEmailInput(language, request, pageLanguageName);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);

        request.getRequestDispatcher(
                "/RegistrationComplite.jsp?language=" + Pagelanguage + "&PageCurrency=" + PageCurrency)
                .forward(request, response);
    }

    /**
     * Randomissing user email verification code. phone ver. code, and address ver. code
     */
    private void randomiseVerifications() {
        userWebID = rand.nextInt(999999);
        randomNumberForAddress = String.valueOf(rand.nextInt(99999));
        randomNumberForPhone = String.valueOf(rand.nextInt(9999));
    }

    /**
     * Checking the language of the web page, returning the same configurations to the next page
     */
    private void checkLanguage() {
        PageCurrency = checkLanguageAndCurrency.checkCurrency(currency);
        currencySymbol = checkLanguageAndCurrency.ShowCurrencySimbole(currency);
        // Sending language value for further check
        Pagelanguage = checkLanguageAndCurrency.checkLanguage(language);
        flag = checkLanguageAndCurrency.flagValue(country);
        pageLanguageName = checkLanguageAndCurrency.checkLanguageName(language);
    }

    /**
     * getting the language from the web
     * @param request
     */
    private void getLanguage(HttpServletRequest request) {

        if (request.getParameter("PageLanguage") != null) {
            LanguageWithEmail = request.getParameter("PageLanguage");
            String[] pLangauge = request.getParameter("PageLanguage").split("_");
            language = pLangauge[0];
            country = pLangauge[1];
            Locale locale = new Locale(language, country);
        }
    }

    /**
     * getting parameters from String query
     * @param request
     */
    private void getParameters(HttpServletRequest request) {
        RegisterEmail = request.getParameter("emailAddress");
        RegisterPassword = request.getParameter("Password");
        currency = request.getParameter("PageCurrency");
    }

    /**
     * Knowing the last page name
     * @param request
     */
    private void getingPageName(HttpServletRequest request) {
        uri = request.getRequestURI();
        pageName = uri.substring(uri.lastIndexOf("/") + 1);
    }

    /**
     * getting the sessionId of the user login or registered
     * @param request
     */
    private void gettingSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        seesionID = session.getId();
    }

}
