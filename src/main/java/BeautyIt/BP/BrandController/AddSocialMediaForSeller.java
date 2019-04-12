package BeautyIt.BP.BrandController;

import BeautyIt.BP.Bean.Brands;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.SocialMedia;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.BrandsDao;
import BeautyIt.BP.Dao.SocialMediaDao;
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

@WebServlet("/AddSocialMediaForSeller")
public class AddSocialMediaForSeller extends HttpServlet {
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
    private String facebook;
    private String twitter;
    private String Googleplus;
    private String linkedin;
    private String youtube;
    private String pinterest;
    private String instagram;
    private int SocialId = 0;
    private int branWebdId = 0;
    private SocialMedia socialMedia = new SocialMedia();
    private  SocialMediaDao socialMediaDao = new SocialMediaDao();
    private int checkIfAddedToSocial=0;
    private  List<SocialMedia> socialMediaList =new ArrayList<>();
    private int SocialListSizeCount =0;
    private int socialId =0;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            addSocialMediaForSeller(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            addSocialMediaForSeller(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addSocialMediaForSeller(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        getSession(request);
        getParameters(request);
        getUserId(userEmail);
        getSellerId(userWebId);
        getBrandId(SellerId);
        checkIfBrandInfoExciste(SellerId);
        checkIfBrandSocialExciste(SellerId);
        getSocialId(SellerId);
        checkCurrency(request);
        checkWebPageLanguage(Pagelanguage, request);
        getPageName(request);
        checkEmailCount();
        AddToSocialDatabase(request,response);

    }

    private int getBrandId(int sellerId) {
        brandsList = brandsDao.LoadBrandsByOwnerId(sellerId);
        for (int i = 0; i <brandsList.size() ; i++) {
            branWebdId = brandsList.get(i).getBrandWebId();
        }

        return branWebdId;
    }



    private void AddToSocialDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(SocialListSizeCount ==0) {
            socialMedia = new SocialMedia(SellerId, branWebdId, facebook, Googleplus, instagram, twitter, pinterest, linkedin, youtube);
            checkIfAddedToSocial = socialMediaDao.AddSocials(socialMedia);

        }else{

            socialMedia = new SocialMedia(socialId, facebook, Googleplus, instagram, twitter, pinterest, linkedin, youtube);
            checkIfAddedToSocial = socialMediaDao.UpdateSocials(socialMedia,socialId);

        }
        if(checkIfAddedToSocial == 0){
            String message = "something went wrong";
            gotoPage(request,response,message);

        }else{
            String message = "All Done";
            gotoPage(request,response,message);

        }

    }

    private int getSocialId(int SellerId) {
        socialMediaList = socialMediaDao.loadSocialsBySellerId(SellerId);
        for (int i = 0; i <socialMediaList.size() ; i++) {
            socialId = socialMediaList.get(i).getSocialId();
        }
        return socialId;
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
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
        // Request Dispatcher to UserInbox.Jsp
        request.getRequestDispatcher("WEB-INF/AddSellerSocialMedia.jsp").forward(request, response);
    }

    private int getSellerId(int userWebId) {
        usersListSellerId = usersDao.LoadUsersByID(userWebId);
        for (int i = 0; i < usersListSellerId.size(); i++) {
            SellerId = usersListSellerId.get(i).getSellerID();
        }
        return SellerId;
    }

    private int checkIfBrandInfoExciste(int userWebId) {
        brandsList = brandsDao.LoadBrandsByOwnerId(userWebId);
        for (int i = 0; i < brandsList.size(); i++) {
            listSizeCount++;
        }
        return listSizeCount;
    }

    private int checkIfBrandSocialExciste(int SellerId) {
        socialMediaList = socialMediaDao.loadSocialsBySellerId(SellerId);
        for (int i = 0; i <socialMediaList.size() ; i++) {
            SocialListSizeCount++;
        }
        return SocialListSizeCount;
    }

    private int checkEmailCount() throws SQLException {
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
        return CountMessages;
    }

    private int getUserId(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
        }
        return userWebId;
    }

    private void checkCurrency(HttpServletRequest request) {
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
        if(request.getParameter("facebook") !=null) {
            facebook = request.getParameter("facebook");
        }else{
            facebook ="No";
        }

        if(request.getParameter("twitter") !=null) {
            twitter = request.getParameter("twitter");
        }else{
            twitter = "No";
        }

        if(request.getParameter("Googleplus") !=null) {
            Googleplus = request.getParameter("Googleplus");
        }else{
            Googleplus ="No";
        }

        if(request.getParameter("linkedin") !=null) {
            linkedin = request.getParameter("linkedin");
        }else{
            linkedin ="No";
        }

        if(request.getParameter("youtube") !=null) {
            youtube = request.getParameter("youtube");
        }else{
            youtube ="No";
        }

        if(request.getParameter("instagram") !=null) {
            instagram = request.getParameter("instagram");
        }else{
            instagram ="No";
        }


        if(request.getParameter("pinterest") !=null) {
            pinterest = request.getParameter("pinterest");
        }else{
            pinterest ="No";
        }
    }

    private void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));

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
