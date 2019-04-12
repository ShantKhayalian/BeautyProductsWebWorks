package BeautyIt.BP.Dao;

import BeautyIt.BP.Bean.Menu;
import BeautyIt.BP.Bean.SubMenu;
import BeautyIt.BP.Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubMenuDao {

    /**
     * Adding new SubMenu
     * @param subMenu
     * @return
     */
    public int AddSubMenu(SubMenu subMenu) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "INSERT INTO `humusam_root`.`submenu` values(Default,?,?,?,?,?,?,?,?)";
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setInt(1, subMenu.getMenuId());
            statment.setString(2,subMenu.getMenuname());
            statment.setInt(3,subMenu.getSubMenuWebId());
            statment.setString(4, subMenu.getSubMenuDefualtName());
            statment.setString(5, subMenu.getSubMenuArmenianName());
            statment.setString(6, subMenu.getSubMenuArabicName());
            statment.setString(7, subMenu.getSubMenuRussianName());
            statment.setString(8, subMenu.getSubMenuFrenchName());
            System.out.println("in addMenu statement");
            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    /**
     * Load All Sub Menu
     * @return
     */
    public List<SubMenu> LoadAllSubMenu() {
        SubMenu subMenu = null;
        List<SubMenu> subMenuList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`submenu` ORDER BY subMenuId ASC ";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {
                subMenu = new SubMenu();
                subMenu.setSubMenuId(set.getInt("subMenuId"));
                subMenu.setMenuId(set.getInt("menuId"));
                subMenu.setMenuname(set.getString("menuname"));
                subMenu.setSubMenuWebId(set.getInt("subMenuWebId"));
                subMenu.setSubMenuDefualtName(set.getString("subMenuDefualtName"));
                subMenu.setSubMenuArmenianName(set.getString("subMenuArmenianName"));
                subMenu.setSubMenuArabicName(set.getString("subMenuArabicName"));
                subMenu.setSubMenuRussianName(set.getString("subMenuRussianName"));
                subMenu.setSubMenuFrenchName(set.getString("subMenuFrenchName"));

                subMenuList.add(subMenu);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return subMenuList;
    }

    /**
     *
     * @param subMenuId
     * @return
     */
    public int RemoveSubMenu(int subMenuId) {
        int rowsDeleted = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String deletQuery = "DELETE  FROM `humusam_root`.`submenu` WHERE subMenuId="+subMenuId ;

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



}
