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

@WebServlet("/UpdateSubMenuById")
public class UpdateSubMenuById extends HttpServlet {
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
    private String EnglishSubMenu = null;
    private String ArmenianSubMenu = null;
    private String ArabicSubMenu = null;
    private String RussianSubMenu = null;
    private String FrenchSubMenu = null;
    private Menu menu = new Menu();
    private List<Menu> menuListById = new ArrayList<>();
    private String MenuId = null;
    private int menuIdConverted =0;
    private String MenuName =null;
    private List<SubMenu> SubMenuListById = new ArrayList<>();
    private int subMenuWebIdConerted = 0;
    private SubMenuDao subMenuDao = new SubMenuDao();
    private String subMenuWebId =null;
    private String subMenuId =null;
    private int subMenuIdConverted =0;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateSubMenuById(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateSubMenuById(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateSubMenuById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        getAdminSession(request);
        getParameters(request);
        getAdminFullInfo(AdminEmailFromSession);
        getAdminId(AdminEmailFromSession);
        checkEmailCount();
        ConvertsubMenuId(subMenuId);
        ConvertSubMenuWebId(subMenuWebId);
        ConvertMenuId(MenuId);
        updateMenu(subMenuWebIdConerted,request,response);
    }

    private int ConvertsubMenuId(String subMenuId) {
        subMenuIdConverted = Integer.parseInt(subMenuId);
        return subMenuIdConverted;
    }

    private void updateMenu(int subMenuWebIdConerted, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubMenu subMenu = new SubMenu(menuIdConverted,MenuName,subMenuWebIdConerted,EnglishSubMenu,ArmenianSubMenu,ArabicSubMenu,RussianSubMenu,FrenchSubMenu);
        int updatedSubMenu = subMenuDao.updateSubMenu(subMenu,subMenuIdConverted);
        if(updatedSubMenu ==0){
            String message = "Something wrong";
            getSubMenuListById(subMenuIdConverted);
            gotoPage(request,response,message);
        }else{
            String message = "Sub Menu updated";
            getSubMenuListById(subMenuIdConverted);
            gotoPage(request,response,message);
        }

    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("subMenuListById", SubMenuListById);
        request.setAttribute("message", message);
        request.setAttribute("CountAdminMessages", CountAdminMessages);
        request.setAttribute("AdminEmail", adminId);
        request.getRequestDispatcher("/WEB-INF/Admin/UpdateSubMenuPage.jsp").forward(request, response);
    }

    private List<SubMenu> getSubMenuListById(int subMenuWebIdConerted) {
        SubMenuListById = subMenuDao.loadSubMenuById(subMenuWebIdConerted);
        return SubMenuListById;
    }


    private int ConvertMenuId(String MenuId) {
        menuIdConverted = Integer.parseInt(MenuId);
        return menuIdConverted;
    }

    private int ConvertSubMenuWebId(String subMenuWebId) {
        subMenuWebIdConerted = Integer.parseInt(subMenuWebId);
        return subMenuWebIdConerted;
    }

    private void getParameters(HttpServletRequest request) {
        EnglishSubMenu = request.getParameter("EnglishSubMenu");
        ArmenianSubMenu = request.getParameter("ArmenianSubMenu");
        ArabicSubMenu = request.getParameter("ArabicSubMenu");
        RussianSubMenu = request.getParameter("RussianSubMenu");
        FrenchSubMenu = request.getParameter("FrenchSubMenu");
        MenuId = request.getParameter("MenuId");
        MenuName = request.getParameter("MenuName");
        subMenuWebId= request.getParameter("subMenuWebId");
        subMenuId= request.getParameter("subMenuId");
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
