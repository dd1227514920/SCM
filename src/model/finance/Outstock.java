package model.finance;



/**
 * Created by JerryCheng on 2017.7.18.
 */

public class Outstock {
    private int stockId;
    private String productCode;
    private String orderCode;
    private int stockNum;
    private int stockType;
    private String stockTime;
    private String createUser;

    public Outstock(int stockId, String productCode,String orderCode, int stockNum, int stockType, String stockTime, String createUser) {
        this.stockId = stockId;
        this.productCode=productCode;
        this.orderCode = orderCode;
        this.stockNum = stockNum;
        this.stockType = stockType;
        this.stockTime = stockTime;
        this.createUser = createUser;
    }


    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Outstock outstock = (Outstock) o;

        if (stockId != outstock.stockId) return false;
        if (stockNum != outstock.stockNum) return false;
        if (stockType != outstock.stockType) return false;
        if (orderCode != null ? !orderCode.equals(outstock.orderCode) : outstock.orderCode != null) return false;
        if (stockTime != null ? !stockTime.equals(outstock.stockTime) : outstock.stockTime != null) return false;
        if (createUser != null ? !createUser.equals(outstock.createUser) : outstock.createUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId;
        result = 31 * result + (orderCode != null ? orderCode.hashCode() : 0);
        result = 31 * result + stockNum;
        result = 31 * result + stockType;
        result = 31 * result + (stockTime != null ? stockTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        return result;
    }
}
