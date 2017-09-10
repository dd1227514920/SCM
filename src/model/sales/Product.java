package model.sales;

public class Product {

	private String productCode;
	private String name;
	private String unitName;
	private float price;

	public Product(String productCode, String name, String unitName, float price) {
		super();
		this.productCode = productCode;
		this.name = name;
		this.unitName = unitName;
		this.price = price;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getName() {
		return name;
	}

	public String getUnitName() {
		return unitName;
	}

	public float getPrice() {
		return price;
	}

}