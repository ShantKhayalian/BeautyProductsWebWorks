package BeautyIt.BP.Localization.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/Localization")
public class Localization extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newCurrency="";
        String printCurrency="";
        String currency = request.getParameter("value");
        String[] pLangauge = request.getParameter("lang").split("_");
        String language = pLangauge[0];
        String country = pLangauge[1];
        Locale locale = new Locale(language, country);
        request.setAttribute("country", locale.getDisplayCountry());
        request.setAttribute("language", request.getParameter("lang"));

        if (currency != null) {
            System.out.println(currency);
            switch(currency) {
                case "rouble":
                    printCurrency = "RUB";
                    break;
                case "money":
                    printCurrency = "Դրամ";
                    break;
                case "euro":
                    printCurrency="EURO";
                    break;
                case "dollar":
                    printCurrency="USD";
                    break;
                default :
                    newCurrency="USD";
            }
            request.setAttribute("value", printCurrency);
        } else {
            newCurrency = "USD";
            request.setAttribute("value", newCurrency);
        }
        request.getRequestDispatcher("/Inc/EngLang.jsp").forward(request, response);
    }

}
