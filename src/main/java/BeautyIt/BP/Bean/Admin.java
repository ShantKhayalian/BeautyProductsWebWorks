package BeautyIt.BP.Bean;

public class Admin {
    private int adminId;
    private String admin_Name;
    private String admin_Surname;
    private String admin_Email;
    private String admin_Username;
    private String admin_Password;
    private String admin_Phone_Number;

    public Admin(String admin_Name, String admin_Surname, String admin_Email, String admin_Username,
                 String admin_Password, String admin_Phone_Number) {
        super();
        this.admin_Name = admin_Name;
        this.admin_Surname = admin_Surname;
        this.admin_Email = admin_Email;
        this.admin_Username = admin_Username;
        this.admin_Password = admin_Password;
        this.admin_Phone_Number = admin_Phone_Number;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Admin() {
        super();
    }


    public String getAdmin_Phone_Number() {
        return admin_Phone_Number;
    }


    public void setAdmin_Phone_Number(String admin_Phone_Number) {
        this.admin_Phone_Number = admin_Phone_Number;
    }


    public String getAdmin_Name() {
        return admin_Name;
    }

    public void setAdmin_Name(String admin_Name) {
        this.admin_Name = admin_Name;
    }

    public String getAdmin_Surname() {
        return admin_Surname;
    }

    public void setAdmin_Surname(String admin_Surname) {
        this.admin_Surname = admin_Surname;
    }

    public String getAdmin_Email() {
        return admin_Email;
    }

    public void setAdmin_Email(String admin_Email) {
        this.admin_Email = admin_Email;
    }

    public String getAdmin_Username() {
        return admin_Username;
    }

    public void setAdmin_Username(String admin_Username) {
        this.admin_Username = admin_Username;
    }

    public String getAdmin_Password() {
        return admin_Password;
    }

    public void setAdmin_Password(String admin_Password) {
        this.admin_Password = admin_Password;
    }


}
