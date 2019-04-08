package BeautyIt.BP.Dao;

import BeautyIt.BP.Bean.Brands;
import BeautyIt.BP.Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandsDao {
    public int AddBrand(Brands brands) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "INSERT INTO `humusam_root`.`brands`(`BrandId`, `brandWebId`, `brandOwnerId`, `brandOwnerEmail`,`brandName`,`brandCategory`,`brandAddress1`,`brandAddress2`," +
                    "`brandCountry`,`brandCity`,`brandState`,`brandZipCode`,`brandPhoneNumber`,`brandKind`,`isBrandAddressVerified`, `isBrandPhoneNumberVerified`, `isBrandHasCertifications`) "
                    + "VALUES (Default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setInt(1, brands.getBrandWebId());
            statment.setInt(2, brands.getBrandOwnerId());
            statment.setString(3, brands.getBrandOwnerEmail());
            statment.setString(4, brands.getBrandName());
            statment.setString(5, brands.getBrandCategory());
            statment.setString(6, brands.getBrandAddress1());
            statment.setString(7, brands.getBrandAddress2());
            statment.setString(8, brands.getBrandCountry());
            statment.setString(9, brands.getBrandCity());
            statment.setString(10, brands.getBrandState());
            statment.setString(11, brands.getBrandZipCode());
            statment.setString(12, brands.getBrandPhoneNumber());
            statment.setString(13, brands.getBrandKind());
            statment.setString(14, brands.getIsBrandAddressVerified());
            statment.setString(15, brands.getIsBrandPhoneNumberVerified());
            statment.setString(16, brands.getIsBrandHasCertifications());

            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }


    /**
     * Method to Load Brands
     *
     * @return
     */
    public List<Brands> LoadAllBrands() {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands`";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * Method to Load Brands
     *
     * @return
     */
    public List<Brands> LoadBrandsById(int BrandId) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE BrandId=" + BrandId;
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * @param brandWebId
     * @return
     */
    public List<Brands> LoadBrandsByWebId(int brandWebId) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM brands WHERE brandWebId=" + brandWebId;
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * @param BrandId
     * @return
     */
    public List<Brands> LoadBrandsByOwnerId(int BrandId) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE `brandOwnerId`=" + BrandId;
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }


    /**
     * @param brandName
     * @return
     */
    public List<Brands> LoadBrandsByName(String brandName) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE brandName like '%" + brandName + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * @param brandOwnerEmail
     * @return
     */
    public List<Brands> LoadBrandsByOwnerEmail(String brandOwnerEmail) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE brandOwnerEmail '%" + brandOwnerEmail + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * @param brandCategory
     * @return
     */
    public List<Brands> LoadBrandsByCategory(String brandCategory) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE brandCategory '%" + brandCategory + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * @param brandCountry
     * @return
     */
    public List<Brands> LoadBrandsByCountry(String brandCountry) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE brandCountry '%" + brandCountry + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * brandPhoneNumber
     *
     * @param brandPhoneNumber
     * @return
     */
    public List<Brands> LoadBrandsByPhone(String brandPhoneNumber) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE brandPhoneNumber '%" + brandPhoneNumber + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * brandPhoneNumber
     *
     * @param brandKind
     * @return
     */
    public List<Brands> LoadBrandsKind(String brandKind) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE brandKind '%" + brandKind + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * brandPhoneNumber
     *
     * @param isBrandAddressVerified
     * @return
     */
    public List<Brands> LoadBrandsAddressVerified(String isBrandAddressVerified) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE isBrandAddressVerified '%" + isBrandAddressVerified + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * brandPhoneNumber
     *
     * @param isBrandPhoneNumberVerified
     * @return
     */
    public List<Brands> LoadBrandsPhoneNumVerified(String isBrandPhoneNumberVerified) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE isBrandPhoneNumberVerified '%" + isBrandPhoneNumberVerified + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * brandPhoneNumber
     *
     * @param isBrandHasCertifications
     * @return
     */
    public List<Brands> LoadBrandsHasCertification(String isBrandHasCertifications) {
        Brands brands = null;
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            // String sql = "SELECT * FROM `humusam_root`.`Users` WHERE UserEmail=" + email;
            String sql = "SELECT * FROM `brands` WHERE isBrandHasCertifications '%" + isBrandHasCertifications + "%'";
            Statement statment = connection.createStatement();
            ResultSet set = statment.executeQuery(sql);
            ListBrands(brandsList, set);
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in LoadAllBrands Section  : " + exception);
            exception.printStackTrace();
        }

        return brandsList;
    }

    /**
     * Adding logo
     * @param BrandId
     * @param fileName
     * @return
     */
    public int AddLogo(int BrandId, String fileName) {
        int rowsUpdated = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "UPDATE humusam_root.brands  SET Logo=? WHERE brandOwnerId=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(2, BrandId);
            statement.setString(1, fileName);

            rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Logo added successfully!");
            }
        } catch (SQLException exception) {
            System.out.println("sqlException in Application in Category UPDATE Section  : " + exception);
            exception.printStackTrace();
        }
        return rowsUpdated;
    }

    public int UpdateBrandById(Brands brands, int BrandWebId) {
        int rowsAffected = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String insertQuery = "UPDATE `humusam_root`.`brands` SET brandOwnerEmail=?,brandCategory=?,brandAddress1=?,brandAddress2=?," +
                    "brandCountry=?,brandCity=?,brandState=?,brandZipCode=?,brandPhoneNumber=?,brandKind=? WHERE brandWebId=" + BrandWebId;

            PreparedStatement statment = connection.prepareStatement(insertQuery);
            statment.setString(1, brands.getBrandOwnerEmail());
            statment.setString(2, brands.getBrandCategory());
            statment.setString(3, brands.getBrandAddress1());
            statment.setString(4, brands.getBrandAddress2());
            statment.setString(5, brands.getBrandCountry());
            statment.setString(6, brands.getBrandCity());
            statment.setString(7, brands.getBrandState());
            statment.setString(8, brands.getBrandZipCode());
            statment.setString(9, brands.getBrandPhoneNumber());
            statment.setString(10, brands.getBrandKind());

            rowsAffected = statment.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }



    /**
     * @param brandsList
     * @param set
     * @throws SQLException
     */
    private void ListBrands(List<Brands> brandsList, ResultSet set) throws SQLException {
        Brands brands;
        while (set.next()) {

                brands = new Brands();
                brands.setBrandId(set.getInt("brandId"));
                brands.setBrandWebId(set.getInt("brandWebId"));
                brands.setBrandOwnerId(set.getInt("brandOwnerId"));
                brands.setBrandOwnerEmail(set.getString("brandOwnerEmail"));
                brands.setBrandName(set.getString("brandName"));
                brands.setBrandCategory(set.getString("brandCategory"));
                brands.setBrandAddress1(set.getString("brandAddress1"));
                brands.setBrandAddress2(set.getString("brandAddress2"));
                brands.setBrandCountry(set.getString("brandCountry"));
                brands.setBrandCity(set.getString("brandCity"));
                brands.setBrandState(set.getString("brandState"));
                brands.setBrandZipCode(set.getString("brandZipCode"));
                brands.setBrandPhoneNumber(set.getString("brandPhoneNumber"));
                brands.setBrandKind(set.getString("brandKind"));
                brands.setBrandCreatedDate(set.getDate("brandCreatedDate"));
                brands.setIsBrandAddressVerified(set.getString("isBrandAddressVerified"));
                brands.setIsBrandPhoneNumberVerified(set.getString("isBrandPhoneNumberVerified"));
                brands.setIsBrandHasCertifications(set.getString("isBrandHasCertifications"));
                brands.setLogo((set.getString("logo")));

                brandsList.add(brands);

        }
    }
}
