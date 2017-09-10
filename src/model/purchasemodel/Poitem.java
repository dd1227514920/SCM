package model.purchasemodel;
public class Poitem {
	private String poId;
	private String productCode;
	private float unitPrice;
	private int num;
	private String unitName;
	private float itemPrice;
	public Poitem(){}
	public Poitem(String poId, String productCode, float unitPrice, int num,
			String unitName, float itemPrice) {
		super();
		this.poId = poId;
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.num = num;
		this.unitName = unitName;
		this.itemPrice = itemPrice;
	}
	public String getPoId() {
		return poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	
}
