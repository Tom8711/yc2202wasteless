package nl.yc2202.Wasteless.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.domein.User;

@Component
public interface ClaimRepository extends CrudRepository<Claim, Long>{

	
	List <Claim> findAllByItem(Item item);
	List <Claim> findAllByStatus(Status pending);
	
	Optional <Claim> findFirstByItemOrderByRequestDateDesc(Item item);

	List <Claim> findAllByStatusAndItem(Status pending, Optional<Item> item);
	List <Claim> findAllByUser(User user);

}
