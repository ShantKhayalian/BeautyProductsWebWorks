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

@WebServlet("/UpdateMenuById")
public class UpdateMenuById extends HttpServlet {
    private String AdminEmailFromSession = null;
    private AdminDao adminDao = new AdminDao();
    private String adminUserName = null;
    private int adminId = 0;
    private List<Admin> adminInfoList = new ArrayList<>();
    private List<Messaging> messagingList = new ArrayList<>();
    private UsersDao usersDao = new UsersDao();
    private int CountAdminMessages = 0;
    private MenuDao menuDao = new MenuDao();
    private String MenuIdString = null;
    private int menuId = 0;
    private String EnglishMenu = null;
    private String ArmenianMenu = null;
    private String ArabicMenu = null;
    private String RussianMenu = null;
    private String FrenchMenu = null;
    private Menu menu = new Menu();
    private List<Menu> menuListById = new ArrayList<>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateMenuById(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateMenuById(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateMenuById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        getAdminSession(request);
        getParameters(request);
        getAdminFullInfo(AdminEmailFromSession);
        getAdminId(AdminEmailFromSession);
        checkEmailCount();
        convertToInt(MenuIdString);
        getParameters(request);
        updateMenu(menuId,request,response);

    }

    private void updateMenu(int menuId,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        menu = new Menu(EnglishMenu,ArmenianMenu,ArabicMenu,RussianMenu,FrenchMenu);
        int updatedMenu = menuDao.updateMenu(menu,menuId);
        if(updatedMenu ==0){
            String message = "Something wrong";
            gotoPage(request,response,message);
            getMenuListById(menuId);
        }else{
            String message = "Menu updated";
            getMenuListById(menuId);
            gotoPage(request,response,message);
        }

    }

    private List<Menu> getMenuListById(int menuId) {
        menuListById = menuDao.loadMenuById(menuId);
        return menuListById;
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("menuListById", menuListById);
        request.setAttribute("message", message);
        request.setAttribute("CountAdminMessages", CountAdminMessages);
        request.setAttribute("AdminEmail", adminId);
        request.getRequestDispatcher("/WEB-INF/Admin/UpdateMenuPage.jsp").forward(request, response);
    }

    private int convertToInt(String MenuIdString) {
        menuId = Integer.parseInt(MenuIdString);
        return menuId;
    }


    private void getParameters(HttpServletRequest request) {
        MenuIdString = request.getParameter("MenuID");
        EnglishMenu = request.getParameter("EnglishMenu");
        ArmenianMenu = request.getParameter("ArmenianMenu");
        ArabicMenu = request.getParameter("ArabicMenu");
        RussianMenu = request.getParameter("RussianMenu");
        FrenchMenu = request.getParameter("FrenchMenu");
    }


    private int checkEmailCount() throws SQLException {
        CountAdminMessages=0;
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
        for (int i = 0; i <adminInfoList.size() ; i++) {
            adminId = adminInfoList.get(i).getAdminId();
        }
        return adminId;
    }

    private String getAdminFullInfo(String adminEmailFromSession) {
        adminInfoList = adminDao.LoadAdminByEmail(adminEmailFromSession);
        for (int i = 0; i <adminInfoList.size() ; i++) {
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
