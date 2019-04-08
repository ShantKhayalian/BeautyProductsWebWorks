package BeautyP.BeautyP.Users.BeautyP.Database;

import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.UsersDao;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGetUsersWebId {
    private static List<Users> users = new ArrayList<>();

    public static List<Users> getUserById(int id){
        UsersDao usersDao = new UsersDao();
        users = usersDao.LoadUsersByID(id);
        return users;
    }
}
