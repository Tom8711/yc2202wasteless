package nl.yc2202.Wasteless.inbrengfelix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.persistence.ItemRepository;

@Component
public class FelixService {
	@Autowired
	ItemRepository ir;
	
	public boolean itemSetOffered(long itemid) {
		Item i = ir.findById(itemid).get();
		i.setOffered(true);
		ir.save(i);
		return true;
	}
}
