package BeautyIt.BP.Bean;

import java.util.Date;

public class Brands {
    private int brandId;
    private int brandWebId;
    private int brandOwnerId;
    private String brandOwnerEmail;
    private String brandName;
    private String brandCategory;
    private String brandAddress1;
    private String brandAddress2;
    private String brandCountry;
    private String brandCity;
    private String brandState;
    private String brandZipCode;
    private String brandPhoneNumber;
    private String brandKind;
    private Date brandCreatedDate;
    private String isBrandAddressVerified;
    private String isBrandPhoneNumberVerified;
    private String isBrandHasCertifications;
    private String Logo;

    public Brands(int brandId, int brandWebId, int brandOwnerId, String brandOwnerEmail, String brandName, String brandCategory, String brandAddress1, String brandAddress2, String brandCountry, String brandCity, String brandState, String brandZipCode, String brandPhoneNumber, String brandKind, Date brandCreatedDate, String isBrandAddressVerified, String isBrandPhoneNumberVerified, String isBrandHasCertifications) {
        this.brandId = brandId;
        this.brandWebId = brandWebId;
        this.brandOwnerId = brandOwnerId;
        this.brandOwnerEmail = brandOwnerEmail;
        this.brandName = brandName;
        this.brandCategory = brandCategory;
        this.brandAddress1 = brandAddress1;
        this.brandAddress2 = brandAddress2;
        this.brandCountry = brandCountry;
        this.brandCity = brandCity;
        this.brandState = brandState;
        this.brandZipCode = brandZipCode;
        this.brandPhoneNumber = brandPhoneNumber;
        this.brandKind = brandKind;
        this.brandCreatedDate = brandCreatedDate;
        this.isBrandAddressVerified = isBrandAddressVerified;
        this.isBrandPhoneNumberVerified = isBrandPhoneNumberVerified;
        this.isBrandHasCertifications = isBrandHasCertifications;
    }

    public Brands(int brandId, int brandWebId, int brandOwnerId, String brandOwnerEmail, String brandName, String brandCategory, String brandAddress1, String brandAddress2, String brandCountry, String brandCity, String brandState, String brandZipCode, String brandPhoneNumber, String brandKind, Date brandCreatedDate, String isBrandAddressVerified, String isBrandPhoneNumberVerified, String isBrandHasCertifications, String logo) {
        this.brandId = brandId;
        this.brandWebId = brandWebId;
        this.brandOwnerId = brandOwnerId;
        this.brandOwnerEmail = brandOwnerEmail;
        this.brandName = brandName;
        this.brandCategory = brandCategory;
        this.brandAddress1 = brandAddress1;
        this.brandAddress2 = brandAddress2;
        this.brandCountry = brandCountry;
        this.brandCity = brandCity;
        this.brandState = brandState;
        this.brandZipCode = brandZipCode;
        this.brandPhoneNumber = brandPhoneNumber;
        this.brandKind = brandKind;
        this.brandCreatedDate = brandCreatedDate;
        this.isBrandAddressVerified = isBrandAddressVerified;
        this.isBrandPhoneNumberVerified = isBrandPhoneNumberVerified;
        this.isBrandHasCertifications = isBrandHasCertifications;
        this.Logo = logo;
    }

    public Brands(int brandWebId, int brandOwnerId, String brandOwnerEmail, String brandName, String brandCategory, String brandAddress1, String brandAddress2, String brandCountry, String brandCity, String brandState, String brandZipCode, String brandPhoneNumber, String brandKind) {
        this.brandWebId = brandWebId;
        this.brandOwnerId = brandOwnerId;
        this.brandOwnerEmail = brandOwnerEmail;
        this.brandName = brandName;
        this.brandCategory = brandCategory;
        this.brandAddress1 = brandAddress1;
        this.brandAddress2 = brandAddress2;
        this.brandCountry = brandCountry;
        this.brandCity = brandCity;
        this.brandState = brandState;
        this.brandZipCode = brandZipCode;
        this.brandPhoneNumber = brandPhoneNumber;
        this.brandKind = brandKind;
    }

    public Brands(int brandWebId, int brandOwnerId, String brandOwnerEmail, String brandName, String brandCategory, String brandAddress1, String brandAddress2, String brandCountry, String brandCity, String brandState, String brandZipCode, String brandPhoneNumber, String brandKind, String isBrandAddressVerified, String isBrandPhoneNumberVerified, String isBrandHasCertifications) {
        this.brandWebId = brandWebId;
        this.brandOwnerId = brandOwnerId;
        this.brandOwnerEmail = brandOwnerEmail;
        this.brandName = brandName;
        this.brandCategory = brandCategory;
        this.brandAddress1 = brandAddress1;
        this.brandAddress2 = brandAddress2;
        this.brandCountry = brandCountry;
        this.brandCity = brandCity;
        this.brandState = brandState;
        this.brandZipCode = brandZipCode;
        this.brandPhoneNumber = brandPhoneNumber;
        this.brandKind = brandKind;
        this.isBrandAddressVerified = isBrandAddressVerified;
        this.isBrandPhoneNumberVerified = isBrandPhoneNumberVerified;
        this.isBrandHasCertifications = isBrandHasCertifications;
    }

