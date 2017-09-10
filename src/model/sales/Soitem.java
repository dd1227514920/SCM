package model.sales;

public class Soitem {
	private String soid;// 销售单编号
	private String productCode;// 产品编号
	private String name;// 产品名称
	private float unitPrice;// 产品单价
	private int num;// 产品数量
	private String unitName;// 数量单位
	private float itemPrice;// 明细总价

	public Soitem(String soid, String productCode, float unitPrice, int num, String unitName,
			float itemPrice) {
		super();
		this.soid = soid;
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.num = num;
		this.unitName = unitName;
		this.itemPrice = itemPrice;
	}

	public Soitem(String soid, String productCode, String name, float unitPrice, int num,
			String unitName, float itemPrice) {
		super();
		this.soid = soid;
		this.productCode = productCode;
		this.name = name;
		this.unitPrice = unitPrice;
		this.num = num;
		this.unitName = unitName;
		this.itemPrice = itemPrice;
	}

	public String getSoid() {
		return soid;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getName() {
		return name;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public int getNum() {
		return num;
	}

	public String getUnitName() {
		return unitName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

}
