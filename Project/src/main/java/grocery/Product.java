package grocery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	@Transient
	private Integer fk;

	private String productName;
	private Float price;
	private String status;
	private Integer quantity;
	private Integer maxQuantity;
	private Float totalPrice;

	@ManyToOne
	private Category category;


	public Product() {

	}

	public Product(Integer productId, Integer fk, String productName, Float price, String status, Category category) {

		this.productId = productId;
		this.fk = fk;
		this.productName = productName;
		this.price = price;
		this.status = status;
		this.category = category;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getFk() {
		return fk;
	}

	public void setFk(Integer fk) {
		this.fk = fk;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@JsonIgnore
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(Integer maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", fk=" + fk + ", productName=" + productName + ", price=" + price
				+ ", status=" + status + ", quantity=" + quantity + ", maxQuantity=" + maxQuantity + ", totalPrice="
				+ totalPrice + ", category=" + category + "]";
	}

}
