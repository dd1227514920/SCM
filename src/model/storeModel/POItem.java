package model.storeModel;


/**
 * Created by leo on 2017/7/12.
 */
public class POItem {
    private String poID;
    private String productCode;
    private float unitPrice;
    private int num;
    private String unitName;
    private float itemPrice;
    private  String name;
    private String PayType;

    public POItem(){}

    public POItem(String poID, String productCode, float unitPrice, int num, String unitName, float itemPrice, String name, String payType) {
        this.poID = poID;
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.num = num;
        this.unitName = unitName;
        this.itemPrice = itemPrice;
        this.name = name;
        PayType = payType;
    }

    public String getPoID() {
        return poID;
    }

    public void setPoID(String poID) {
        this.poID = poID;
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

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
    }

    @Override
    public String toString() {
        return "POItem{" +
                "poID='" + poID + '\'' +
                ", productCode='" + productCode + '\'' +
                ", unitPrice=" + unitPrice +
                ", num=" + num +
                ", unitName='" + unitName + '\'' +
                ", itemPrice=" + itemPrice +
                ", name='" + name + '\'' +
                '}';
    }
}
