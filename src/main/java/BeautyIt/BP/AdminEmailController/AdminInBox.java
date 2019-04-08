package BeautyIt.BP.AdminEmailController;

import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.AddressBoxDao;
import BeautyIt.BP.Dao.AdminDao;
import BeautyIt.BP.Dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AdminInBox")
public class AdminInBox extends HttpServlet {
    private String userEmail = null;
    private int adminId = 0;
    private AdminDao adminDao = new AdminDao();
    private String email = null;
    private List<Messaging> messagingList;
    private UsersDao usersDao = new UsersDao();
    private int CountAdminMessages = 0;
    private int ToID = 0;

    private String emailTo = null;
    private String emailTitle = null;
    private String emailBody = null;
    private Messaging messaging;
    private String emailFrom = null;
    private String emailRead = null;
    private String emailImportant = null;
    private int sendEmail = 0;
    private int UserWebId = 0;
    private String MessageFrom = null;
    private static String messageIdToDelete = null;
    private static int checkDeleteMessage = 0;
    private int updateImportanceOfEmail = 0;
    private AddressBoxDao addressBoxDao = new AddressBoxDao();
    private int emailId = 0;
    private String value = null;
    private String emailID = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            openAdminMailBox(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            openAdminMailBox(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void openAdminMailBox(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
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
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("adminuser"));
        System.out.println("adminuser : " + userEmail);

        getAdminIdbyEmail(userEmail);
        getAdminEmails(adminId);
        checkEmailCount();
        sendToPage(request, response);

    }

    private void getAdminIdbyEmail(String userEmail) {
        List<Admin> adminList = adminDao.LoadAdminByEmail(userEmail);
        for (int i = 0; i <adminList.size() ; i++) {
            adminId = adminList.get(i).getAdminId();
        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        getUserId(emailTo);

    }

    private int getUserId(String emailTo) {
        List<Users> usersList = usersDao.LoadUsersInfo(emailTo);
        for (int i = 0; i < usersList.size(); i++) {
            UserWebId = usersList.get(i).getUserWebId();
        }
        return UserWebId;
    }

    private void sendToPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("emailMessages", messagingList);
        request.setAttribute("CountAdminMessages", CountAdminMessages);
        request.setAttribute("CountAdminMessages", CountAdminMessages);
        request.setAttribute("AdminEmail", adminId);
        request.getRequestDispatcher("/WEB-INF/Admin/AdminMailBox.jsp").forward(request, response);
    }

    private void getAdminEmails(int userEmail) throws SQLException {
        messagingList = usersDao.getAdminMessages(userEmail);
    }


    private void checkEmailCount() throws SQLException {
        messagingList = usersDao.getAdminMessages(adminId);
        for (Messaging messaging : messagingList) {
            if (messaging.getMessageRead().toLowerCase().trim().equals("false")) {
                CountAdminMessages++;
            }
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
}
