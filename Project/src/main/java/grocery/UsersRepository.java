package grocery;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, String>{

	User findByUserName(String userName);
	User findById(Integer id);
	
}