package BeautyIt.BP.EmailController;

import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.UsersDao;
import BeautyIt.BP.Localization.Controller.CheckLanguageAndCurrency;
import BeautyIt.BP.Messaging.Messaging;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@WebServlet("/ConfirmEmailId")
public class ConfirmEmailId extends HttpServlet {
    // Declaring Variables
    private String pageLanguageName = null;
    private String flag = null;
    private String currency = null;
    private String currencySymbol = null;
    private String language = null;
    private String country = null;
    private String VerificationEmailCodeinDatabase = null;
    private String PageCurrency =null;
    private String Pagelanguage = null;
    private String VerificationEmailCode = null;
    private int userWebID =0;
    private UsersDao userDao = new UsersDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Getting parameters
        PageCurrency = request.getParameter("PageCurrency");
        Pagelanguage= request.getParameter("PageLanguage");
        VerificationEmailCode = request.getParameter("EmailVerificationCode");
        userWebID = Integer.parseInt(request.getParameter("userWebID"));
        // Getting Web Site Language
        if (Pagelanguage != null) {
            String[] pLangauge = Pagelanguage.split("_");
            language = pLangauge[0];
            country = pLangauge[1];
            Locale locale = new Locale(language, country);
        }
        // Calling currencyChecker
        CheckLanguageAndCurrency checkLanguageAndCurrency = new CheckLanguageAndCurrency();
        // Sending currency value for further check
        PageCurrency = checkLanguageAndCurrency.checkCurrency(currency);
        currencySymbol = checkLanguageAndCurrency.ShowCurrencySimbole(currency);
        // Sending language value for further check
        Pagelanguage = checkLanguageAndCurrency.checkLanguage(language);
        flag = checkLanguageAndCurrency.flagValue(country);
        pageLanguageName = checkLanguageAndCurrency.checkLanguageName(language);
        List<Users> usersEmailVerification = userDao.LoadUserEmailVerificationCode(userWebID);
        for (int i = 0; i < usersEmailVerification.size(); i++) {
            VerificationEmailCodeinDatabase = usersEmailVerification.get(i).getUserEmailVerificationCode();
        }
        // Checking if the email code in database with user id is the equals to the
        // verification email code from the email
        if (VerificationEmailCodeinDatabase.equals(VerificationEmailCode)) {
            // Changing isEmailVerified in Database to true.
            int EmailVerified = userDao.UpdateUserEmailVerification(userWebID);
            if (EmailVerified == 0) {
                //Calling error Method with language and currency
                Messaging.emailVerificationCodeErrorMessages(language, Pagelanguage, PageCurrency, request);
            } else {
                //Calling OK Method with language and currency
                Messaging.emailVerificationCodeOKMessages(language, Pagelanguage, PageCurrency, request);
            }
            request.getRequestDispatcher(
                    "/RegistrationComplite.jsp?language=" + Pagelanguage + "&PageCurrency=" + PageCurrency)
                    .forward(request, response);
        } else {
            //Calling error Method with language and currency
            Messaging.emailVerificationCodeErrorMessages(language, Pagelanguage, PageCurrency, request);
            request.setAttribute("currencySymbol", currencySymbol);
            request.setAttribute("pageLanguageName", pageLanguageName);
            request.setAttribute("flag", flag);
            request.setAttribute("Pagelanguage", Pagelanguage);
            request.getRequestDispatcher(
                    "/RegistrationComplite.jsp?language=" + Pagelanguage + "&PageCurrency=" + PageCurrency)
                    .forward(request, response);
        }
    }
}
