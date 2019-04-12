package BeautyIt.BP.Dao;

import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.SellerRating;
import BeautyIt.BP.Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellerRatingDao {

    /**
     *
     * @param sellerRating
     * @return
     */

    public int addNewRating(SellerRating sellerRating) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "Insert into `humusam_root`.`sellerrating`  values(Default,?,?)";
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setInt(1, sellerRating.getSellerID());
            statment.setDouble(2, sellerRating.getSellerRatingNumbers());

            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    /**
     * Loading rating by seller id
     * @param sellerID
     * @return
     */
    public List<SellerRating> LoadSellerRatingBySellerId(int sellerID) {
        SellerRating sellerRating= null;
        List<SellerRating> sellerRatings = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM `humusam_root`.`sellerrating` WHERE SellerID=" + sellerID;
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            while (set.next()) {
                sellerRating = new SellerRating();
                sellerRating.setSellerRatingID(set.getInt("sellerRatingID"));
                sellerRating.setSellerID(set.getInt("sellerID"));
                sellerRating.setSellerRatingNumbers(set.getDouble("sellerRatingNumbers"));
                sellerRatings.add(sellerRating);
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in Admin Section  : " + exception);
            exception.printStackTrace();
        }
        return sellerRatings;

    }

    /**
     * Update rating for seller id
     * @param sellerRating
     * @param SellerId
     * @return
     */
    public int updateRatingForSeller(SellerRating sellerRating, int SellerId) {
        int rowsUpdated = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "UPDATE sellerrating SET sellerRatingNumbers=? WHERE SellerID="+SellerId;

            PreparedStatement statement = connection.prepareStatement(sql);
            // statement.setInt(1,adminID);
            // statement.setString(1, adminUserName);
            statement.setDouble(1, sellerRating.getSellerRatingNumbers());

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
