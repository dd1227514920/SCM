package model.storeModel;

/**
 * Created by leo on 2017/7/10.
 */


//产品表

public class Product {
    private String productCode;
    private int categoryID;
    private String name;
    private String unitName;
    private float price;
    private String createDate;
    private String remark;
    private int poNum;
    private int soNum;


    public Product() {
    }

    public Product(String productCode, int categoryID, String name, String unitName, float price, String createDate, String remark, int poNum, int soNum) {
        this.productCode = productCode;
        this.categoryID = categoryID;
        this.name = name;
        this.unitName = unitName;
        this.price = price;
        this.createDate = createDate;
        this.remark = remark;
        this.poNum = poNum;
        this.soNum = soNum;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public int getPoNum() {
        return poNum;
    }

    public void setPoNum(int poNum) {
        this.poNum = poNum;
    }

    public int getSoNum() {
        return soNum;
    }

    public void setSoNum(int soNum) {
        this.soNum = soNum;
    }
}
