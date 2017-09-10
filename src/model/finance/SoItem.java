package model.finance;

/**
 * Created by JerryCheng on 2017.7.13.
 */
public class SoItem {
    private String soID;
    private String productCode;
    private float unitPrice;
    private int num;
    private String unitName;
    private float itemPrice;
    private  String name;

    @Override
    public String toString() {
        return "SoItem{" +
                "soID='" + soID + '\'' +
                ", productCode='" + productCode + '\'' +
                ", unitPrice=" + unitPrice +
                ", num=" + num +
                ", unitName='" + unitName + '\'' +
                ", itemPrice=" + itemPrice +
                ", name='" + name + '\'' +
                '}';
    }

    public SoItem(String soID, String productCode, float unitPrice, int num, String unitName, float itemPrice, String name) {
        this.soID = soID;
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.num = num;
        this.unitName = unitName;
        this.itemPrice = itemPrice;
        this.name = name;
    }

    public String getSoID() {
        return soID;
    }

    public void setSoID(String soID) {
        this.soID = soID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
