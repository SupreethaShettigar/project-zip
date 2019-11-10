package grocery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "order_items")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderItemId;

	@Transient
	private Integer ofk;

	private String productName;
	private Float price;
	private String status;
	private Integer quantity;
	private Integer maxQuantity;
	private Float totalPrice;

	@ManyToOne
	private Order order;

	public OrderItems() {

	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getOfk() {
		return ofk;
	}

	public void setOfk(Integer ofk) {
		this.ofk = ofk;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@JsonIgnore
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", ofk=" + ofk + ", productName=" + productName + ", price="
				+ price + ", status=" + status + ", quantity=" + quantity + ", maxQuantity=" + maxQuantity
				+ ", totalPrice=" + totalPrice + "]";
	}

}