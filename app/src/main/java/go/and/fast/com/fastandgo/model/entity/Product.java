package go.and.fast.com.fastandgo.model.entity;

/**
 * Created by Jay Paul on 17 Feb 2019.
 */

public class Product {

    private int productId;
    private int establishmentId;
    private String productName;
    private String description;
    private double price;
    private byte[] productImage;
    private String productCode;
    private Boolean isNeededPrescription;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(int establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Boolean getIsNeededPrescription() {
        return isNeededPrescription;
    }

    public void setIsNeededPrescription(Boolean neededPrescription) {
        isNeededPrescription = neededPrescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }
}
