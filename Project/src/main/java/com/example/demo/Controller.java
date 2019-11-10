package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import grocery.Category;
import grocery.CategoryRepository;
import grocery.Order;
import grocery.OrderItems;
import grocery.OrderItemsRepository;
import grocery.OrderRepository;
import grocery.Product;
import grocery.ProductRepository;
import grocery.Status;
import grocery.User;
import grocery.UsersRepository;

@RestController
@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("user")
public class Controller {

	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private OrderItemsRepository orderItemsRepo;

	@PostMapping("/signup")
	public User signUp(HttpServletRequest req, @RequestBody User user) {

		User result = null;
		try {
			result = userRepo.save(user);

			if (result == null)
				return null;

			HttpSession session = req.getSession(true);
			session.setAttribute("userName", result.getUserName());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("/signin")
	public User signIn(HttpServletRequest req, @RequestBody User user) {
		User temp = userRepo.findByUserName(user.getUserName());

		System.out.println(temp);

		if (temp == null)
			return null;

		if (temp.getPassword().equals(user.getPassword())) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userName", temp.getUserName());
			return temp;
		}
		return user;
	}

	@PostMapping("/signout")
	public Status logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("userName") != null) {
			session.invalidate();
			return new Status(true);
		}
		return new Status(false);
	}

	@PostMapping("/category/add")
	public Category saveCategory(@RequestBody Category category) {

		return categoryRepo.save(category);
	}

	@GetMapping("/category/all")
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		Iterable<Category> iterable = categoryRepo.findAll();
		for (Category category : iterable) {
			categories.add(category);
		}
		return categories;
	}

	@PostMapping("/product/add")
	public Product saveProduct(@RequestBody Product product) {
		product.setCategory(new Category());
		product.getCategory().setId(product.getFk());
		return productRepo.save(product);
	}

	@GetMapping("/product/all")
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		Iterable<Product> iterable = productRepo.findAll();
		for (Product product : iterable) {
			products.add(product);
		}
		return products;
	}

	@GetMapping("/product/all/{id}")
	public List<Product> getProductsByCategoryId(@PathVariable Integer id) {
		Category c = new Category();
		c.setId(id);
		return productRepo.findByCategory(c);
	}

//	@GetMapping("/order/all")
//	public List<Order> getOrders() {
//		List<Order> orders = new ArrayList<Order>();
//		Iterable<Order> iterable = orderRepo.findAll();
//		for (Order order : iterable) {
//			orders.add(order);
//		}
//		return orders;
//	}

	@PostMapping("/order/add")
	public Order saveOrder(@RequestBody Order order) {
		order.setUser(new User());
		order.getUser().setId(order.getUfk());
		Order temp = orderRepo.save(order);		
		return temp;
	}
	
	@GetMapping("/order/all/{id}")
	public List<Order> getOrder(@PathVariable Integer id) {
		User c = new User();
		c.setId(id);
		return  orderRepo.findByUser(c);
	}

	
	@PostMapping("/order/items/add")
	public List<OrderItems> saveOrderItems(@RequestBody List<OrderItems> orderItems) {
		
		for (OrderItems orderItem : orderItems) {
			orderItem.setOrder(new Order());
			orderItem.getOrder().setOrderId(orderItem.getOfk());
		}

		Iterable<OrderItems> temp = orderItems;

		Iterable<OrderItems> res = orderItemsRepo.saveAll(temp);
		System.out.println(res);

		List<OrderItems> orderItemsList = new ArrayList<OrderItems>();

		for (OrderItems resItem : res) {
			orderItemsList.add(resItem);
		}
		System.out.println(orderItemsList);
		return orderItems;
	}

	@GetMapping("/order/items/all")
	public List<OrderItems> getOrderItems() {
		List<OrderItems> orders = new ArrayList<OrderItems>();
		Iterable<OrderItems> iterable = orderItemsRepo.findAll();
		for (OrderItems order : iterable) {
			orders.add(order);
		}
		return orders;
	}

	@GetMapping("/order/items/all/{id}")
	public List<OrderItems> getOrderItemsByOrderId(@PathVariable Integer id) {
		Order c = new Order();
		c.setOrderId(id);
		return orderItemsRepo.findByOrder(c);
	}

}
