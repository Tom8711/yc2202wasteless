package nl.yc2202.Wasteless.inbrengfelix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemEndpointFelix {
	@Autowired
	FelixService fs;
	
	@GetMapping("/item/{itemid}/setitemtooffered")
	public boolean itemSetOffered(@PathVariable("itemid") int itemid) {
		System.out.println("item Set Offered : " + itemid);
		fs.itemSetOffered(itemid);
		return true;
	}
}
