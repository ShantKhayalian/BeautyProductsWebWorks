package BeautyIt.BP.Bean;

public class SubMenu {
    private int subMenuId;
    private int MenuId;
    private String menuname;
    private int SubMenuWebId;
    private String SubMenuDefualtName;
    private String SubMenuArmenianName;
    private String SubMenuArabicName;
    private String SubMenuRussianName;
    private String SubMenuFrenchName;

    public SubMenu(int subMenuId, int menuId, String menuname, int subMenuWebId, String subMenuDefualtName, String subMenuArmenianName, String subMenuArabicName, String subMenuRussianName, String subMenuFrenchName) {
        this.subMenuId = subMenuId;
        MenuId = menuId;
        this.menuname = menuname;
        SubMenuWebId = subMenuWebId;
        SubMenuDefualtName = subMenuDefualtName;
        SubMenuArmenianName = subMenuArmenianName;
        SubMenuArabicName = subMenuArabicName;
        SubMenuRussianName = subMenuRussianName;
        SubMenuFrenchName = subMenuFrenchName;
    }

    public SubMenu(int menuId, String menuname, int subMenuWebId, String subMenuDefualtName, String subMenuArmenianName, String subMenuArabicName, String subMenuRussianName, String subMenuFrenchName) {
        MenuId = menuId;
        this.menuname = menuname;
        SubMenuWebId = subMenuWebId;
        SubMenuDefualtName = subMenuDefualtName;
        SubMenuArmenianName = subMenuArmenianName;
        SubMenuArabicName = subMenuArabicName;
        SubMenuRussianName = subMenuRussianName;
        SubMenuFrenchName = subMenuFrenchName;
    }

    public SubMenu() {
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public int getSubMenuId() {
        return subMenuId;
    }

    public void setSubMenuId(int subMenuId) {
        this.subMenuId = subMenuId;
    }

    public int getMenuId() {
        return MenuId;
    }

    public void setMenuId(int menuId) {
        MenuId = menuId;
    }

    public int getSubMenuWebId() {
        return SubMenuWebId;
    }

    public void setSubMenuWebId(int subMenuWebId) {
        SubMenuWebId = subMenuWebId;
    }

    public String getSubMenuDefualtName() {
        return SubMenuDefualtName;
    }

    public void setSubMenuDefualtName(String subMenuDefualtName) {
        SubMenuDefualtName = subMenuDefualtName;
    }

    public String getSubMenuArmenianName() {
        return SubMenuArmenianName;
    }

    public void setSubMenuArmenianName(String subMenuArmenianName) {
        SubMenuArmenianName = subMenuArmenianName;
    }

    public String getSubMenuArabicName() {
        return SubMenuArabicName;
    }

    public void setSubMenuArabicName(String subMenuArabicName) {
        SubMenuArabicName = subMenuArabicName;
    }

    public String getSubMenuRussianName() {
        return SubMenuRussianName;
    }

    public void setSubMenuRussianName(String subMenuRussianName) {
        SubMenuRussianName = subMenuRussianName;
    }

    public String getSubMenuFrenchName() {
        return SubMenuFrenchName;
    }

    public void setSubMenuFrenchName(String subMenuFrenchName) {
        SubMenuFrenchName = subMenuFrenchName;
    }
}
