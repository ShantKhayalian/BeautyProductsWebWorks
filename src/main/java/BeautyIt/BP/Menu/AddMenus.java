package BeautyIt.BP.Menu;

import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.Menu;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Dao.AdminDao;
import BeautyIt.BP.Dao.MenuDao;
import BeautyIt.BP.Dao.UsersDao;

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
import java.util.Random;

@WebServlet("/AddMenus")
public class AddMenus extends HttpServlet {

    private String AdminEmailFromSession = null;
    private AdminDao adminDao = new AdminDao();
    private String adminUserName = null;
    private int adminId = 0;
    private List<Admin> adminInfoList = new ArrayList<>();
    private List<Messaging> messagingList = new ArrayList<>();
    private UsersDao usersDao = new UsersDao();
    private int CountAdminMessages = 0;
    private String EnglishMenu = null;
    private String ArmenianMenu = null;
    private String ArabicMenu = null;
    private String RussianMenu = null;
    private String FrenchMenu = null;
    private Random random = new Random();
    private int menuNewID = 0;
    private MenuDao menuDao = new MenuDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            addMenus(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            addMenus(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addMenus(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        getAdminSession(request);
        getParameters(request);
        getAdminFullInfo(AdminEmailFromSession);
        getAdminId(AdminEmailFromSession);
        checkEmailCount();
        createMenuId();
        AddMenuToData(request, response);
    }

    private int createMenuId() {
        menuNewID = random.nextInt(10) + 9999;
        return menuNewID;
    }

    private void AddMenuToData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Menu menu = new Menu(menuNewID, EnglishMenu, ArmenianMenu, ArabicMenu, RussianMenu, FrenchMenu);
        int checkAdded = menuDao.AddMenu(menu);
        if (checkAdded == 0) {
            String message = "something went wrong";
            gotoPage(request, response, message);
        } else {
            String message = "menu added to data";
            gotoPage(request, response, message);
        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.setAttribute("CountAdminMessages", CountAdminMessages);
        request.setAttribute("AdminEmail", adminId);
        request.getRequestDispatcher("/WEB-INF/Admin/AddMenu.jsp").forward(request, response);
    }

    private void getParameters(HttpServletRequest request) {
        EnglishMenu = request.getParameter("EnglishMenu");
        ArmenianMenu = request.getParameter("ArmenianMenu");
        ArabicMenu = request.getParameter("ArabicMenu");
        RussianMenu = request.getParameter("RussianMenu");
        FrenchMenu = request.getParameter("FrenchMenu");
    }


    private int checkEmailCount() throws SQLException {
        CountAdminMessages = 0;
        messagingList = usersDao.getAdminMessages(adminId);
        for (Messaging messaging : messagingList) {
            if (messaging.getMessageRead().toLowerCase().trim().equals("false")) {
                CountAdminMessages++;
            }
        }
        return CountAdminMessages;
    }

    private int getAdminId(String adminEmailFromSession) {
        adminInfoList = adminDao.LoadAdminByEmail(adminEmailFromSession);
        for (int i = 0; i < adminInfoList.size(); i++) {
            adminId = adminInfoList.get(i).getAdminId();
        }
        return adminId;
    }

    private String getAdminFullInfo(String adminEmailFromSession) {
        adminInfoList = adminDao.LoadAdminByEmail(adminEmailFromSession);
        for (int i = 0; i < adminInfoList.size(); i++) {
            adminUserName = adminInfoList.get(i).getAdmin_Username();
        }
        return adminUserName;
    }

    private void getAdminSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        AdminEmailFromSession = String.valueOf(session.getAttribute("adminuser"));
        System.out.println("adminuser : " + AdminEmailFromSession);
    }
}
