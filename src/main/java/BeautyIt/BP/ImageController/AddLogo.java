package BeautyIt.BP.ImageController;

import BeautyIt.BP.Bean.Brands;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.BrandsDao;
import BeautyIt.BP.Dao.UsersDao;
import BeautyIt.BP.Localization.Controller.CheckLanguageAndCurrency;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Locale;


//value = "/var/www/upload/"
@WebServlet("/AddLogo")
public class AddLogo extends HttpServlet {

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
    private int SellerWebID = 0;
    private BrandsDao brandsDao = new BrandsDao();
    private int BrandId = 0;
    private String filePath = null;


    private static final String UPLOAD_DIRECTORY = "LogoImages";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            addLogo(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            addLogo(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void addLogo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        getSession(request);
        getParameters(request);
        checkWebPageLanguage(Pagelanguage, request);
        checkCurrency();
        getPageName(request);
        checkEmailCount();
        getUserId(userEmail);
        getSellerWebId(userWebId);
        getSellerBrandID(SellerWebID);
        uploadImage(request, response);
    }

    private int getSellerBrandID(int sellerNewID) {
        List<Brands> brandListForBrandId = brandsDao.LoadBrandsByOwnerId(sellerNewID);
        for (int i = 0; i < brandListForBrandId.size(); i++) {
            BrandId = brandListForBrandId.get(i).getBrandOwnerId();
        }
        return BrandId;
    }

    private void uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        //String uploadPath = getServletContext().getRealPath("")+ UPLOAD_DIRECTORY;
        String uploadPath = UPLOAD_DIRECTORY;
        //  System.out.println(uploadPath);

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        //filePath = uploadPath + File.separator + fileName;
                        //String path = request.getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;
                        filePath = UPLOAD_DIRECTORY + File.separator + fileName;
                        //       System.out.println(fileName);
                        //          System.out.println("filePath " + filePath);
                        File storeFile = new File(filePath);
                        System.out.println(filePath);

                        // saves the file on disk
                        item.write(storeFile);
                        request.setAttribute("message",
                                "Upload has been done successfully!");

                        AddLogoToData(BrandId, filePath);
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }

        gotoPage(request, response);
    }

    private void AddLogoToData(int brandId, String filePath) {

        int addLogo = brandsDao.AddLogo(BrandId, filePath);
        if (addLogo == 0) {
            System.out.println("Wrong " + filePath);
        } else {
            System.out.println("Done " + filePath);
        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        request.setAttribute("CountMessages", CountMessages);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("currencySymbol", currencySymbol);
        request.setAttribute("pageLanguageName", pageLanguageName);
        request.setAttribute("PageCurrency", PageCurrency);
        request.setAttribute("flag", flag);
        request.setAttribute("Pagelanguage", Pagelanguage);
        request.setAttribute("PageName", pageName);
        // Request Dispatcher to UserInbox.Jsp
        request.getRequestDispatcher("WEB-INF/SellerLogoBrand.jsp").forward(request, response);
    }

    private int getSellerWebId(int userWebId) {
        List<Users> usersList = usersDao.LoadUsersByID(userWebId);
        for (int i = 0; i < usersList.size(); i++) {
            SellerWebID = usersList.get(i).getSellerID();
        }
        return SellerWebID;
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

    private int getUserId(String userEmail) {
        UsersDao usersDao = new UsersDao();
        List<Users> usersList = usersDao.LoadUsersInfo(userEmail);
        for (int i = 0; i < usersList.size(); i++) {
            userWebId = usersList.get(i).getUserWebId();
        }
        return userWebId;
    }

    private void checkCurrency() {
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
