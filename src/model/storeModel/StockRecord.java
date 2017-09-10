package model.storeModel;

/**
 * Created by leo on 2017/7/7.
 */
public class StockRecord {
    private int stockID;
    private String productCode;
    private String orderCode;
    private int stockNum;
    private int stockType;
    private String stockTime;
    private String createUser;

    public StockRecord(){

    }

    public StockRecord(int stockID, String productCode, String orderCode, int stockNum, int stockType, String stockTime, String createUser) {
        this.stockID = stockID;
        this.productCode = productCode;
        this.orderCode = orderCode;
        this.stockNum = stockNum;
        this.stockType = stockType;
        this.stockTime = stockTime;
        this.createUser = createUser;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public int getStockType() {
        return stockType;
    }

    public void setStockType(int stockType) {
        this.stockType = stockType;
    }

    public String getStockTime() {
        return stockTime;
    }

    public void setStockTime(String stockTime) {
        this.stockTime = stockTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
