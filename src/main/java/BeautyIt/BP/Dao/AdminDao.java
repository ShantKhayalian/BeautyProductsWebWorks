package BeautyIt.BP.Dao;

import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    /**
     * Check user exists
     *
     * @param username
     * @param password
     * @return
     */
    public boolean validateAdminUsers(String username, String password) {
        boolean isValidAdminUser = false;
        System.out.println("Validat Admin Section");
        try {
            // get the connection for the database
            Connection connection = DBConnection.getConnectionToDatabase();
            System.out.println("Connection Admin");

            // write the insert query
            // String sql = "select * from adminsection where admin_user_name=? and
            // admin_password =?";
            String sql = "SELECT *  FROM  `humusam_root`.`admin_section` WHERE admin_email =? AND  admin_password =?";
            System.out.println("Connection SQL :  " + sql);
            // set parameters with PreparedStatement
            PreparedStatement statment = connection.prepareStatement(sql);
            System.out.println("Connection statment :  " + statment);
            statment.setString(1, username);
            System.out.println("Connection username :  " + username);
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

    /**
     * Method to load one admin by username
     *
     * @param username
     * @return
     */
    public List<Admin> LoadAdmin(String username) {
        Admin admin = null;
        List<Admin> adminList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`admin_section` where admin_email =?";

            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, username);
            ResultSet set = statment.executeQuery();
            while (set.next()) {

                admin = new Admin();
                admin.setAdminId(set.getInt("admin_id"));
                admin.setAdmin_Name(set.getString("admin_name"));
                admin.setAdmin_Surname(set.getString("admin_surname"));
                admin.setAdmin_Username(set.getString("admin_user_name"));
                admin.setAdmin_Password(set.getString("admin_password"));
                admin.setAdmin_Email(set.getString("admin_email"));
                admin.setAdmin_Phone_Number(set.getString("admin_phone_number"));
                adminList.add(admin);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in Admin Section  : " + exception);
            exception.printStackTrace();
        }
        return adminList;

    }

    /**
     *  Method to load one admin by email
     * @param email
     * @return
     */
    public List<Admin> LoadAdminByEmail(String email) {
        Admin admin = null;
        List<Admin> adminList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`admin_section` where `admin_email` like '%" + email + "%'";

            PreparedStatement statment = connection.prepareStatement(sql);
            //statment.setString(1, email);
            ResultSet set = statment.executeQuery();
            while (set.next()) {

                admin = new Admin();
                admin.setAdminId(set.getInt("admin_id"));
                admin.setAdmin_Name(set.getString("admin_Name"));
                admin.setAdmin_Surname(set.getString("admin_user_name"));
                admin.setAdmin_Username(set.getString("admin_surname"));
                admin.setAdmin_Password(set.getString("admin_password"));
                admin.setAdmin_Email(set.getString("admin_email"));
                admin.setAdmin_Phone_Number(set.getString("admin_phone_number"));
                adminList.add(admin);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in Admin Section  : " + exception);
            exception.printStackTrace();
        }
        return adminList;

    }

    public List<Admin> LoadAdminById(int UserID) {
        Admin admin = null;
        List<Admin> adminList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`admin_section` where admin_id=" + UserID ;

            PreparedStatement statment = connection.prepareStatement(sql);
            //statment.setString(1, email);
            ResultSet set = statment.executeQuery();
            while (set.next()) {

                admin = new Admin();
                admin.setAdminId(set.getInt("admin_id"));
                admin.setAdmin_Name(set.getString("admin_Name"));
                admin.setAdmin_Surname(set.getString("admin_user_name"));
                admin.setAdmin_Username(set.getString("admin_surname"));
                admin.setAdmin_Password(set.getString("admin_password"));
                admin.setAdmin_Email(set.getString("admin_email"));
                admin.setAdmin_Phone_Number(set.getString("admin_phone_number"));
                adminList.add(admin);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in Admin Section  : " + exception);
            exception.printStackTrace();
        }
        return adminList;

    }

    /**
     * Method to load all admin
     *
     * @return
     */
    public List<Admin> LoadAllAdmin() {
        Admin admin = null;
        List<Admin> adminList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`admin_section` ";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {

                admin = new Admin();
                admin.setAdmin_Name(set.getString("admin_Name"));
                admin.setAdmin_Surname(set.getString("admin_Surname"));
                admin.setAdmin_Username(set.getString("admin_Username"));
                admin.setAdmin_Password(set.getString("admin_Password"));
                admin.setAdmin_Email(set.getString("admin_Email"));
                admin.setAdmin_Phone_Number(set.getString("admin_Phone_Number"));
                adminList.add(admin);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in Admin Section  : " + exception);
            exception.printStackTrace();
        }
        return adminList;

    }

    /**
     * Method to Count all admin
     *
     * @return
     */
    public int CountAdmin() {
        Admin admin = null;
        int countAdmin = 0;
        List<Admin> adminList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`admin_section`";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {

                admin = new Admin();

                admin.setAdmin_Name(set.getString("admin_Name"));
                adminList.add(admin);
                for (int i = 0; i < adminList.size(); i++) {
                    countAdmin++;
                    System.out.println(countAdmin);
                }

            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in Admin Section  : " + exception);
            exception.printStackTrace();
        }
        return countAdmin;

    }

    /**
     * Adding new admin
     *
     * @param admin
     * @return
     */
    public int AddAdmin(Admin admin) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "Insert into `humusam_root`.`admin_section`  values(Default,?,?,?,?,?,?)";
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setString(1, admin.getAdmin_Username());
            statment.setString(2, admin.getAdmin_Password());
            statment.setString(3, admin.getAdmin_Name());
            statment.setString(4, admin.getAdmin_Surname());
            statment.setString(5, admin.getAdmin_Email());

            statment.setString(6, admin.getAdmin_Phone_Number());

            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    /**
     * Delete admin
     */
    public int deleteAdmin(String adminUserName) {
        int rowsDeleted = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String deletQuery = "DELETE  FROM `humusam_root`.`admin_section`  WHERE admin_user_name= ?";

            PreparedStatement statment = connection.prepareStatement(deletQuery);
            statment.setString(1, adminUserName);

            rowsDeleted = statment.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An Admin was deleted successfully!");
            }

        } catch (SQLException exception) {
            System.out.println("sqlException in Application in admin Delete Section  : " + exception);
            exception.printStackTrace();
        }
        return rowsDeleted;
    }

    /**
     * Update admin
     */
    public int UpdateAdmin(String adminName, String adminSurname, String adminEmail, String adminUserName,
                           String adminPassword, String adminPhoneNumber) {
        int rowsUpdated = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "UPDATE adminsection SET admin_Name=?,admin_Surname=?,admin_Email=?,admin_user_name=?,admin_Password=?,admin_Phone_Number=?  WHERE admin_user_name=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            // statement.setInt(1,adminID);
            // statement.setString(1, adminUserName);
            statement.setString(1, adminName);
            statement.setString(2, adminSurname);
            statement.setString(3, adminEmail);
            statement.setString(4, adminUserName);
            statement.setString(5, adminPassword);
            statement.setString(6, adminPhoneNumber);
            statement.setString(7, adminUserName);
            System.out.println("Passed Update admin section");

            rowsUpdated = statement.executeUpdate();
            System.out.println("Passed statment Update admin section");
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in admin UPDATE Section  : " + exception);
            exception.printStackTrace();
        }
        return rowsUpdated;
    }

}
