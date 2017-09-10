package model.finance;

/**
 * Created by JerryCheng on 2017.7.11.
 */
public class Stock {
    String productcode;
    String name;
    String unitname;
    int num;

    public Stock(String productcode, String name, String unitname, int num) {
        this.productcode = productcode;
        this.name = name;
        this.unitname = unitname;
        this.num = num;
    }

    public Stock() {
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "productcode='" + productcode + '\'' +
                ", name='" + name + '\'' +
                ", unitname='" + unitname + '\'' +
                ", num=" + num +
                '}';
    }
}
