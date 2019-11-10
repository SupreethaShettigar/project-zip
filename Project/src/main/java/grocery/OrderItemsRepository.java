package grocery;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderItemsRepository extends CrudRepository<OrderItems, Integer> {

	List<OrderItems> findByOrder(Order c);
}
