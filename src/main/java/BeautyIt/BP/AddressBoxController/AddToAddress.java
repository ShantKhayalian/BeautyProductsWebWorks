package BeautyIt.BP.AddressBoxController;

import BeautyIt.BP.Bean.AddressBox;
import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.AddressBoxDao;
import BeautyIt.BP.Dao.AdminDao;
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

@WebServlet("/AddToAddress")
public class AddToAddress extends HttpServlet {
    private UsersDao usersDao = new UsersDao();
    private AdminDao adminDao = new AdminDao();
    private AddressBoxDao addressBoxDao = new AddressBoxDao();
    private int userWebId = 0;
    private String userFirstName = null;
    private String userLastName = null;

    private String userToAddFirstName = null;
    private String userToAddFirstEmail = null;
    private String Add = null;
    private String to = null;
    private String addedName = null;
    private int addedId = 0;
    private String emailId = null;
    private int emailIdFromString = 0;
    private String PageCurrency = null;
    private String language = null;
    private String country = null;
    private String Pagelanguage = null;
    private String currency = null;
    private String uri = null;
    private String pageLanguageName = null;
    private String flag = null;
    private String currencySymbol = null;
    private String pageName = null;
    private int userToAddWebId = 0;
    private String userAddFirstName = null;
    private String userAddLastName = null;
    private String userEmail =null;
    private int CountMessages = 0;
    private String isEmailRead =null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AddAddress(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AddAddress(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void AddAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        getSession(request);
        getParameters(request);
        getUserId(userEmail);
        Checkpage(request);
        checkEmailCount(userWebId);
        getUserInfo(to);
        getUserToAddInfo(Add);

        if (!checkifUserExcistInAddressBook(userWebId,Add, to)) {
            AddToAddressBook(request,response);
        } else {
            String message ="The Address already in your address book";
            goToPage(request, response,message);
        }
    }
    /**
     * @param add
     * @param to
     * @return
     */
    private boolean checkifUserExcistInAddressBook(int userWebId,String add, String to) {
        String owner = to;
        String adding = add;
        int userToAddId = 0;
        List<AddressBox> addressBooksList = addressBoxDao.LoadAllAddress(userWebId);
        for (int i = 0; i <addressBooksList.size() ; i++) {
            userToAddId = addressBooksList.get(i).getAddedId();
        }
        if (userToAddId == addedId) {
            return false;
        } else {
            return true;
        }
    }


    private void getParameters(HttpServletRequest request) {
        Pagelanguage = request.getParameter("Pagelanguage");
        currency = request.getParameter("PageCurrency");
        Add = request.getParameter("Add");
        to = request.getParameter("of");

    }


    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));
    }

    private int getUserId(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
        }
        return userWebId;
    }

    private void goToPage(HttpServletRequest request, HttpServletResponse response,String message) throws ServletException, IOException {
        System.out.println("Found");
        request.setAttribute("message", message);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        request.getRequestDispatcher("/WEB-INF/UserChangingResults.jsp").forward(request, response);
    }

    private void checkEmailCount(int userWebId) throws SQLException {
        List<Messaging> messagingAdminsList = usersDao.getMessagesByUserWebId(userWebId);
        CountMessages =0;
        for (int i = 0; i < messagingAdminsList.size(); i++) {
            isEmailRead = messagingAdminsList.get(i).getMessageRead();
            if (isEmailRead.toLowerCase().trim().equals("false")) {
                CountMessages++;
            } else {
                CountMessages = 0;
            }
        }
    }

    private void Checkpage(HttpServletRequest request) {
        // Getting page name
        uri = request.getRequestURI();
        pageName = uri.substring(uri.lastIndexOf("/") + 1);
        // Calling currencyChecker
        CheckLanguageAndCurrency checkLanguageAndCurrency = new CheckLanguageAndCurrency();
        // responding currency value from String query
        currency = request.getParameter("PageCurrency");
        checkWebPageLanguage(Pagelanguage, request);
        // Sending currency value for further check
        PageCurrency = checkLanguageAndCurrency.checkCurrency(currency);
        currencySymbol = checkLanguageAndCurrency.ShowCurrencySimbole(currency);
        // Sending language value for further check
        Pagelanguage = checkLanguageAndCurrency.checkLanguage(language);
        flag = checkLanguageAndCurrency.flagValue(country);
        pageLanguageName = checkLanguageAndCurrency.checkLanguageName(language);

    }

    private void checkWebPageLanguage(String pagelanguage, HttpServletRequest request) {
        if (request.getParameter("Pagelanguage") != null) {
            String[] pLangauge = request.getParameter("Pagelanguage").split("_");
            language = pLangauge[0];
            country = pLangauge[1];
            Locale locale = new Locale(language, country);
        }
    }

    private void AddToAddressBook(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        AddressBox addressBox = new AddressBox(userWebId, userFirstName, userLastName, userToAddWebId, userAddFirstName, userAddLastName);
        int addToAddress = addressBoxDao.AddToAddressBox(addressBox);

        if(addToAddress == 0){
            String message = "something wrong";
            goToPage(request,response,message);
        }else{
            String message = "Added successfully";
            goToPage(request,response,message);
        }


    }



    private void getUserToAddInfo(String add) {
        List<Users> usersList = usersDao.LoadUserbyName(add);
        if(usersList.size()==0){
            userToAddWebId =1;
            userAddFirstName = "Admin";
            userAddLastName = "info@beautyproducts.am";
        }else {
            for (int j = 0; j < usersList.size(); j++) {
                userToAddWebId = usersList.get(j).getUserWebId();
                userAddFirstName = usersList.get(j).getUserFirstName();
                userAddLastName = usersList.get(j).getUserLastName();
            }
        }
    }

    private void getUserInfo(String to) {
        List<Users> usersList = usersDao.LoadUsersInfo(to);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
            userFirstName = usersList.get(i).getUserFirstName();
            userLastName = usersList.get(i).getUserEmail();
        }

    }

}
