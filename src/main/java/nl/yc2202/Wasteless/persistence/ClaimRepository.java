package nl.yc2202.Wasteless.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.domein.Item;

import nl.yc2202.Wasteless.domein.User;

@Component
public interface ClaimRepository extends CrudRepository<Claim, Long>{

	
	List <Claim> findAllByItem(Item item);
}
