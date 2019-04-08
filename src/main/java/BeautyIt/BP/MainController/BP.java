package BeautyIt.BP.MainController;

import BeautyIt.BP.Localization.Controller.CheckLanguageAndCurrency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/BP")
public class BP extends HttpServlet {
    // Declaring variables for Currency And Language
    private String PageCurrency = "";
    private String language = "";
    private String country = "";
    private String Pagelanguage = "";
    private String pageLanguageName = "";
    private  String flag = "";
    private String currency = "";
    private String currencySymbol = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);

        // Request Dispatcher to Index.Jsp
        request.getRequestDispatcher("/Index.jsp").forward(request, response);
    }
}
