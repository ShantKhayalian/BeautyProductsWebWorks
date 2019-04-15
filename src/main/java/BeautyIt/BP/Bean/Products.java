package BeautyIt.BP.Bean;

import java.util.Date;

public class Products {
    private int productId;
    private long productTokeb;
    private int SellerID;
    private String SellerEmail;
    private int BrandId;
    private String BrandName;
    private int menuId;
    private String menuName;
    private int subMenuId;
    private String subMenuName;
    private int mainImageId;
    private String mainImageAddress;
    private int subImagePackID;
    private String productTitle;
    private String ShortDescription;
    private String Description;
    private double price;
    private int packageDetails;
    private String packageDimentions;
    private String PackageWeigh;
    private int quantity;
    private String isInSaled;
    private int SaleAmount;
    private String isFeatured;
    private Date ProductAddedDate;

    public Products(int productId, long productTokeb, int sellerID, String sellerEmail, int brandId, String brandName, int menuId, String menuName, int subMenuId, String subMenuName, int mainImageId, String mainImageAddress, int subImagePackID, String productTitle, String shortDescription, String description, double price, int packageDetails, String packageDimentions, String packageWeigh, int quantity, String isInSaled, int saleAmount, String isFeatured, Date productAddedDate) {
        this.productId = productId;
        this.productTokeb = productTokeb;
        SellerID = sellerID;
        SellerEmail = sellerEmail;
        BrandId = brandId;
        BrandName = brandName;
        this.menuId = menuId;
        this.menuName = menuName;
        this.subMenuId = subMenuId;
        this.subMenuName = subMenuName;
        this.mainImageId = mainImageId;
        this.mainImageAddress = mainImageAddress;
        this.subImagePackID = subImagePackID;
        this.productTitle = productTitle;
        ShortDescription = shortDescription;
        Description = description;
        this.price = price;
        this.packageDetails = packageDetails;
        this.packageDimentions = packageDimentions;
        PackageWeigh = packageWeigh;
        this.quantity = quantity;
        this.isInSaled = isInSaled;
        SaleAmount = saleAmount;
        this.isFeatured = isFeatured;
        ProductAddedDate = productAddedDate;
    }

    public Products() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public long getProductTokeb() {
        return productTokeb;
    }

    public void setProductTokeb(long productTokeb) {
        this.productTokeb = productTokeb;
    }

    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }

    public String getSellerEmail() {
        return SellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        SellerEmail = sellerEmail;
    }

    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int brandId) {
        BrandId = brandId;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getSubMenuId() {
        return subMenuId;
    }

    public void setSubMenuId(int subMenuId) {
        this.subMenuId = subMenuId;
    }

    public String getSubMenuName() {
        return subMenuName;
    }

    public void setSubMenuName(String subMenuName) {
        this.subMenuName = subMenuName;
    }

    public int getMainImageId() {
        return mainImageId;
    }

    public void setMainImageId(int mainImageId) {
        this.mainImageId = mainImageId;
    }

    public String getMainImageAddress() {
        return mainImageAddress;
    }

    public void setMainImageAddress(String mainImageAddress) {
        this.mainImageAddress = mainImageAddress;
    }

    public int getSubImagePackID() {
        return subImagePackID;
    }

    public void setSubImagePackID(int subImagePackID) {
        this.subImagePackID = subImagePackID;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        ShortDescription = shortDescription;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPackageDetails() {
        return packageDetails;
    }

    public void setPackageDetails(int packageDetails) {
        this.packageDetails = packageDetails;
    }

    public String getPackageDimentions() {
        return packageDimentions;
    }

    public void setPackageDimentions(String packageDimentions) {
        this.packageDimentions = packageDimentions;
    }

    public String getPackageWeigh() {
        return PackageWeigh;
    }

    public void setPackageWeigh(String packageWeigh) {
        PackageWeigh = packageWeigh;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIsInSaled() {
        return isInSaled;
    }

    public void setIsInSaled(String isInSaled) {
        this.isInSaled = isInSaled;
    }

    public int getSaleAmount() {
        return SaleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        SaleAmount = saleAmount;
    }

    public String getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(String isFeatured) {
        this.isFeatured = isFeatured;
    }

    public Date getProductAddedDate() {
        return ProductAddedDate;
    }

    public void setProductAddedDate(Date productAddedDate) {
        ProductAddedDate = productAddedDate;
    }

}