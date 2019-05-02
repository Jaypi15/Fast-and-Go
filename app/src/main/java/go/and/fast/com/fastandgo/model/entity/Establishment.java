package go.and.fast.com.fastandgo.model.entity;


/**
 * Created by Jay Paul on 17 Feb 2019.
 */

public class Establishment {

    public static final String FOOD_SERVICE_CODE = "1";
    public static final String SHOPPING_SERVICE_CODE = "2";
    public static final String TRANSPORTATION_SERVICE_CODE = "3";
    public static final String BILLS_PAYMENT_CODE = "4";
    public static final String PHARMACEUTICAL_SERVICE_CODE = "5";

    public static final String FOOD_SERVICE_TYPE = "Food Services";
    public static final String SHOPPING_SERVICE_TYPE = "Shopping Services";
    public static final String TRANSPORTATION_SERVICE_TYPE = "Transportation Services";
    public static final String BILLS_PAYMENT_TYPE = "Bills Payment Services";
    public static final String PHARMACEUTICAL_SERVICE_TYPE= "Pharmaceutical Services";

    private int establishmentId;
    private String establishmentName;
    private String establishmentCode;
    private double rating;
    private byte[] logo;
    private String type;

    public int getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(int establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public String getEstablishmentCode() {
        return establishmentCode;
    }

    public void setEstablishmentCode(String establishmentCode) {
        this.establishmentCode = establishmentCode;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
