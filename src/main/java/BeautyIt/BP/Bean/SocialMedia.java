package BeautyIt.BP.Bean;

public class SocialMedia {
    private int socialId;
    private int sellerId;
    private int brandId;
    private String facebook;
    private String Google;
    private String Instagram;
    private String Twitter;
    private String Pinterest;
    private String LinkedIn;
    private String YouTube;

    public SocialMedia(int socialId, int sellerId, int brandId, String facebook, String google, String instagram, String twitter, String pinterest, String linkedIn, String youTube) {
        this.socialId = socialId;
        this.sellerId = sellerId;
        this.brandId = brandId;
        this.facebook = facebook;
        Google = google;
        Instagram = instagram;
        Twitter = twitter;
        Pinterest = pinterest;
        LinkedIn = linkedIn;
        YouTube = youTube;
    }

    public SocialMedia(int sellerId, int brandId, String facebook, String google, String instagram, String twitter, String pinterest, String linkedIn, String youTube) {
        this.sellerId = sellerId;
        this.brandId = brandId;
        this.facebook = facebook;
        this.Google = google;
        this.Instagram = instagram;
        this.Twitter = twitter;
        this.Pinterest = pinterest;
        this.LinkedIn = linkedIn;
        this.YouTube = youTube;
    }

    public SocialMedia(int socialId, int sellerId, int brandId) {
        this.socialId = socialId;
        this.sellerId = sellerId;
        this.brandId = brandId;
    }

    public SocialMedia(int socialId, String facebook, String google, String instagram, String twitter, String pinterest, String linkedIn, String youTube) {
        this.socialId = socialId;
        this.facebook = facebook;
        Google = google;
        Instagram = instagram;
        Twitter = twitter;
        Pinterest = pinterest;
        LinkedIn = linkedIn;
        YouTube = youTube;
    }

    public SocialMedia() {
    }

    public int getSocialId() {
        return socialId;
    }

    public void setSocialId(int socialId) {
        this.socialId = socialId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGoogle() {
        return Google;
    }

    public void setGoogle(String google) {
        Google = google;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String instagram) {
        Instagram = instagram;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public String getPinterest() {
        return Pinterest;
    }

    public void setPinterest(String pinterest) {
        Pinterest = pinterest;
    }

    public String getLinkedIn() {
        return LinkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        LinkedIn = linkedIn;
    }

    public String getYouTube() {
        return YouTube;
    }

    public void setYouTube(String youTube) {
        YouTube = youTube;
    }
}
