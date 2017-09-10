package model.finance;

/**
 * Created by JerryCheng on 2017.7.11.
 */
public class CheckStock {
    String productcode;
    int originnum;
    int realnum;
    String stocktime;
    String createUser;
    String description;
    String type;

    public CheckStock() {
    }

    @Override
    public String toString() {
        return "CheckStock{" +
                "productcode='" + productcode + '\'' +
                ", originnum=" + originnum +
                ", realnum=" + realnum +
                ", stocktime='" + stocktime + '\'' +
                ", createUser='" + createUser + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public CheckStock(String productcode, int originnum, int realnum, String stocktime, String createUser, String description, String type) {
        this.productcode = productcode;
        this.originnum = originnum;
        this.realnum = realnum;
        this.stocktime = stocktime;
        this.createUser = createUser;
        this.description = description;
        this.type = type;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public int getOriginnum() {
        return originnum;
    }

    public void setOriginnum(int originnum) {
        this.originnum = originnum;
    }

    public int getRealnum() {
        return realnum;
    }

    public void setRealnum(int realnum) {
        this.realnum = realnum;
    }

    public String getStocktime() {
        return stocktime;
    }

    public void setStocktime(String stocktime) {
        this.stocktime = stocktime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
