package nl.yc2202.Wasteless.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.dto.CreateItemDto;
import nl.yc2202.Wasteless.dto.ItemStatusDto;
import nl.yc2202.Wasteless.persistence.ClaimService;
import nl.yc2202.Wasteless.persistence.ItemService;
import nl.yc2202.Wasteless.persistence.Status;


@RestController
public class ItemEndpoint {

	@Autowired
	ItemService is;
	
	@Autowired 
	ClaimService cs;

	@GetMapping("/getclaimeditemswithuserid/{userId}")
	public List<ItemStatusDto> getAllClaimedItemsById(@PathVariable("userId") long userId) {
		
		List<ItemStatusDto> result = new ArrayList <>();
		
		Iterable <Item> item = is.getAllClaimedItemsByUserId(userId);
		for(Item i: item){
			ItemStatusDto itemStatusDto = new ItemStatusDto();
			itemStatusDto.setItem(i);
			Claim claim = cs.findLatestClaim(i);
			itemStatusDto.setStatus(claim.getStatus());
			result.add(itemStatusDto);
		}
		
		return result;
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

