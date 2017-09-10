package model.purchasemodel;

public class Product {
	private String productCode;
	private int categoryId;
	private String name;
	private String unitName;
	private float price;
	private String remark;
	private int poNum;
	private int soNum;
	
	public Product(){}
	public Product(String productCode, int categoryId, String name,
			String unitName, float price, String remark, int poNum, int soNum) {
		super();
		this.productCode = productCode;
		this.categoryId = categoryId;
		this.name = name;
		this.unitName = unitName;
		this.price = price;
		this.remark = remark;
		this.poNum = poNum;
		this.soNum = soNum;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getPoNum() {
		return poNum;
	}
	public void setPoNum(int poNum) {
		this.poNum = poNum;
	}
	public int getSoNum() {
		return soNum;
	}
	public void setSoNum(int soNum) {
		this.soNum = soNum;
	}
	
}
