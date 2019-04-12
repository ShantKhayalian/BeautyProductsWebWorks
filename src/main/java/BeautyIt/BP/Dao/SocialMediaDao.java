package BeautyIt.BP.Dao;

import BeautyIt.BP.Bean.Admin;
import BeautyIt.BP.Bean.Brands;
import BeautyIt.BP.Bean.SocialMedia;
import BeautyIt.BP.Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SocialMediaDao {

    /**
     * Add Socials
     *
     * @param socialMedia
     * @return
     */
    public int AddSocials(SocialMedia socialMedia) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "Insert into `humusam_root`.`brandsocialmedia`  values(Default,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setInt(1, socialMedia.getBrandId());
            statment.setInt(2, socialMedia.getSellerId());
            statment.setString(3, socialMedia.getFacebook());
            statment.setString(4, socialMedia.getGoogle());
            statment.setString(5, socialMedia.getInstagram());
            statment.setString(6, socialMedia.getTwitter());
            statment.setString(7, socialMedia.getPinterest());
            statment.setString(8, socialMedia.getLinkedIn());
            statment.setString(9, socialMedia.getYouTube());

            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    public int UpdateSocials(SocialMedia socialMedia, int socialID) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "UPDATE `humusam_root`.`brandsocialmedia` SET  Facebook=?, Google=?,Instagram=?,Twitter=?,Pinterest=?,LinkedIn=?,YouTube=?" +
                    "  WHERE  SocialMediaID=" + socialID;
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setString(1, socialMedia.getFacebook());
            statment.setString(2, socialMedia.getGoogle());
            statment.setString(3, socialMedia.getInstagram());
            statment.setString(4, socialMedia.getTwitter());
            statment.setString(5, socialMedia.getPinterest());
            statment.setString(6, socialMedia.getLinkedIn());
            statment.setString(7, socialMedia.getYouTube());

            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    /**
     * @param sellerid
     * @return
     */
    public List<SocialMedia> loadSocialsBySellerId(int sellerid) {
        SocialMedia socialMedia = null;
        List<SocialMedia> socialMediaList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brandsocialmedia` WHERE `SellerId`=" + sellerid;
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            socialMediaList(socialMediaList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return socialMediaList;
    }

    /**
     * @param socialMediaList
     * @param set
     * @throws SQLException
     */
    private void socialMediaList(List<SocialMedia> socialMediaList, ResultSet set) throws SQLException {
        SocialMedia socialMedia;
        while (set.next()) {
            socialMedia = new SocialMedia();
            socialMedia.setSocialId(set.getInt("SocialMediaID"));
            socialMedia.setBrandId(set.getInt("brandId"));
            socialMedia.setSellerId(set.getInt("sellerId"));
            socialMedia.setFacebook(set.getString("facebook"));
            socialMedia.setGoogle(set.getString("Google"));
            socialMedia.setInstagram(set.getString("Instagram"));
            socialMedia.setTwitter(set.getString("Twitter"));
            socialMedia.setPinterest(set.getString("Pinterest"));
            socialMedia.setLinkedIn(set.getString("LinkedIn"));
            socialMedia.setYouTube(set.getString("YouTube"));
            socialMediaList.add(socialMedia);

        }
    }
}
