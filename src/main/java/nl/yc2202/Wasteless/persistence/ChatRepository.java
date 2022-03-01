package nl.yc2202.Wasteless.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.yc2202.Wasteless.domein.Chat;

@Component
public interface ChatRepository extends CrudRepository<Chat, Long>{

}
