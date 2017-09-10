package model.sales;

public class Somain {
	private String soid;// 销售单编号
	private String createTime;// 创建时间
	private String customerCode;// 客户编号
	private String account;// 创建用户
	private float tipFee;// 附加费用
	private float productTotal;// 产品总价
	private float soTotal;// 总价格
	private String payType;// 付款方式
	private float prePayFee;// 最低预付款金额
	private String remark;// 备注
	private int status;// 处理状态
	private String stockTime;// 出库登记时间
	private String stockUser;// 出库登记用户
	private String pantime;// 付款登记时间
	private String payIser;// 付款登记用户
	private String prePayTime;// 预付登记时间
	private String prePayUser;// 预付登记用户
	private String endTime;// 了结时间
	private String endUser;// 了结用户

	public Somain() {
		super();
	}

	public Somain(String soid, String createTime, String customerCode, String payType, int status) {
		super();
		this.soid = soid;
		this.createTime = createTime;
		this.customerCode = customerCode;
		this.payType = payType;
		this.status = status;
	}

	public Somain(String soid, String createTime, String customerCode, String account, float tipFee,
			float productTotal, String payType, float prePayFee) {
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

	public Somain(String soid, String createTime, String customerCode, String account, float tipFee,
			float productTotal, String payType, float prePayFee, String remark) {
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

	public Somain(String soid, String createTime, String customerCode, String account, float tipFee,
			float productTotal, String payType, float prePayFee, String remark, int status) {
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
		this.status = status;
	}

	public Somain(String soid, String createTime, String customerCode, String account, float tipFee,
			float productTotal, String payType, float prePayFee, int status) {
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

	public void setSoid(String soid) {
		this.soid = soid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public float getTipFee() {
		return tipFee;
	}

	public void setTipFee(float tipFee) {
		this.tipFee = tipFee;
	}

	public float getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(float productTotal) {
		this.productTotal = productTotal;
	}

	public float getSoTotal() {
		return soTotal;
	}

	public void setSoTotal(float soTotal) {
		this.soTotal = soTotal;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public float getPrePayFee() {
		return prePayFee;
	}

	public void setPrePayFee(float prePayFee) {
		this.prePayFee = prePayFee;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStockTime() {
		return stockTime;
	}

	public void setStockTime(String stockTime) {
		this.stockTime = stockTime;
	}

	public String getStockUser() {
		return stockUser;
	}

	public void setStockUser(String stockUser) {
		this.stockUser = stockUser;
	}

	public String getPantime() {
		return pantime;
	}

	public void setPantime(String pantime) {
		this.pantime = pantime;
	}

	public String getPayIser() {
		return payIser;
	}

	public void setPayIser(String payIser) {
		this.payIser = payIser;
	}

	public String getPrePayTime() {
		return prePayTime;
	}

	public void setPrePayTime(String prePayTime) {
		this.prePayTime = prePayTime;
	}

	public String getPrePayUser() {
		return prePayUser;
	}

	public void setPrePayUser(String prePayUser) {
		this.prePayUser = prePayUser;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEndUser() {
		return endUser;
	}

	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}
}
