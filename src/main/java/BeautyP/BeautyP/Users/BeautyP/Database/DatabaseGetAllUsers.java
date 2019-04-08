package BeautyP.BeautyP.Users.BeautyP.Database;

import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.UsersDao;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGetAllUsers {

    private static List<Users> users = new ArrayList<>();

    public static List<Users> getUsers(){
        UsersDao usersDao = new UsersDao();
        users = usersDao.LoadAllUsers();
        return users;
    }


}
