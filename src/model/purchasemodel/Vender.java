package model.purchasemodel;

public class Vender {
	private String venderCode;
	private String name;
	private String password;
	private String contactor;
	private String address;
	private String postCode;
	private String tel;
	private String fax;
	private String createDate;
	
	public Vender(){}
	
	public Vender(String venderCode, String name, String password,
			String contactor, String address, String postCode, String tel,
			String fax, String createDate) {
		super();
		this.venderCode = venderCode;
		this.name = name;
		this.password = password;
		this.contactor = contactor;
		this.address = address;
		this.postCode = postCode;
		this.tel = tel;
		this.fax = fax;
		this.createDate = createDate;
	}
	public String getVenderCode() {
		return venderCode;
	}
	public void setVenderCode(String venderCode) {
		this.venderCode = venderCode;
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
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
