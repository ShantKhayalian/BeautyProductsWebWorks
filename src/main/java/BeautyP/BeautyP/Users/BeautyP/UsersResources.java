package BeautyP.BeautyP.Users.BeautyP;

import BeautyIt.BP.Bean.Users;
import BeautyP.BeautyP.Users.BeautyP.UsersServices.UsersService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/Users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResources {

    UsersService usersService = new UsersService();

    @GET
    public List<Users> getUsers(){
        return usersService.getAllUsers();
    }

    @GET
    @Path("/{UserWebId}")
    public List<Users> getUserById(@PathParam("UserWebId") int UserWebId){
        return usersService.getUserById(UserWebId);
    }

    @POST
    public Users addUsers(Users users){
        return usersService.addUser(users);
    }

    @PUT
    @Path("/{UserWebId}")
    public Users updateUsers(@PathParam("UserWebId") int UserWebId, Users users){
        return usersService.updateUser(users);
    }

    @DELETE
    @Path("/{UserWebId}")
    public void deleteUser(@PathParam("UserWebId") int UserWebId){
        usersService.deleteUser(UserWebId);
    }

}
