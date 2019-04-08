package BeautyIt.BP.EmailController;

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


@WebServlet("/ReadUserEmail")
public class ReadUserEmail extends HttpServlet {
    // Declaring variables for Currency And Language
    private String PageCurrency = null;
    private String language = null;
    private String country = null;
    private String Pagelanguage = null;
    private String pageLanguageName = null;
    private String flag = null;
    private String currency = null;
    private String currencySymbol = null;
    private String userEmail = null;
    private int userWebId = 0;
    private String pageName = null;
    private String uri = null;
    private int updateImportanceOfEmail = 0;
    private UsersDao usersDao = new UsersDao();
    private AddressBoxDao addressBoxDao = new AddressBoxDao();
    private int emailId = 0;
    private String value = null;
    private String emailID = null;
    private static String messageIdToDelete = null;
    private static int checkDeleteMessage = 0;
    private List<AddressBox> addressBoxList;
    private String pagelanguage = null;
    private int SerllerID =0;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Getting Session
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));
        // Section to Change the importance of the email in the email inbox
        value = request.getParameter("value");
        emailID = request.getParameter("EmailId");
        pagelanguage = request.getParameter("Pagelanguage");
        checkWebPageLanguage(Pagelanguage, request);

        String checkedboxes[] = request.getParameterValues("chkSingle");
        if (checkedboxes != null) {
            for (int i = 0; i < checkedboxes.length; i++) {
                messageIdToDelete = checkedboxes[i];
                checkDeleteMessage = usersDao.DeleteMessages(messageIdToDelete);
            }
            if (checkDeleteMessage > 0) {
                // Something went Wrong section
                String okMessage = "Your Category deleted successfully.";

            } else {
                // Everything is ok section
                String errorMessage = "Something went wrong Please try again";
            }
        }

        // System.out.println("" + value + " " + emailId);
        if (value == null && emailId == 0) {
            try {
                gotoPage(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (value != null && value.equals("notImportant")) {
            emailId = Integer.parseInt(emailID);
            try {
                changeImprtancyOfEmailtoTrue(emailId, response, request);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (value != null && value.equals("Important")) {
            emailId = Integer.parseInt(emailID);
            try {
                changeImprtancyOfEmailtoFalse(emailId, response, request);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        checkAddressBook();
        checkWebPageLanguage(pagelanguage, request);
        //Getting userID
        userWebId = getUserId(userEmail);
        readUserEmails(userWebId, request, response);

    }

    private void checkAddressBook() {
        addressBoxList = addressBoxDao.CheckIfAddressExsists(userEmail);

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

    private void changeImprtancyOfEmailtoTrue(int emailId, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException, SQLException {
        updateImportanceOfEmail = usersDao.UpdateEmailImportance(emailId, "false");
        if (updateImportanceOfEmail == 0) {
            // Something went Wrong section
            String errorMessage = "Something went wrong";
            request.setAttribute("error", errorMessage);
        } else {
            String okMessage = "Updated successfully.";
            request.setAttribute("rigth", okMessage);

        }
        gotoPage(request, response);
    }

    private void changeImprtancyOfEmailtoFalse(int emailId, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException, SQLException {
        updateImportanceOfEmail = usersDao.UpdateEmailImportance(emailId, "true");
        if (updateImportanceOfEmail == 0) {
            // Something went Wrong section
            String errorMessage = "Something went wrong";
            request.setAttribute("error", errorMessage);
        } else {
            String okMessage = "Updated successfully.";
            request.setAttribute("rigth", okMessage);

        }
        gotoPage(request, response);
    }

    private int getUserId(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
        }
        return userWebId;
    }

    private void readUserEmails(int userWebId, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        UsersDao usersDao = new UsersDao();
        List<Messaging> messagingAdminsList = usersDao.getMessagesByUserWebId(userWebId);
        String isEmailRead = null;
        int CountMessages = 0;

        for (int i = 0; i < messagingAdminsList.size(); i++) {

            isEmailRead = messagingAdminsList.get(i).getMessageRead();
            if (isEmailRead.toLowerCase().trim().equals("false")) {
                CountMessages++;
            } else {
                CountMessages = 0;
            }
        }

        request.setAttribute("addressBoxList", addressBoxList);
        request.setAttribute("emailMessages", messagingAdminsList);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        // Request Dispatcher to UserInbox.Jsp
        if(checkIsSeller(userEmail)) {
            sendToSellerPage(request, response);
        }else {
            sendToUserPage(request, response);
        }


    }
    private void sendToUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/UserInbox.jsp").forward(request, response);
    }

    private void sendToSellerPage(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/SellerInbox.jsp").forward(request, response);
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
}
