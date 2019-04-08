package BeautyIt.BP.Bean;

public class AddressBox {
    private int AddressBookId;
    private int BoxOwnerId;
    private String BoxOwnerName;
    private String BoxOwnerEmail;
    private int AddedId;
    private String AddedName;
    private String AddedLastName;

    public AddressBox(int addressBookId, int boxOwnerId, String boxOwnerName, String boxOwnerEmail, int addedId, String addedName, String addedLastName) {
        AddressBookId = addressBookId;
        BoxOwnerId = boxOwnerId;
        BoxOwnerName = boxOwnerName;
        BoxOwnerEmail = boxOwnerEmail;
        AddedId = addedId;
        AddedName = addedName;
        AddedLastName = addedLastName;
    }

    public AddressBox(int boxOwnerId, String boxOwnerName, String boxOwnerEmail, int addedId, String addedName, String addedLastName) {
        BoxOwnerId = boxOwnerId;
        BoxOwnerName = boxOwnerName;
        BoxOwnerEmail = boxOwnerEmail;
        AddedId = addedId;
        AddedName = addedName;
        AddedLastName = addedLastName;
    }

    public AddressBox() {
    }

    public int getAddressBookId() {
        return AddressBookId;
    }

    public void setAddressBookId(int addressBookId) {
        AddressBookId = addressBookId;
    }

    public int getBoxOwnerId() {
        return BoxOwnerId;
    }

    public void setBoxOwnerId(int boxOwnerId) {
        BoxOwnerId = boxOwnerId;
    }

    public String getBoxOwnerName() {
        return BoxOwnerName;
    }

    public void setBoxOwnerName(String boxOwnerName) {
        BoxOwnerName = boxOwnerName;
    }

    public String getBoxOwnerEmail() {
        return BoxOwnerEmail;
    }

    public void setBoxOwnerEmail(String boxOwnerEmail) {
        BoxOwnerEmail = boxOwnerEmail;
    }

    public int getAddedId() {
        return AddedId;
    }

    public void setAddedId(int addedId) {
        AddedId = addedId;
    }

    public String getAddedName() {
        return AddedName;
    }

    public void setAddedName(String addedName) {
        AddedName = addedName;
    }

    public String getAddedLastName() {
        return AddedLastName;
    }

    public void setAddedLastName(String addedLastName) {
        AddedLastName = addedLastName;
    }
}
