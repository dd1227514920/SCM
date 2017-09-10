package model.finance;

/**
 * Created by JerryCheng on 2017.7.12.
 */
public class Vender {
    String vendercode;
    String name;
    String password;
    String contactor;
    String address;
    String postcode;
    String tel;
    String fax;
    String createdate;

    public Vender(String vendercode, String name, String password, String contactor, String address, String postcode, String tel, String fax, String createdate) {
        this.vendercode = vendercode;
        this.name = name;
        this.password = password;
        this.contactor = contactor;
        this.address = address;
        this.postcode = postcode;
        this.tel = tel;
        this.fax = fax;
        this.createdate = createdate;
    }

    public String getVendercode() {
        return vendercode;
    }

    public void setVendercode(String vendercode) {
        this.vendercode = vendercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
}
