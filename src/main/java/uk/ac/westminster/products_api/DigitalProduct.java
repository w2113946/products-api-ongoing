package uk.ac.westminster.products_api;

public class DigitalProduct extends Products implements Discountable {
    private double discountedPrice;

    @Override
    public void applyDiscount(double rate) {
        discountedPrice = getPrice() * (1-rate);
    }

    @Override
    public double getDiscountPrice() {
        return discountedPrice;
    }

    private String downloadUrl;
    private double fileSizeMB;

    public DigitalProduct(){}

    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }
    public String getDownloadUrl() {return downloadUrl;}
    public double getFileSizeMB() {return fileSizeMB;}

    public void setDownloadUrl(String downloadUrl) {this.downloadUrl = downloadUrl;}
    public void setFileSizeMB(double fileSizeMB) {this.fileSizeMB = fileSizeMB;}

    @Override
    public String getSummary() {return "Digital: " + getName() + " | Download: "+ getDownloadUrl();}
}

