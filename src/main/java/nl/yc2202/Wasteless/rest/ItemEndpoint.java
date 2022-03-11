package nl.yc2202.Wasteless.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.dto.CreateItemDto;
import nl.yc2202.Wasteless.persistence.ItemService;


@RestController
public class ItemEndpoint {

	@Autowired
	ItemService is;

	@GetMapping("/getclaimeditemswithuserid/{userId}")
	public Iterable<Item> getAllClaimedItemsById(@PathVariable("userId") long userId) {
		return is.getAllClaimedItemsByUserId(userId);
	}
	
	@GetMapping("/getitemswithuserid/{userId}")
	public Iterable<Item> getAllItemsById(@PathVariable("userId") long userId) {
		return is.getAllItemsByUserId(userId);
	}
	
//	@GetMapping("/getitemlist")
//	public Iterable<Item> getItemList() {
//		return is.getAllItems();
//	}
	
	@GetMapping ("/getoffereditemlist")
	public List<Item> getOfferedItemlist() {
		return is.getAllOfferedItems();
	}

//	@GetMapping ("/getlistitembydate")
//	public List<Item> getListItemByDate() {
//		return is.getAllItemsSortedByDate();
//	}
	
	// All items and sorted by expiration date
	@GetMapping ("/getlistclaimbydate")
	public List<Item> getListClaimByDate() {
		System.out.println("Test1");
		return is.findByOfferedTrueOrderByExpirationDate();
	}
	
	
	@PostMapping("/createitem")
	public void createItem(@RequestBody CreateItemDto createItemDto) {
			is.CreateItem(createItemDto.getItem(), createItemDto.getUserId());
	}

	@DeleteMapping("/deleteitem/{variable}")
	public void deleteItem(@PathVariable("variable") long id) {
		is.DeleteItem(id);
		
	}
	
	@PostMapping("/updateoffered/{itemid}/{offered}")
	public void updateOffered(@PathVariable("itemid")long itemId, @PathVariable("offered")boolean offered) {
		is.updateOffered(offered, itemId);
	}
}

