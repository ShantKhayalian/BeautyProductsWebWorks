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
import java.util.Date;
import java.util.List;

@WebServlet("/SpyIndex")
public class SpyIndex extends HttpServlet {
    private String userEmail =null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        userEmail = String.valueOf(session.getAttribute("UserName"));
        System.out.println(userEmail);

        UsersDao usersDao = new UsersDao();
        List<Messaging> messagingList = usersDao.SpyEmails();
        Date from = null;
        for (int i = 0; i < messagingList.size(); i++) {
            from = messagingList.get(i).getMessageDate();
        }
        System.out.println(from);
        request.setAttribute("spyEmail", messagingList);
        request.getRequestDispatcher("/WEB-INF/Admin/AdminSpyEmails.jsp")
                .forward(request, response);
    }
}
