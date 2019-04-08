package BeautyIt.BP.Dao;

import BeautyIt.BP.Bean.AddressBox;
import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.Users;
import BeautyIt.BP.Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressBoxDao {
    /**
     * Adding to address box
     * @param addressBox
     * @return
     */
    public int AddToAddressBox(AddressBox addressBox) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "Insert into `humusam_root`.`addressbook`  values(Default,?,?,?,?,?,?,?)";
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setInt(1, addressBox.getBoxOwnerId());
            statment.setString(2, addressBox.getBoxOwnerName());
            statment.setString(3, addressBox.getBoxOwnerEmail());
            statment.setInt(4, addressBox.getAddedId());
            statment.setString(5, addressBox.getAddedName());
            statment.setString(6, addressBox.getAddedLastName());
            statment.setString(7,"true");

            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    public List<AddressBox> CheckIfAddressExsists(String userOwnerEmail) {
        AddressBox addressBox = null;
        List<AddressBox> addressBoxList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`addressbook` WHERE `BoxOwnerEmail` like '%" + userOwnerEmail + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {

                addressBox = new AddressBox();
                addressBox.setAddressBookId(set.getInt("AddressBookId"));
                addressBox.setBoxOwnerId(set.getInt("BoxOwnerId"));
                addressBox.setBoxOwnerName(set.getString("BoxOwnerName"));
                addressBox.setBoxOwnerEmail(set.getString("BoxOwnerEmail"));
                addressBox.setAddedId(set.getInt("AddedId"));
                addressBox.setAddedName(set.getString("AddedName"));
                addressBox.setAddedLastName(set.getString("AddedLastName"));
                addressBoxList.add(addressBox);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in Admin Section  : " + exception);
            exception.printStackTrace();
        }
        return addressBoxList;

    }


    /**
     *
     * @return
     */
    public List<AddressBox> LoadAllAddress(int userWebId) {
        AddressBox addressBox = null;
        List<AddressBox> addressBoxList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM addressbook WHERE BoxOwnerId=" + userWebId + " ORDER BY AddedId DESC ";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {

                addressBox = new AddressBox();
                addressBox.setAddressBookId(set.getInt("AddressBookId"));
                addressBox.setBoxOwnerId(set.getInt("BoxOwnerId"));
                addressBox.setBoxOwnerName(set.getString("BoxOwnerName"));
                addressBox.setBoxOwnerEmail(set.getString("BoxOwnerEmail"));
                addressBox.setAddedId(set.getInt("AddedId"));
                addressBox.setAddedName(set.getString("AddedName"));
                addressBox.setAddedLastName(set.getString("AddedLastName"));
                addressBoxList.add(addressBox);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllCategories Section  : " + exception);
            exception.printStackTrace();
        }
        return addressBoxList;

    }
}
