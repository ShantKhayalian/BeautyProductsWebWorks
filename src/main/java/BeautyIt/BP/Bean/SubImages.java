package BeautyIt.BP.Bean;

public class SubImages {
    private int subImagesId;
    private int subImagesPackID;
    private String subImagesAddress;

    public SubImages(int subImagesId, int subImagesPackID, String subImagesAddress) {
        this.subImagesId = subImagesId;
        this.subImagesPackID = subImagesPackID;
        this.subImagesAddress = subImagesAddress;
    }

    public SubImages() {
    }

    public int getSubImagesId() {
        return subImagesId;
    }

    public void setSubImagesId(int subImagesId) {
        this.subImagesId = subImagesId;
    }

    public int getSubImagesPackID() {
        return subImagesPackID;
    }

    public void setSubImagesPackID(int subImagesPackID) {
        this.subImagesPackID = subImagesPackID;
    }

    public String getSubImagesAddress() {
        return subImagesAddress;
    }

    public void setSubImagesAddress(String subImagesAddress) {
        this.subImagesAddress = subImagesAddress;
    }
}
