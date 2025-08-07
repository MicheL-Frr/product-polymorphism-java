package entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	@Override
	public String priceTag() {
		return super.priceTag() + "(Customs fee: $ " + getCustomsFee() + ")";
	}

	public Double totalPrice() {
		return getPrice() + getCustomsFee();
	}

}