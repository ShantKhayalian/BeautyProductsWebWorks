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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet("/ReadMail")
public class ReadMail extends HttpServlet {
    private String userEmail = null;
    private String emailId = null;
    private int emailIdFromString =0;
    private String PageCurrency = null;
    private String language = null;
    private String country = null;
    private String Pagelanguage = null;
    private String pageLanguageName = null;
    private String flag = null;
    private String currency = null;
    private String currencySymbol = null;
    private int userWebId = 0;
    private String pageName = null;
    private String uri = null;
    private UsersDao usersDao = new UsersDao();
    private String pagelanguage = null;
    private String isEmailRead =null;
    private int CountMessages = 0;
    private  List<Messaging> mesageById =new ArrayList<>();
    private List<Messaging> messagingAdminsList = new ArrayList<>();
    private int SerllerID =0;
    private List<AddressBox> addressBoxList;
    private AddressBoxDao addressBoxDao = new AddressBoxDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            readAdminEmail(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            readAdminEmail(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void readAdminEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        getSession(request);
        getParameters(request);
        checkWebPageLanguage(Pagelanguage, request);
        checkAddressBook(userWebId);
        userWebId = getUserId(userEmail);

        emailIdFromString = Integer.parseInt(emailId);
        isEmailRead = null;

        messagingAdminsList = usersDao.getMessagesByUserWebId(userWebId);
        CountMessages=0;
        for (int i = 0; i < messagingAdminsList.size(); i++) {
            isEmailRead = messagingAdminsList.get(i).getMessageRead();
            if(isEmailRead.toLowerCase().trim().equals("false")) {
                CountMessages++;
            }else{
                CountMessages =0;
            }
        }
        mesageById = usersDao.readAdminMessages(emailIdFromString);

        int changeToRead = usersDao.UpdateEmailRead(emailIdFromString,"true");
        if (changeToRead == 0) {
            String message = "Something went wrong Please try again";
            PrePariringReqAndRes(request,response,message);
        }else{
            // Request Dispatcher to Index.Jsp
            String message = "Updated successfully.";
            PrePariringReqAndRes(request,response,message);
        }
    }
    private void getParameters(HttpServletRequest request) {
        Pagelanguage = request.getParameter("Pagelanguage");
        currency = request.getParameter("PageCurrency");
        emailId = request.getParameter("EmailId");
    }

    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));
    }

    private void PrePariringReqAndRes(HttpServletRequest request, HttpServletResponse response,String Message) throws ServletException, IOException {
        // Request Dispatcher to Index.Jsp
        request.setAttribute("rigth", Message);
        request.setAttribute("error", Message);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("mesageById",mesageById);
        request.setAttribute("emailMessages", messagingAdminsList);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("addressBoxList", addressBoxList);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        if(checkIsSeller(userEmail)) {
            sendToSellerPage(request, response);
        }else {
            sendToUserPage(request, response);
        }

    }

    private List<AddressBox> checkAddressBook(int userWebId) {
        addressBoxList = addressBoxDao.LoadAllAddress(userWebId);
        return addressBoxList;
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
    private int getUserId(String userEmail) throws SQLException {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
        }
        return userWebId;
    }
    private void sendToUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/UserReadUserInbox.jsp").forward(request, response);
    }

    private void sendToSellerPage(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/SellerReadUserInbox.jsp").forward(request, response);
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
