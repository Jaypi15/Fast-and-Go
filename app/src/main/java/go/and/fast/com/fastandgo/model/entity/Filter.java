package go.and.fast.com.fastandgo.model.entity;

/**
 * Created by Jay Paul on 17 Feb 2019.
 */

public class Filter {

    private int filterId;
    private int establishmentId;
    private String filterDescription;

    public int getFilterId() {
        return filterId;
    }

    public void setFilterId(int filterId) {
        this.filterId = filterId;
    }

    public int getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(int establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getFilterDescription() {
        return filterDescription;
    }

    public void setFilterDescription(String filterDescription) {
        this.filterDescription = filterDescription;
    }
}
