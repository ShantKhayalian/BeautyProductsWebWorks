package BeautyIt.BP.Dao;

import BeautyIt.BP.Bean.Menu;
import BeautyIt.BP.Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {

    /**
     * Adding new menu
     *
     * @param menu
     * @return
     */
    public int AddMenu(Menu menu) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "INSERT INTO `humusam_root`.`menu` values(Default,?,?,?,?,?,?)";
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setInt(1, menu.getMenuWebID());
            statment.setString(2, menu.getMenuDefualtName());
            statment.setString(3, menu.getMenuArmenianName());
            statment.setString(4, menu.getMenuArabicName());
            statment.setString(5, menu.getMenuRussianName());
            statment.setString(6, menu.getMenuFrenchName());
            System.out.println("in addMenu statement");
            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    /**
     * Delete menu
     * @param adminId
     * @return
     */
    public int deleteMenu(int adminId) {
        int rowsDeleted = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String deletQuery = "DELETE  FROM `humusam_root`.`menu` WHERE MenuID="+adminId ;

            PreparedStatement statment = connection.prepareStatement(deletQuery);

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
     * Loading all menu
     * @return
     */
    public List<Menu> LoadAllMenu() {
        Menu menu = null;
        List<Menu> menuList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`menu` ORDER BY MenuID ASC ";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {
                menu = new Menu();
                menu.setMenuID(set.getInt("menuID"));
                menu.setMenuWebID(set.getInt("menuWebID"));
                menu.setMenuDefualtName(set.getString("menuDefualtName"));
                menu.setMenuArmenianName(set.getString("menuArmenianName"));
                menu.setMenuArabicName(set.getString("menuArabicName"));
                menu.setMenuRussianName(set.getString("menuRussianName"));
                menu.setMenuFrenchName(set.getString("menuFrenchName"));

                menuList.add(menu);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return menuList;
    }

    /**
     * GetList menu by id
     * @param menuId
     * @return
     */
    public List<Menu> loadMenuById(int menuId) {
        Menu menu = null;
        List<Menu> menuList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`menu` WHERE MenuID="+menuId;
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {
                menu = new Menu();
                menu.setMenuID(set.getInt("menuID"));
                menu.setMenuWebID(set.getInt("menuWebID"));
                menu.setMenuDefualtName(set.getString("menuDefualtName"));
                menu.setMenuArmenianName(set.getString("menuArmenianName"));
                menu.setMenuArabicName(set.getString("menuArabicName"));
                menu.setMenuRussianName(set.getString("menuRussianName"));
                menu.setMenuFrenchName(set.getString("menuFrenchName"));

                menuList.add(menu);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return menuList;
    }

    /**
     * Load menu by web id
     * @param menuWebId
     * @return
     */
    public List<Menu> loadMenuByWebId(int menuWebId) {
        Menu menu = null;
        List<Menu> menuList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`menu` WHERE MenuWebID="+menuWebId;
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {
                menu = new Menu();
                menu.setMenuID(set.getInt("menuID"));
                menu.setMenuWebID(set.getInt("menuWebID"));
                menu.setMenuDefualtName(set.getString("menuDefualtName"));
                menu.setMenuArmenianName(set.getString("menuArmenianName"));
                menu.setMenuArabicName(set.getString("menuArabicName"));
                menu.setMenuRussianName(set.getString("menuRussianName"));
                menu.setMenuFrenchName(set.getString("menuFrenchName"));

                menuList.add(menu);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return menuList;
    }

    /**
     * Update

     */
    public int updateMenu(Menu menu, int menuid) {
        int rowsUpdated = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "UPDATE `humusam_root`.`menu` SET MenuDefualtName=?,MenuArmenianName=?,MenuArabicName=?,MenuRussianName=?,MenuFrenchName=?  WHERE MenuID="+menuid;

            PreparedStatement statement = connection.prepareStatement(sql);
            // statement.setInt(1,adminID);
            // statement.setString(1, adminUserName);
            statement.setString(1, menu.getMenuDefualtName());
            statement.setString(2, menu.getMenuArmenianName());
            statement.setString(3, menu.getMenuArabicName());
            statement.setString(4, menu.getMenuRussianName());
            statement.setString(5, menu.getMenuFrenchName());

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
