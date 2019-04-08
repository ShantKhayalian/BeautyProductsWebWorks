package BeautyP.BeautyP.Users.BeautyP.UsersServices;

import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Dao.UsersDao;
import BeautyP.BeautyP.Users.BeautyP.Database.DatabaseGetAllUsers;
import BeautyP.BeautyP.Users.BeautyP.Database.DatabaseGetUsersWebId;

import java.util.ArrayList;
import java.util.List;

public class UsersService {


    int AddUser = 0;
    UsersDao usersDao = new UsersDao();


    public List<Users> getAllUsers() {
       List<Users> users = DatabaseGetAllUsers.getUsers();
        return new ArrayList<>(users);
    }


    public List<Users> getUserById(int userWebId) {
        List<Users> users = DatabaseGetUsersWebId.getUserById(userWebId);
        return new ArrayList<>(users);
    }

    public Users addUser(Users users){

        usersDao = new UsersDao();
        AddUser = usersDao.AddUser(users);
        if(AddUser != 0){
            System.out.println("User Added to database");
        }
        return users;
    }


    public Users updateUser(Users users) {
        return users;
    }

    public void deleteUser(int userWebId) {
       // usersDao.deleteUser(userWebId);
    }


}
