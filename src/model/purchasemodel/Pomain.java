package model.purchasemodel;
public class Pomain {
	private String poId;
	private String venderCode;
	private String account;
	private String createTime;
	private float tipFee;
	private float productTotal;
	private float poTotal;
	private String payType;
	private float prePayFee;
	private int status;
	private String remark;
	private String stockTime;
	private String stockUser;
	private String payTime;
	private String payUser;
	private String prePayUser;
	private String prePayTime;
	private String endTime;
	private String endUser;
	public Pomain(){}


	public Pomain(String poId, String venderCode, String account,
			String createTime, float tipFee, float productTotal, float poTotal,
			String payType, float prePayFee, int status, String remark,
			String stockTime, String stockUser, String payTime, String payUser,
			String prePayUser, String prePayTime, String endTime, String endUser) {
		super();
		this.poId = poId;
		this.venderCode = venderCode;
		this.account = account;
		this.createTime = createTime;
		this.tipFee = tipFee;
		this.productTotal = productTotal;
		this.poTotal = poTotal;
		this.payType = payType;
		this.setPrePayFee(prePayFee);
		this.status = status;
		this.remark = remark;
		this.stockTime = stockTime;
		this.stockUser = stockUser;
		this.payTime = payTime;
		this.payUser = payUser;
		this.prePayUser = prePayUser;
		this.prePayTime = prePayTime;
		this.endTime = endTime;
		this.endUser = endUser;
	}



	public Pomain(String poId, String venderCode, String account,
			String createTime, float tipFee, float productTotal, float poTotal,
			String payType, float prePayFee, int status, String remark) {
		super();
		this.poId = poId;
		this.venderCode = venderCode;
		this.account = account;
		this.createTime = createTime;
		this.tipFee = tipFee;
		this.productTotal = productTotal;
		this.poTotal = poTotal;
		this.payType = payType;
		this.prePayFee = prePayFee;
		this.status = status;
		this.remark = remark;
	}


	public String getPoId() {
		return poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public String getVenderCode() {
		return venderCode;
	}
	public void setVenderCode(String venderCode) {
		this.venderCode = venderCode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
	public float getPoTotal() {
		return poTotal;
	}
	public void setPoTotal(float poTotal) {
		this.poTotal = poTotal;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getPayUser() {
		return payUser;
	}
	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}
	public String getPrePayUser() {
		return prePayUser;
	}
	public void setPrePayUser(String prePayUser) {
		this.prePayUser = prePayUser;
	}
	public String getPrePayTime() {
		return prePayTime;
	}
	public void setPrePayTime(String prePayTime) {
		this.prePayTime = prePayTime;
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


	public float getPrePayFee() {
		return prePayFee;
	}


	public void setPrePayFee(float prePayFee) {
		this.prePayFee = prePayFee;
	}
	
}