    public Brands(String brandOwnerEmail, String brandName, String brandCategory, String brandAddress1, String brandAddress2, String brandCountry, String brandCity, String brandState, String brandZipCode, String brandPhoneNumber, String brandKind) {
        this.brandOwnerEmail = brandOwnerEmail;
        this.brandName = brandName;
        this.brandCategory = brandCategory;
        this.brandAddress1 = brandAddress1;
        this.brandAddress2 = brandAddress2;
        this.brandCountry = brandCountry;
        this.brandCity = brandCity;
        this.brandState = brandState;
        this.brandZipCode = brandZipCode;
        this.brandPhoneNumber = brandPhoneNumber;
        this.brandKind = brandKind;
    }

    public Brands(String brandOwnerEmail, String brandCategory, String brandAddress1, String brandAddress2, String brandCountry, String brandCity, String brandState, String brandZipCode, String brandPhoneNumber, String brandKind) {
        this.brandOwnerEmail = brandOwnerEmail;
        this.brandCategory = brandCategory;
        this.brandAddress1 = brandAddress1;
        this.brandAddress2 = brandAddress2;
        this.brandCountry = brandCountry;
        this.brandCity = brandCity;
        this.brandState = brandState;
        this.brandZipCode = brandZipCode;
        this.brandPhoneNumber = brandPhoneNumber;
        this.brandKind = brandKind;
    }

    public Brands() {
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getBrandWebId() {
        return brandWebId;
    }

    public void setBrandWebId(int brandWebId) {
        this.brandWebId = brandWebId;
    }

    public int getBrandOwnerId() {
        return brandOwnerId;
    }

    public void setBrandOwnerId(int brandOwnerId) {
        this.brandOwnerId = brandOwnerId;
    }

    public String getBrandOwnerEmail() {
        return brandOwnerEmail;
    }

    public void setBrandOwnerEmail(String brandOwnerEmail) {
        this.brandOwnerEmail = brandOwnerEmail;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandCategory() {
        return brandCategory;
    }

    public void setBrandCategory(String brandCategory) {
        this.brandCategory = brandCategory;
    }

    public String getBrandAddress1() {
        return brandAddress1;
    }

    public void setBrandAddress1(String brandAddress1) {
        this.brandAddress1 = brandAddress1;
    }

    public String getBrandAddress2() {
        return brandAddress2;
    }

    public void setBrandAddress2(String brandAddress2) {
        this.brandAddress2 = brandAddress2;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }

    public String getBrandCity() {
        return brandCity;
    }

    public void setBrandCity(String brandCity) {
        this.brandCity = brandCity;
    }

    public String getBrandState() {
        return brandState;
    }

    public void setBrandState(String brandState) {
        this.brandState = brandState;
    }

    public String getBrandZipCode() {
        return brandZipCode;
    }

    public void setBrandZipCode(String brandZipCode) {
        this.brandZipCode = brandZipCode;
    }

    public String getBrandPhoneNumber() {
        return brandPhoneNumber;
    }

    public void setBrandPhoneNumber(String brandPhoneNumber) {
        this.brandPhoneNumber = brandPhoneNumber;
    }

    public String getBrandKind() {
        return brandKind;
    }

    public void setBrandKind(String brandKind) {
        this.brandKind = brandKind;
    }

    public Date getBrandCreatedDate() {
        return brandCreatedDate;
    }

    public void setBrandCreatedDate(Date brandCreatedDate) {
        this.brandCreatedDate = brandCreatedDate;
    }

    public String getIsBrandAddressVerified() {
        return isBrandAddressVerified;
    }

    public void setIsBrandAddressVerified(String isBrandAddressVerified) {
        this.isBrandAddressVerified = isBrandAddressVerified;
    }

    public String getIsBrandPhoneNumberVerified() {
        return isBrandPhoneNumberVerified;
    }

    public void setIsBrandPhoneNumberVerified(String isBrandPhoneNumberVerified) {
        this.isBrandPhoneNumberVerified = isBrandPhoneNumberVerified;
    }

    public String getIsBrandHasCertifications() {
        return isBrandHasCertifications;
    }

    public void setIsBrandHasCertifications(String isBrandHasCertifications) {
        this.isBrandHasCertifications = isBrandHasCertifications;
    }
}