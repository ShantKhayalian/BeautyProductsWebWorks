package BeautyIt.BP.EmailController;

import BeautyIt.BP.Dao.UsersDao;

import javax.servlet.http.HttpServletRequest;

public class DeleteMessages {
    private static String  messageIdToDelete = null;
    private static UsersDao usersDao = new UsersDao();
    private static int checkDeleteMessage =0;

    protected static boolean deleteMessageById(HttpServletRequest request){
        String checkedboxes[] = request.getParameterValues("chkSingle");
        for (int i = 0; i <checkedboxes.length ; i++) {
            messageIdToDelete = checkedboxes[i];
            checkDeleteMessage =  usersDao.DeleteMessages(messageIdToDelete);
        }
        if (checkDeleteMessage > 0) {
            return true;

        }

        return false;
    }
}
