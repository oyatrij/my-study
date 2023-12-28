package extendEntity;

import javax.persistence.Entity;

//@Entity
public class Seller {
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
