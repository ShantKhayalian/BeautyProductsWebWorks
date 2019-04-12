package BeautyIt.BP.Bean;

public class Menu {

    private int MenuID;
    private int MenuWebID;
    private String MenuDefualtName;
    private String MenuArmenianName;
    private String MenuArabicName;
    private String MenuRussianName;
    private String MenuFrenchName;

    public Menu(int menuID, int menuWebID, String menuDefualtName, String menuArmenianName, String menuArabicName, String menuRussianName, String menuFrenchName) {
        this.MenuID = menuID;
        this.MenuWebID = menuWebID;
        this.MenuDefualtName = menuDefualtName;
        this.MenuArmenianName = menuArmenianName;
        this.MenuArabicName = menuArabicName;
        this.MenuRussianName = menuRussianName;
        this.MenuFrenchName = menuFrenchName;
    }

    public Menu(int menuWebID, String menuDefualtName, String menuArmenianName, String menuArabicName, String menuRussianName, String menuFrenchName) {
        this.MenuWebID = menuWebID;
        this.MenuDefualtName = menuDefualtName;
        this.MenuArmenianName = menuArmenianName;
        this.MenuArabicName = menuArabicName;
        this.MenuRussianName = menuRussianName;
        this.MenuFrenchName = menuFrenchName;
    }

    public Menu(String menuDefualtName, String menuArmenianName, String menuArabicName, String menuRussianName, String menuFrenchName) {
        this.MenuDefualtName = menuDefualtName;
        this.MenuArmenianName = menuArmenianName;
        this.MenuArabicName = menuArabicName;
        this.MenuRussianName = menuRussianName;
        this.MenuFrenchName = menuFrenchName;
    }

    public Menu() {
    }

    public int getMenuID() {
        return MenuID;
    }

    public void setMenuID(int menuID) {
        MenuID = menuID;
    }

    public int getMenuWebID() {
        return MenuWebID;
    }

    public void setMenuWebID(int menuWebID) {
        MenuWebID = menuWebID;
    }

    public String getMenuDefualtName() {
        return MenuDefualtName;
    }

    public void setMenuDefualtName(String menuDefualtName) {
        MenuDefualtName = menuDefualtName;
    }

    public String getMenuArmenianName() {
        return MenuArmenianName;
    }

    public void setMenuArmenianName(String menuArmenianName) {
        MenuArmenianName = menuArmenianName;
    }

    public String getMenuArabicName() {
        return MenuArabicName;
    }

    public void setMenuArabicName(String menuArabicName) {
        MenuArabicName = menuArabicName;
    }

    public String getMenuRussianName() {
        return MenuRussianName;
    }

    public void setMenuRussianName(String menuRussianName) {
        MenuRussianName = menuRussianName;
    }

    public String getMenuFrenchName() {
        return MenuFrenchName;
    }

    public void setMenuFrenchName(String menuFrenchName) {
        MenuFrenchName = menuFrenchName;
    }
}
