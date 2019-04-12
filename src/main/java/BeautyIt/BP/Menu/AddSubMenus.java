package BeautyIt.BP.Menu;

import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.Menu;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.SubMenu;
import BeautyIt.BP.Dao.AdminDao;
import BeautyIt.BP.Dao.MenuDao;
import BeautyIt.BP.Dao.SubMenuDao;
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

@WebServlet("/AddSubMenus")
public class AddSubMenus extends HttpServlet {
    private String AdminEmailFromSession = null;
    private AdminDao adminDao = new AdminDao();
    private String adminUserName = null;
    private int adminId = 0;
    private List<Admin> adminInfoList = new ArrayList<>();
    private List<Messaging> messagingList = new ArrayList<>();
    private UsersDao usersDao = new UsersDao();
    private int CountAdminMessages = 0;
    private String EnglishSubMenu = null;
    private String ArmenianSubMenu = null;
    private String ArabicSubMenu = null;
    private String RussianSubMenu = null;
    private String FrenchSubMenu = null;
    private Random random = new Random();
    private int subMenuNewID = 0;
    private MenuDao menuDao = new MenuDao();
    private SubMenuDao subMenuDao = new SubMenuDao();
    private String MenuId =null;
    private int ConvertedMenuId = 0;
    private String ForMenu =null;
    private List<Menu> menuList =new ArrayList<>();
    private String menuName =null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            addSubMenus(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            addSubMenus(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addSubMenus(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        getAdminSession(request);
        getParameters(request);
        getAdminFullInfo(AdminEmailFromSession);
        getAdminId(AdminEmailFromSession);
        checkEmailCount();
        createSubMenuId();
        convertMenuId(MenuId);
        getMenuName(ConvertedMenuId);
        loadAllMenu();
        AddSubMenuToData(request, response);
    }

    private String getMenuName(int ConvertedMenuId) {
        menuList = menuDao.loadMenuByWebId(ConvertedMenuId);
        for (int i = 0; i <menuList.size() ; i++) {
            menuName = menuList.get(i).getMenuDefualtName();
        }
        return menuName;
    }


    private int convertMenuId(String menuId) {
        ConvertedMenuId = Integer.parseInt(menuId);
        return ConvertedMenuId;
    }

    private List<Menu> loadAllMenu() {
        menuList = menuDao.LoadAllMenu();
        return menuList;
    }

    private void AddSubMenuToData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubMenu subMenu = new SubMenu(ConvertedMenuId,menuName,subMenuNewID,EnglishSubMenu,ArmenianSubMenu,ArabicSubMenu,RussianSubMenu,FrenchSubMenu);
        int checkAdded = subMenuDao.AddSubMenu(subMenu);
        if (checkAdded == 0) {
            String message = "something went wrong";
            gotoPage(request, response, message);
        } else {
            String message = "SUB menu added to data";
            gotoPage(request, response, message);
        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.setAttribute("menuList", menuList);
        request.setAttribute("CountAdminMessages", CountAdminMessages);
        request.setAttribute("AdminEmail", adminId);
        request.getRequestDispatcher("/WEB-INF/Admin/AddSubMenu.jsp").forward(request, response);
    }



    private void getParameters(HttpServletRequest request) {
        EnglishSubMenu = request.getParameter("EnglishSubMenu");
        ArmenianSubMenu = request.getParameter("ArmenianSubMenu");
        ArabicSubMenu = request.getParameter("ArabicSubMenu");
        RussianSubMenu = request.getParameter("RussianSubMenu");
        FrenchSubMenu = request.getParameter("FrenchSubMenu");
        ForMenu =  request.getParameter("ForMenu");
        MenuId = request.getParameter("MenuId");

    }


    private int createSubMenuId() {
        subMenuNewID = random.nextInt(10) + 9999;
        return subMenuNewID;
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
