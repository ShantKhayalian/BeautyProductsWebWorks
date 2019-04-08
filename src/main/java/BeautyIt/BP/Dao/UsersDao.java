package BeautyIt.BP.Dao;

import BeautyIt.BP.Bean.Messaging;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {

    /**
     * Method to Load User By Web ID
     *
     * @param userWebID
     * @return
     */
    public List<Users> LoadUsersByID(int userWebID) {
        Users users = null;
        List<Users> UsersList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `users` WHERE `UserWebId`=" + userWebID;
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListUsers(UsersList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return UsersList;

    }

    private void ListUsers(List<Users> usersList, ResultSet set) throws SQLException {
        Users users;
        while (set.next()) {
            users = new Users();
            users.setUserID(set.getInt("UserID"));
            users.setUserWebId(set.getInt("UserWebId"));
            users.setUserEmail(set.getString("userEmail"));
            users.setUserPassword(set.getString("UserPassword"));
            users.setUserFirstName(set.getString("UserFirstName"));
            users.setUserLastName(set.getString("UserLastName"));
            users.setUserCity(set.getString("UserCity"));
            users.setUserState(set.getString("UserCity"));
            users.setUserZip(set.getString("UserZip"));
            users.setIsUserEmailVerified(set.getString("IsUserEmailVerified"));
            users.setUserRegistrationDate(set.getDate("UserRegistrationDate"));
            users.setUserPhone(set.getString("UserPhone"));
            users.setUserCountry(set.getString("UserCountry"));
            users.setUserAddress(set.getString("UserAddress"));
            users.setUserAddress2(set.getString("UserAddress2"));
            users.setIsUserAddressVerified(set.getString("IsUserAddressVerified"));
            users.setIsUserPhoneVerified(set.getString("IsUserPhoneVerified"));
            users.setUserEmailVerificationCode(set.getString("UserEmailVerificationCode"));
            users.setUserAddressVerificationCode(set.getString("UserAddressVerificationCode"));
            users.setUserPhoneVerificationCode(set.getString("UserPhoneVerificationCode"));
            users.setIsUserSeller(set.getString("IsUserSeller"));
            users.setSellerID(set.getInt("SellerID"));

            usersList.add(users);
        }
    }

    /**
     * Adding user first time
     *
     * @param users
     * @return
     */
    public int AddUser(Users users) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "INSERT INTO `humusam_root`.`Users`(`UserID`, `UserWebId`, `UserEmail`, `UserPassword`,`UserFirstName`,`UserLastName`,`UserCity`,`UserState`,`UserZip`,`IsUserEmailVerified`,"
                    + "`UserPhone`,`UserCountry`,`UserAddress`,`UserAddress2`, `IsUserAddressVerified`, `IsUserPhoneVerified`, `UserEmailVerificationCode`, `UserAddressVerificationCode`, `UserPhoneVerificationCode`,`IsUserSeller`,`SellerID`) "
                    + "VALUES (Default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setInt(1, users.getUserWebId());
            statment.setString(2, users.getUserEmail());
            statment.setString(3, users.getUserPassword());
            statment.setString(4, "null");
            statment.setString(5, "null");
            statment.setString(6, "null");
            statment.setString(7, "null");
            statment.setString(8, "null");
            statment.setString(9, users.getIsUserEmailVerified());
            statment.setString(10, "null");
            statment.setString(11, "null");
            statment.setString(12, "null");
            statment.setString(13, "null");
            statment.setString(14, users.getIsUserAddressVerified());
            statment.setString(15, users.getIsUserPhoneVerified());
            statment.setString(16, users.getUserEmailVerificationCode());
            statment.setString(17, users.getUserAddressVerificationCode());
            statment.setString(18, users.getUserPhoneVerificationCode());
            statment.setString(19, "null");
            statment.setInt(20, 0);

            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }




    /**
     * Load All users
     *
     * @return
     */
    public List<Users> LoadAllUsers() {
        Users users = null;
        List<Users> UsersList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            //String sql = "SELECT * FROM `humusam_root`.`Users`";
            String sql = "SELECT * FROM `users`";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListUsers(UsersList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return UsersList;

    }

    /**
     * Load All Emails
     *
     * @return
     */
    public List<Messaging> SpyEmails() {
        Messaging messaging = null;
        List<Messaging> messagingList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            //String sql = "SELECT * FROM `humusam_root`.`Users`";
            String sql = "SELECT * FROM `messagingfromadmin` ORDER BY  MessageDate DESC";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {
                messaging = new Messaging();
                messaging.setMessageID(set.getInt("messageID"));
                messaging.setUserWebID(set.getInt("UserWebID"));
                messaging.setMessageFrom(set.getString("MessageFrom"));
                messaging.setMessageRead(set.getString("MessageRead"));
                messaging.setMessageTitle(set.getString("MessageTitle"));
                messaging.setMessageDate(set.getDate("MessageDate"));
                messaging.setMessageImportant(set.getString("MessageImportant"));
                messaging.setMessageTo(set.getString("MessageTo"));

                messagingList.add(messaging);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return messagingList;

    }


    /**
     * Load users Email form Database to check existence in Registry
     *
     * @return
     */
    public List<Users> LoadUserEmailForChecking(String email) {
        Users users = null;
        List<Users> UsersList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `users` WHERE `UserEmail` like '%" + email + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {
                users = new Users();
                users.setUserEmail(set.getString("userEmail"));

                UsersList.add(users);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return UsersList;

    }

    public List<Users> LoadUserbyName(String name) {
        Users users = null;
        List<Users> UsersList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `humusam_root`.`users` WHERE `UserFirstName` like '%" + name + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            usersSets(UsersList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return UsersList;

    }

    private void usersSets(List<Users> usersList, ResultSet set) throws SQLException {
        Users users;
        while (set.next()) {
            users = new Users();
            users.setUserID(set.getInt("userID"));
            users.setUserWebId(set.getInt("userWebId"));
            users.setUserEmail(set.getString("userEmail"));
            users.setUserPassword(set.getString("userPassword"));
            users.setUserFirstName(set.getString("userFirstName"));
            users.setUserLastName(set.getString("userLastName"));

            users.setUserCity(set.getString("userCity"));
            users.setUserState(set.getString("userState"));
            users.setUserZip(set.getString("userZip"));
            users.setIsUserEmailVerified(set.getString("isUserEmailVerified"));

            users.setUserRegistrationDate(set.getDate("userRegistrationDate"));
            users.setUserPhone(set.getString("userPhone"));
            users.setUserCountry(set.getString("userCountry"));
            users.setUserAddress(set.getString("userAddress"));

            users.setUserAddress2(set.getString("userAddress2"));
            users.setIsUserPhoneVerified(set.getString("isUserAddressVerified"));
            users.setUserEmailVerificationCode(set.getString("userEmailVerificationCode"));
            users.setUserAddressVerificationCode(set.getString("userAddressVerificationCode"));

            users.setUserPhoneVerificationCode(set.getString("userPhoneVerificationCode"));
            users.setIsUserSeller(set.getString("isUserSeller"));
            users.setSellerID(set.getInt("sellerID"));

            usersList.add(users);

        }
    }

    /**
     * Loading user email verification code to check with the income link from Email
     *
     * @param USerWebId
     * @return
     */
    public List<Users> LoadUserEmailVerificationCode(int USerWebId) {
        Users users = null;
        List<Users> UsersList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserWebId =" + USerWebId;
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {
                users = new Users();
                users.setUserEmailVerificationCode(set.getString("userEmailVerificationCode"));

                UsersList.add(users);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return UsersList;
    }

    /**
     * getMessagesByUserWebId
     *
     * @param UserWebId
     * @return
     * @throws SQLException
     */
    public List<Messaging> getMessagesByUserWebId(int UserWebId) throws SQLException {
        Messaging messaging = null;
        List<Messaging> MessagesLists = new ArrayList<>();
        Connection connection = DBConnection.getConnectionToDatabase();
        String sql = "SELECT * FROM `humusam_root`.`MessagingFromAdmin` Where UserWebID=" + UserWebId + " ORDER BY MessageDate DESC ";
        Statement statment = connection.createStatement();
        ResultSet set = statment.executeQuery(sql);
        while (set.next()) {
            messaging = new Messaging();
            messaging.setMessageen(set.getString("messageen"));
            messaging.setMessageFrom(set.getString("messageFrom"));
            messaging.setMessageTitle(set.getString("messageTitle"));
            messaging.setMessageRead(set.getString("messageRead"));
            messaging.setMessageDate(set.getDate("messageDate"));
            messaging.setMessageImportant(set.getString("messageImportant"));
            messaging.setMessageID(set.getInt("messageID"));
            messaging.setMessageTo(set.getString("MessageTo"));
            MessagesLists.add(messaging);

        }
        return MessagesLists;
    }

    public List<Messaging> getMessagesById(int MessageID) throws SQLException {
        Messaging messaging = null;
        List<Messaging> MessagesLists = new ArrayList<>();
        Connection connection = DBConnection.getConnectionToDatabase();
        String sql = "SELECT * FROM `humusam_root`.`MessagingFromAdmin` Where MessageID=" + MessageID;
        Statement statment = connection.createStatement();
        ResultSet set = statment.executeQuery(sql);
        while (set.next()) {
            messaging = new Messaging();
            messaging.setMessageen(set.getString("messageen"));
            messaging.setMessageFrom(set.getString("messageFrom"));
            messaging.setMessageTitle(set.getString("messageTitle"));
            messaging.setMessageRead(set.getString("messageRead"));
            messaging.setMessageDate(set.getDate("messageDate"));
            messaging.setMessageImportant(set.getString("messageImportant"));
            messaging.setMessageID(set.getInt("messageID"));
            messaging.setMessageTo(set.getString("MessageTo"));
            MessagesLists.add(messaging);

        }
        return MessagesLists;
    }


    /**
     * getMessagesByAdminId
     *
     * @param UserWebID
     * @return
     * @throws SQLException
     */
    public List<Messaging> getAdminMessages(int UserWebID) throws SQLException {
        Messaging messaging = null;
        List<Messaging> MessagesLists = new ArrayList<>();
        Connection connection = DBConnection.getConnectionToDatabase();
        String sql = "SELECT * FROM `humusam_root`.`MessagingFromAdmin` Where UserWebID=" + UserWebID + " ORDER BY MessageDate DESC ";
        Statement statment = connection.createStatement();
        ResultSet set = statment.executeQuery(sql);
        while (set.next()) {
            messaging = new Messaging();
            messaging.setMessageen(set.getString("messageen"));
            messaging.setMessageFrom(set.getString("messageFrom"));
            messaging.setMessageTitle(set.getString("messageTitle"));
            messaging.setMessageRead(set.getString("messageRead"));
            messaging.setMessageDate(set.getDate("messageDate"));
            messaging.setMessageImportant(set.getString("messageImportant"));
            messaging.setMessageID(set.getInt("messageID"));
            messaging.setMessageTo(set.getString("MessageTo"));
            MessagesLists.add(messaging);

        }
        return MessagesLists;
    }

    /**
     * Adding Messages to MessageDatabase
     *
     * @param adminMessages
     * @return
     * @throws SQLException
     */
    public int AddMessagesFromAdmin(Messaging adminMessages) throws SQLException {
        int rowsAffected = 0;

        Connection connection = DBConnection.getConnectionToDatabase();
        String insertQuery = "INSERT INTO `humusam_root`.`MessagingFromAdmin`(`MessageID`, `UserWebId`, `MessageFrom`, `MessageTitle`,`Messageen`,`MessageRead`,`MessageTo`,`MessageImportant`) "
                + "VALUES (Default,?,?,?,?,?,?,?)";
        PreparedStatement statment = connection.prepareStatement(insertQuery);
        statment.setInt(1, adminMessages.getUserWebID());
        statment.setString(2, adminMessages.getMessageFrom());
        statment.setString(3, adminMessages.getMessageTitle());
        statment.setString(4, adminMessages.getMessageen());
        statment.setString(5, adminMessages.getMessageRead());
        statment.setString(6, adminMessages.getMessageTo());
        statment.setString(7, adminMessages.getMessageImportant());

        rowsAffected = statment.executeUpdate();

        return rowsAffected;

    }

    /**
     * Adding Messages to MessageDatabase
     *
     * @param adminMessages
     * @return
     * @throws SQLException
     */
    public int SendEmail(Messaging adminMessages) throws SQLException {
        int rowsAffected = 0;

        Connection connection = DBConnection.getConnectionToDatabase();
        String insertQuery = "INSERT INTO `humusam_root`.`MessagingFromAdmin`(`MessageID`, `UserWebId`, `MessageFrom`, `MessageTitle`,`Messageen`,`MessageRead`,`MessageTo`,`MessageImportant`) "
                + "VALUES (Default,?,?,?,?,?,?,?)";
        PreparedStatement statment = connection.prepareStatement(insertQuery);
        statment.setInt(1, adminMessages.getUserWebID());
        statment.setString(2, adminMessages.getMessageFrom());
        statment.setString(3, adminMessages.getMessageTitle());
        statment.setString(4, adminMessages.getMessageen());
        statment.setString(5, adminMessages.getMessageRead());
        statment.setString(6, adminMessages.getMessageTo());
        statment.setString(7, adminMessages.getMessageImportant());

        rowsAffected = statment.executeUpdate();

        return rowsAffected;

    }

    /**
     * Updating user Email Verification in the database to true
     *
     * @param UserWebId
     * @return
     */
    public int UpdateUserEmailVerification(int UserWebId) {
        int rowsUpdated = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "UPDATE `humusam_root`.`Users`  SET IsUserEmailVerified=? WHERE UserWebId=" + UserWebId;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "true");
            rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsUpdated;
    }

    /**
     *
     * @param UserWebId
     * @return
     */
    public int UpdatePassword(int UserWebId,String changePassword) {
        int rowsUpdated = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "UPDATE `humusam_root`.`Users`  SET UserPassword=? WHERE UserWebId=" + UserWebId;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, changePassword);
            rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsUpdated;
    }

    /**
     *
     * @param users
     * @return
     */
    public int UpdateUserInfo(Users users,int UserWebId) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "UPDATE `humusam_root`.`Users` SET UserEmail=?, UserFirstName=?,UserLastName=?,UserCity=?,UserState=?,UserZip=?,UserPhone=?,UserCountry=?,UserAddress=?,UserAddress2=? WHERE UserWebId =" +UserWebId;
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setString(1,users.getUserEmail());
            statment.setString(2,users.getUserFirstName());
            statment.setString(3,users.getUserLastName());
            statment.setString(4,users.getUserCity());
            statment.setString(5,users.getUserState());
            statment.setString(6,users.getUserZip());
            statment.setString(7,users.getUserPhone());
            statment.setString(8,users.getUserCountry());
            statment.setString(9,users.getUserAddress());
            statment.setString(10,users.getUserAddress2());

            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    /**
     * @param UserWebId
     * @param SellerID
     * @return
     */
    public int ChangeUSerToSeller(int UserWebId, int SellerID) {
        int rowsUpdated = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "UPDATE `humusam_root`.`Users`  SET IsUserSeller=?,SellerID=? WHERE UserWebId=" + UserWebId;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "true");
            statement.setInt(2, SellerID);
            rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsUpdated;
    }


    /**
     * Validating user login
     *
     * @param emailAddress
     * @param password
     * @return
     */
    public boolean validateUsersLogin(String emailAddress, String password) {
        boolean isValidAdminUser = false;
        System.out.println("Validat Admin Section");
        try {
            // get the connection for the database
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "SELECT *  FROM   `humusam_root`.`users` WHERE UserEmail =? AND  UserPassword =?";
            System.out.println("Connection SQL :  " + sql);
            // set parameters with PreparedStatement
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, emailAddress);
            System.out.println("Connection username :  " + emailAddress);
            statment.setString(2, password);
            System.out.println("Connection password :  " + password);

            // execute the statement and check whether user exists
            ResultSet set = statment.executeQuery();
            while (set.next()) {
                isValidAdminUser = true;
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("SQLException exception message : " + exception);
        }
        return isValidAdminUser;
    }

    public List<Users> LoadUsersInfo(String emailAddress) {
        Users users = null;
        List<Users> UsersList = new ArrayList<>();
        userInfo(emailAddress, UsersList);
        return UsersList;

    }

    private void userInfo(String emailAddress, List<Users> usersList) {
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`users` where UserEmail=?";
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, emailAddress);
            ResultSet set = statment.executeQuery();
            usersSets(usersList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in Admin Section  : " + exception);
            exception.printStackTrace();
        }
    }

    /**
     * @param messageIdToDelete
     * @return
     */
    public int DeleteMessages(String messageIdToDelete) {

        int rowsDeleted = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "DELETE FROM `humusam_root`.`messagingfromadmin` WHERE  MessageID=?";
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setInt(1, Integer.parseInt(messageIdToDelete));

            rowsDeleted = statment.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A Message was deleted successfully!");
            }

        } catch (SQLException exception) {
            System.out.println("sqlException in Application in CATEGORY DELETE  Section  : " + exception);
            exception.printStackTrace();
        }
        return rowsDeleted;
    }

    /**
     * @param messageId
     * @param importanceValue
     * @return
     */
    public int UpdateEmailImportance(int messageId, String importanceValue) {
        int rowsUpdated = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "UPDATE `humusam_root`.`messagingfromadmin`  SET MessageImportant=? WHERE MessageID=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, importanceValue);
            statement.setInt(2, messageId);

            rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("An existing CATEGORY NAME was updated successfully!");
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in CATEGORY NAME UPDATE Section  : " + exception);
            exception.printStackTrace();
        }
        return rowsUpdated;
    }

    /**
     * @param messageId
     * @param MassageRead
     * @return
     */
    public int UpdateEmailRead(int messageId, String MassageRead) {
        int rowsUpdated = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "UPDATE `humusam_root`.`messagingfromadmin`  SET MessageRead=? WHERE MessageID=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, MassageRead);
            statement.setInt(2, messageId);

            rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("An existing CATEGORY NAME was updated successfully!");
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in CATEGORY NAME UPDATE Section  : " + exception);
            exception.printStackTrace();
        }
        return rowsUpdated;
    }

    public List<Messaging> readAdminMessages(int emailIdFromString) throws SQLException {
        Messaging messaging = null;
        List<Messaging> MessagesLists = new ArrayList<>();
        Connection connection = DBConnection.getConnectionToDatabase();
        String sql = "SELECT * FROM `humusam_root`.`MessagingFromAdmin` Where MessageID=" + emailIdFromString + " ORDER BY MessageDate DESC ";
        Statement statment = connection.createStatement();
        ResultSet set = statment.executeQuery(sql);
        while (set.next()) {
            messaging = new Messaging();
            messaging.setMessageen(set.getString("messageen"));
            messaging.setMessageFrom(set.getString("messageFrom"));
            messaging.setMessageTitle(set.getString("messageTitle"));
            messaging.setMessageRead(set.getString("messageRead"));
            messaging.setMessageDate(set.getDate("messageDate"));
            messaging.setMessageImportant(set.getString("messageImportant"));
            messaging.setMessageID(set.getInt("messageID"));
            messaging.setMessageTo(set.getString("MessageTo"));
            MessagesLists.add(messaging);

        }
        return MessagesLists;
    }
}