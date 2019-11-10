package grocery;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	@Transient
	private Integer ufk;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItems> orderItems;

	String deliveryAddress;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUfk() {
		return ufk;
	}

	public void setUfk(Integer ufk) {
		this.ufk = ufk;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", ufk=" + ufk + ", user=" + user + ", orderItems=" + orderItems.size()
				+ ", deliveryAddress=" + deliveryAddress + "]";
	}

}
