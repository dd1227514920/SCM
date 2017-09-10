package model.finance;

/**
 * Created by JerryCheng on 2017.7.11.
 */
public class Product {
    String productcode;
    int categoryID;
    String name;
    String unitName;
    float price;
    String createDate;
    String remark;
    int ponum;
    int sonum;
    int num;

    public Product(String productcode, int categoryID, String name, String unitName, float price, String createDate, String remark, int ponum, int sonum, int num) {
        this.productcode = productcode;
        this.categoryID = categoryID;
        this.name = name;
        this.unitName = unitName;
        this.price = price;
        this.createDate = createDate;
        this.remark = remark;
        this.ponum = ponum;
        this.sonum = sonum;
        this.num = num;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPonum() {
        return ponum;
    }

    public void setPonum(int ponum) {
        this.ponum = ponum;
    }

    public int getSonum() {
        return sonum;
    }

    public void setSonum(int sonum) {
        this.sonum = sonum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
