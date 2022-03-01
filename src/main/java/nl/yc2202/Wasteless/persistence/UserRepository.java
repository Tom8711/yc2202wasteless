package nl.yc2202.Wasteless.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.yc2202.Wasteless.domein.User;

@Component
public interface UserRepository extends CrudRepository<User, Long>{

}
