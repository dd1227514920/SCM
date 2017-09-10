package model.storeModel;

/**
 * Created by leo on 2017/7/13.
 */
public class StockQuery {
    private String productCode;
    private String name;
    private int num;
    private int poNum;
    private int soNum;

    public StockQuery(){}

    public StockQuery(String productCode, String name, int num, int poNum, int soNum) {
        this.productCode = productCode;
        this.name = name;
        this.num = num;
        this.poNum = poNum;
        this.soNum = soNum;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
