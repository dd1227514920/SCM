package model.sales;

public class Customer {
	private String customerCode;// 客户编号
	private String name;// 客户名称
	private String password;// 密码
	private String contactor;// 联系人
	private String address;// 地址
	private String postcode;// 邮政编码
	private String tel;// 电话
	private String fax;// 传真
	private String createDate;// 注册日期

	public Customer() {
		super();
	}

	public Customer(String customerCode, String name, String password, String contactor,
			String address, String postcode, String tel, String fax, String createDate) {
		super();
		this.customerCode = customerCode;
		this.name = name;
		this.password = password;
		this.contactor = contactor;
		this.address = address;
		this.postcode = postcode;
		this.tel = tel;
		this.fax = fax;
		this.createDate = createDate;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}