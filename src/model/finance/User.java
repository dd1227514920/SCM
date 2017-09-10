package model.finance;

/**
 * Created by JerryCheng on 2017.7.10.
 */
public class User {
    String account;
    String password;
    String name;
    String createDate;
    String status;
    String limits;

    public User(String account, String password, String name, String createDate, String status,String limits) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.createDate = createDate;
        this.status = status;
        this.limits = limits;
    }

    public String getLimits() {
        return limits;
    }

    public void setLimits(String limits) {
        this.limits = limits;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
