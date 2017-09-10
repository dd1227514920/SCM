package model.storeModel;

/**
 * Created by leo on 2017/7/14.
 */
public class Stock {

    private String productCode;
    private String name;
    private String unitName;
    private int num;

    public Stock(){

    }
    public Stock(String productCode, String name, String unitName, int num) {
        this.productCode = productCode;
        this.name = name;
        this.unitName = unitName;
        this.num = num;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
