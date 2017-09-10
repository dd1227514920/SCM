package model.storeModel;

public class SOMain {
	private String soid;// 销售单编号
	private String createTime;// 创建时间
	private String customerCode;// 客户名称
	private String account;// 创建用户
	private float tipFee;// 附加费用
	private float productTotal;// 产品总价
	private String payType;// 付款方式
	private float prePayFee;// 最低预付款金额
	private String remark;// 备注
	private int status;// 处理状态

	public SOMain() {
		super();
	}

	public SOMain(String soid, String createTime, String customerCode, String payType, int status) {
		super();
		this.soid = soid;
		this.createTime = createTime;
		this.customerCode = customerCode;
		this.payType = payType;
		this.status = status;
	}

	public SOMain(String soid, String createTime, String customerCode, String account, float tipFee, float productTotal,
				  String payType, float prePayFee) {
		super();
		this.soid = soid;
		this.createTime = createTime;
		this.customerCode = customerCode;
		this.account = account;
		this.tipFee = tipFee;
		this.productTotal = productTotal;
		this.payType = payType;
		this.prePayFee = prePayFee;
	}

	public SOMain(String soid, String createTime, String customerCode, String account, float tipFee, float productTotal,
				  String payType, float prePayFee, String remark) {
		super();
		this.soid = soid;
		this.createTime = createTime;
		this.customerCode = customerCode;
		this.account = account;
		this.tipFee = tipFee;
		this.productTotal = productTotal;
		this.payType = payType;
		this.prePayFee = prePayFee;
		this.remark = remark;
	}

	public SOMain(String soid, String createTime, String customerCode, String account, float tipFee, float productTotal,
				  String payType, float prePayFee, int status) {
		super();
		this.soid = soid;
		this.createTime = createTime;
		this.customerCode = customerCode;
		this.account = account;
		this.tipFee = tipFee;
		this.productTotal = productTotal;
		this.payType = payType;
		this.prePayFee = prePayFee;
		this.status = status;
	}

	public String getSoid() {
		return soid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public String getAccount() {
		return account;
	}

	public float getTipFee() {
		return tipFee;
	}

	public float getProductTotal() {
		return productTotal;
	}

	public String getPayType() {
		return payType;
	}

	public float getPrePayFee() {
		return prePayFee;
	}

	public String getRemark() {
		return remark;
	}

	public int getStatus() {
		return status;
	}

	public void setSoid(String soid) {
		this.soid = soid;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setTipFee(float tipFee) {
		this.tipFee = tipFee;
	}

	public void setProductTotal(float productTotal) {
		this.productTotal = productTotal;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public void setPrePayFee(float prePayFee) {
		this.prePayFee = prePayFee;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
