package BeautyIt.BP.AddressBoxController;

import BeautyIt.BP.Bean.AddressBox;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.AddressBoxDao;
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

@WebServlet("/AddressBook")
public class AddressBook extends HttpServlet {
    private String userEmail = null;
    private String PageCurrency = null;
    private String language = null;
    private String country = null;
    private String Pagelanguage = null;
    private String pageLanguageName = null;
    private String flag = null;
    private String currency = null;
    private String currencySymbol = null;
    private String pageName = null;
    private String uri = null;
    private int userWebId = 0;
    private UsersDao usersDao = new UsersDao();
    private String pagelanguage = null;
    private int CountMessages = 0;
    private AddressBoxDao addressBoxDao = new AddressBoxDao();
    private List<AddressBox> addressBoxList;
    private String isEmailRead = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            OperationAddressBook(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            OperationAddressBook(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void OperationAddressBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));
        pagelanguage = request.getParameter("Pagelanguage");
        checkWebPageLanguage(Pagelanguage, request);
        getUserId(userEmail);
        checkEmailCount();
        addressInbox(userWebId);
        connectToPage(request, response);
    }

    private int getUserId(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
        }
        return userWebId;
    }

    private void connectToPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("addressBoxList", addressBoxList);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        request.getRequestDispatcher("/WEB-INF/UserAddressBook.jsp").forward(request, response);
    }

    private void addressInbox(int userWebId) {

        addressBoxList = addressBoxDao.LoadAllAddress(userWebId);
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
}
