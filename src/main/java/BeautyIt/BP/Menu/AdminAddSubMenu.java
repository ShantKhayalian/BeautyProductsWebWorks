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

@WebServlet("/AdminAddSubMenu")
public class AdminAddSubMenu extends HttpServlet {


    private String AdminEmailFromSession =null;
    private AdminDao adminDao = new AdminDao();
    private String adminUserName=null;
    private int adminId =0;
    private List<Admin> adminInfoList = new ArrayList<>();
    private List<Messaging> messagingList = new ArrayList<>();
    private UsersDao usersDao = new UsersDao();
    private int CountAdminMessages = 0;
    private MenuDao menuDao = new MenuDao();
    private List<Menu> menuList =new ArrayList<>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            adminAddSubMenu(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            adminAddSubMenu(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void adminAddSubMenu(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        getAdminSession(request);
        getAdminFullInfo(AdminEmailFromSession);
        getAdminId(AdminEmailFromSession);
        checkEmailCount();
        loadAllMenu();
        setParameters(request,response);

    }

    private List<Menu> loadAllMenu() {
        menuList = menuDao.LoadAllMenu();
        return menuList;
    }

    private void setParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("menuList", menuList);
        request.setAttribute("CountAdminMessages", CountAdminMessages);
        request.setAttribute("AdminEmail", adminId);
        request.getRequestDispatcher("/WEB-INF/Admin/AddSubMenu.jsp").forward(request, response);
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
