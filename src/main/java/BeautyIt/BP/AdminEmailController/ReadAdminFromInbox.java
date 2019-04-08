package BeautyIt.BP.AdminEmailController;

import BeautyIt.BP.Bean.Messaging;
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

@WebServlet("/ReadAdminFromInbox")
public class ReadAdminFromInbox extends HttpServlet {
    private String userEmail = null;
    private String emailId = null;
    private int emailIdFromString =0;
    private  UsersDao usersDao = new UsersDao();


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
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("adminuser"));
        System.out.println("adminuser : " + userEmail);

        emailId = request.getParameter("EmailId");
        emailIdFromString = Integer.parseInt(emailId);

        List<Messaging> mesageById = usersDao.readAdminMessages(emailIdFromString);
        // Request Dispatcher to Index.Jsp

        request.setAttribute("toUserEmail",userEmail);
        request.setAttribute("mesageById",mesageById);
        request.getRequestDispatcher("/WEB-INF/Admin/AdminReadInbox.jsp").forward(request, response);

    }
}
