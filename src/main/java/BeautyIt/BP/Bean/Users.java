package BeautyIt.BP.Bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    private int UserID;
    private int UserWebId;
    private String UserEmail;
    private String UserPassword;
    private String UserFirstName;
    private String UserLastName;
    private String UserCity;
    private String UserState;
    private String UserZip;
    private String IsUserEmailVerified;
    private Date UserRegistrationDate;
    private String UserPhone;
    private String UserCountry;
    private String UserAddress;
    private String UserAddress2;
    private String IsUserAddressVerified;
    private String IsUserPhoneVerified;
    private String UserEmailVerificationCode;
    private String UserAddressVerificationCode;
    private String UserPhoneVerificationCode;
    private String IsUserSeller;
    private int SellerID;
    private List<Users> UsersVars;


    public Users(List<Users> usersVars) {
        super();
        this.UsersVars = new ArrayList<>();
    }

    public Users(String userEmail, String userFirstName, String userLastName, String userCity, String userState, String userZip, String userPhone, String userCountry, String userAddress, String userAddress2) {
        UserEmail = userEmail;
        UserFirstName = userFirstName;
        UserLastName = userLastName;
        UserCity = userCity;
        UserState = userState;
        UserZip = userZip;
        UserPhone = userPhone;
        UserCountry = userCountry;
        UserAddress = userAddress;
        UserAddress2 = userAddress2;
    }

    public Users(String userFirstName, String userLastName, String userCity, String userState, String userZip, String userPhone, String userCountry, String userAddress, String userAddress2) {
        UserFirstName = userFirstName;
        UserLastName = userLastName;
        UserCity = userCity;
        UserState = userState;
        UserZip = userZip;
        UserPhone = userPhone;
        UserCountry = userCountry;
        UserAddress = userAddress;
        UserAddress2 = userAddress2;
    }

    public Users(int userID, String userEmail, String userFirstName, String userLastName) {
        super();
        UserID = userID;
        UserEmail = userEmail;
        UserFirstName = userFirstName;
        UserLastName = userLastName;
    }


    /**
     * @param userID
     * @param userWebId
     * @param userEmail
     * @param userPassword
     * @param userFirstName
     * @param userLastName
     * @param userCity
     * @param userState
     * @param userZip
     * @param isUserEmailVerified
     * @param userRegistrationDate
     * @param userPhone
     * @param userCountry
     * @param userAddress
     * @param userAddress2
     * @param isUserAddressVerified
     * @param isUserPhoneVerified
     * @param userEmailVerificationCode
     * @param userAddressVerificationCode
     * @param userPhoneVerificationCode
     * @param isUserSeller
     * @param sellerID
     */
    public Users(int userID, int userWebId, String userEmail, String userPassword, String userFirstName,
                 String userLastName, String userCity, String userState, String userZip, String isUserEmailVerified,
                 Date userRegistrationDate, String userPhone, String userCountry, String userAddress, String userAddress2,
                 String isUserAddressVerified, String isUserPhoneVerified, String userEmailVerificationCode,
                 String userAddressVerificationCode, String userPhoneVerificationCode, String isUserSeller, int sellerID) {
        super();
        this.UserID = userID;
        this.UserWebId = userWebId;
        this.UserEmail = userEmail;
        this.UserPassword = userPassword;
        this.UserFirstName = userFirstName;
        this.UserLastName = userLastName;
        this.UserCity = userCity;
        this.UserState = userState;
        this.UserZip = userZip;
        this.IsUserEmailVerified = isUserEmailVerified;
        this.UserRegistrationDate = userRegistrationDate;
        this.UserPhone = userPhone;
        this.UserCountry = userCountry;
        this.UserAddress = userAddress;
        this.UserAddress2 = userAddress2;
        this.IsUserAddressVerified = isUserAddressVerified;
        this.IsUserPhoneVerified = isUserPhoneVerified;
        this.UserEmailVerificationCode = userEmailVerificationCode;
        this.UserAddressVerificationCode = userAddressVerificationCode;
        this.UserPhoneVerificationCode = userPhoneVerificationCode;
        this.IsUserSeller = isUserSeller;
        this.SellerID = sellerID;
    }

    /**
     * First Time Registering Construct with ID
     *
     * @param userID
     * @param userWebId
     * @param userEmail
     * @param userPassword
     * @param userFirstName
     * @param userLastName
     * @param userCity
     * @param userState
     * @param userZip
     * @param isUserEmailVerified
     * @param userRegistrationDate
     * @param userPhone
     * @param userCountry
     * @param userAddress
     * @param userAddress2
     * @param isUserAddressVerified
     * @param isUserPhoneVerified
     * @param userEmailVerificationCode
     * @param userAddressVerificationCode
     * @param userPhoneVerificationCode
     */
    public Users(int userID, int userWebId, String userEmail, String userPassword, String userFirstName,
                 String userLastName, String userCity, String userState, String userZip, String isUserEmailVerified,
                 Date userRegistrationDate, String userPhone, String userCountry, String userAddress, String userAddress2,
                 String isUserAddressVerified, String isUserPhoneVerified, String userEmailVerificationCode,
                 String userAddressVerificationCode, String userPhoneVerificationCode) {
        super();
        this.UserID = userID;
        this.UserWebId = userWebId;
        this.UserEmail = userEmail;
        this.UserPassword = userPassword;
        this.UserFirstName = userFirstName;
        this.UserLastName = userLastName;
        this.UserCity = userCity;
        this.UserState = userState;
        this.UserZip = userZip;
        this.IsUserEmailVerified = isUserEmailVerified;
        this.UserRegistrationDate = userRegistrationDate;
        this.UserPhone = userPhone;
        this.UserCountry = userCountry;
        this.UserAddress = userAddress;
        this.UserAddress2 = userAddress2;
        this.IsUserAddressVerified = isUserAddressVerified;
        this.IsUserPhoneVerified = isUserPhoneVerified;
        this.UserEmailVerificationCode = userEmailVerificationCode;
        this.UserAddressVerificationCode = userAddressVerificationCode;
        this.UserPhoneVerificationCode = userPhoneVerificationCode;
    }

    /**
     * First Time Registering Construct
     *
     * @param userWebId
     * @param userEmail
     * @param userPassword
     * @param isUserEmailVerified
     * @param isUserAddressVerified
     * @param isUserPhoneVerified
     * @param userEmailVerificationCode
     * @param userAddressVerificationCode
     * @param userPhoneVerificationCode
     */
    public Users(int userWebId, String userEmail, String userPassword, String isUserEmailVerified, String isUserAddressVerified,
                 String isUserPhoneVerified, String userEmailVerificationCode, String userAddressVerificationCode, String userPhoneVerificationCode) {
        super();
        this.UserWebId = userWebId;
        this.UserEmail = userEmail;
        this.UserPassword = userPassword;
        this.IsUserEmailVerified = isUserEmailVerified;
        this.IsUserAddressVerified = isUserAddressVerified;
        this.IsUserPhoneVerified = isUserPhoneVerified;
        this.UserEmailVerificationCode = userEmailVerificationCode;
        this.UserAddressVerificationCode = userAddressVerificationCode;
        this.UserPhoneVerificationCode = userPhoneVerificationCode;
    }

    /**
     * Full Construct
     *
     * @param userWebId
     * @param userEmail
     * @param userPassword
     * @param userFirstName
     * @param userLastName
     * @param userCity
     * @param userState
     * @param userZip
     * @param isUserEmailVerified
     * @param userRegistrationDate
     * @param userPhone
     * @param userCountry
     * @param userAddress
     * @param userAddress2
     * @param isUserAddressVerified
     * @param isUserPhoneVerified
     * @param userEmailVerificationCode
     * @param userAddressVerificationCode
     * @param userPhoneVerificationCode
     */
    public Users(int userWebId, String userEmail, String userPassword, String userFirstName,
                 String userLastName, String userCity, String userState, String userZip, String isUserEmailVerified,
                 Date userRegistrationDate, String userPhone, String userCountry, String userAddress, String userAddress2,
                 String isUserAddressVerified, String isUserPhoneVerified, String userEmailVerificationCode,
                 String userAddressVerificationCode, String userPhoneVerificationCode) {
        super();

        this.UserWebId = userWebId;
        this.UserEmail = userEmail;
        this.UserPassword = userPassword;
        this.UserFirstName = userFirstName;
        this.UserLastName = userLastName;
        this.UserCity = userCity;
        this.UserState = userState;
        this.UserZip = userZip;
        this.IsUserEmailVerified = isUserEmailVerified;
        this.UserRegistrationDate = userRegistrationDate;
        this.UserPhone = userPhone;
        this.UserCountry = userCountry;
        this.UserAddress = userAddress;
        this.UserAddress2 = userAddress2;
        this.IsUserAddressVerified = isUserAddressVerified;
        this.IsUserPhoneVerified = isUserPhoneVerified;
        this.UserEmailVerificationCode = userEmailVerificationCode;
        this.UserAddressVerificationCode = userAddressVerificationCode;
        this.UserPhoneVerificationCode = userPhoneVerificationCode;
    }

    public Users() {
        super();
    }


    @Override
    public String toString() {
        return "Users [UserID=" + UserID + ", UserWebId=" + UserWebId + ", UserEmail=" + UserEmail + ", UserPassword="
                + UserPassword + ", UserFirstName=" + UserFirstName + ", UserLastName=" + UserLastName + ", UserCity="
                + UserCity + ", UserState=" + UserState + ", UserZip=" + UserZip + ", IsUserEmailVerified="
                + IsUserEmailVerified + ", UserRegistrationDate=" + UserRegistrationDate + ", UserPhone=" + UserPhone
                + ", UserCountry=" + UserCountry + ", UserAddress=" + UserAddress + ", UserAddress2=" + UserAddress2
                + ", IsUserAddressVerified=" + IsUserAddressVerified + ", IsUserPhoneVerified=" + IsUserPhoneVerified
                + ", UserEmailVerificationCode=" + UserEmailVerificationCode + ", UserAddressVerificationCode="
                + UserAddressVerificationCode + ", UserPhoneVerificationCode=" + UserPhoneVerificationCode + "]";
    }


    public String getIsUserSeller() {
        return IsUserSeller;
    }

    public void setIsUserSeller(String isUserSeller) {
        IsUserSeller = isUserSeller;
    }

    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getUserWebId() {
        return UserWebId;
    }

    public void setUserWebId(int userWebId) {
        UserWebId = userWebId;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserFirstName() {
        return UserFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        UserFirstName = userFirstName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {
        UserLastName = userLastName;
    }

    public String getUserCity() {
        return UserCity;
    }

    public void setUserCity(String userCity) {
        UserCity = userCity;
    }

    public String getUserState() {
        return UserState;
    }

    public void setUserState(String userState) {
        UserState = userState;
    }

    public String getUserZip() {
        return UserZip;
    }

    public void setUserZip(String userZip) {
        UserZip = userZip;
    }

    public String getIsUserEmailVerified() {
        return IsUserEmailVerified;
    }

    public void setIsUserEmailVerified(String isUserEmailVerified) {
        IsUserEmailVerified = isUserEmailVerified;
    }

    public Date getUserRegistrationDate() {
        return UserRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        UserRegistrationDate = userRegistrationDate;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getUserCountry() {
        return UserCountry;
    }

    public void setUserCountry(String userCountry) {
        UserCountry = userCountry;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    public String getUserAddress2() {
        return UserAddress2;
    }

    public void setUserAddress2(String userAddress2) {
        UserAddress2 = userAddress2;
    }

    public String getIsUserAddressVerified() {
        return IsUserAddressVerified;
    }

    public void setIsUserAddressVerified(String isUserAddressVerified) {
        IsUserAddressVerified = isUserAddressVerified;
    }

    public String getIsUserPhoneVerified() {
        return IsUserPhoneVerified;
    }

    public void setIsUserPhoneVerified(String isUserPhoneVerified) {
        IsUserPhoneVerified = isUserPhoneVerified;
    }

    public String getUserEmailVerificationCode() {
        return UserEmailVerificationCode;
    }

    public void setUserEmailVerificationCode(String userEmailVerificationCode) {
        UserEmailVerificationCode = userEmailVerificationCode;
    }

    public String getUserAddressVerificationCode() {
        return UserAddressVerificationCode;
    }

    public void setUserAddressVerificationCode(String userAddressVerificationCode) {
        UserAddressVerificationCode = userAddressVerificationCode;
    }

    public String getUserPhoneVerificationCode() {
        return UserPhoneVerificationCode;
    }

    public void setUserPhoneVerificationCode(String userPhoneVerificationCode) {
        UserPhoneVerificationCode = userPhoneVerificationCode;
    }

}
