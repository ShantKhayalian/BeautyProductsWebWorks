package BeautyIt.BP.Bean;

public class SellerRating {
    private int SellerRatingID;
    private int SellerID;
    private double sellerRatingNumbers;

    public SellerRating(int sellerRatingID, int sellerID, double sellerRatingNumbers) {
        SellerRatingID = sellerRatingID;
        SellerID = sellerID;
        this.sellerRatingNumbers = sellerRatingNumbers;
    }

    public SellerRating(int sellerID, double sellerRatingNumbers) {
        SellerID = sellerID;
        this.sellerRatingNumbers = sellerRatingNumbers;
    }

    public SellerRating() {
    }

    public int getSellerRatingID() {
        return SellerRatingID;
    }

    public void setSellerRatingID(int sellerRatingID) {
        SellerRatingID = sellerRatingID;
    }

    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }

    public double getSellerRatingNumbers() {
        return sellerRatingNumbers;
    }

    public void setSellerRatingNumbers(double sellerRatingNumbers) {
        this.sellerRatingNumbers = sellerRatingNumbers;
    }
}
