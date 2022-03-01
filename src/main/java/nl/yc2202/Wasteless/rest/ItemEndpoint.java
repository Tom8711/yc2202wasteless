package nl.yc2202.Wasteless.rest;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.domein.User;
import nl.yc2202.Wasteless.persistence.ItemService;


@RestController
public class ItemEndpoint {

	@Autowired
	ItemService is;

	@GetMapping("/getitemlist")
	public Iterable<Item> getItemList() {
		return is.getAllItems();
	}
	
	@GetMapping ("/getoffereditemlist")
	public List<Item> getOfferedItemlist() {
		return is.getAllOfferedItems();
	}

	@GetMapping ("/getlistitembydate")
	public List<Item> getListItemByDate() {
		return is.getAllItemsSortedByDate();
	}
	
	
	@PostMapping("/createitem/{variable}")
	public void createItem(@RequestBody Item item, @PathVariable("variable") long userid) {
			System.out.println(item);
			System.out.println(userid);
			is.CreateItem(item, userid);
	}

	@DeleteMapping("/deleteitem/{variable}")
	public void deleteItem(@PathVariable("variable") long id) {
		is.DeleteItem(id);
		
	}
}

