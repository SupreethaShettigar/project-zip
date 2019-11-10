package grocery;

public class ProductStatus {
	 public Product product; 
	 boolean queryStatus;

	 public ProductStatus() {

	}

	public ProductStatus(Product product, boolean queryStatus) {

		this.product =product;
		this.queryStatus = queryStatus;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(boolean queryStatus) {
		this.queryStatus = queryStatus;
	}

	public void queryStatus(boolean b) {
		// TODO Auto-generated method stub
		
	}
	 
	 
}
