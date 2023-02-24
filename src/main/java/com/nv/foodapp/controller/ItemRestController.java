package com.nv.foodapp.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nv.foodapp.dto.ItemDTO;
import com.nv.foodapp.dto.ItemRequestDTO;
import com.nv.foodapp.entity.Item;
import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.repository.item.ItemRepository;
import com.nv.foodapp.repository.restaurant.IRestaurantRepository;
import com.nv.foodapp.service.item.IItemService;
import com.nv.foodapp.util.ItemDTOConvertor;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins= {"http://localhost:4200","http://localhost:2022"},allowedHeaders = "*")
public class ItemRestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ItemDTOConvertor itemConvertor;

	@Autowired
	IItemService itemService;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	IRestaurantRepository restaurantRepository;

	public ItemRestController() {
		logger.info("Item rest controller");
		System.err.println("Item rest controller");
	}

	@PostMapping("/register")
	public ResponseEntity<ItemDTO> savedItem(@RequestBody ItemRequestDTO itemDto) throws Exception {
		Item item=itemConvertor.getItemReqDto(itemDto);
		Item savedItem = itemService.addItem(item);
		//Restaurant restaurant = restaurantRepository.findById(rid).orElseThrow(EntityNotFoundException::new);
		logger.info(" --->> Instructor saved " + savedItem);

		if (savedItem != null) {
			ItemDTO dtoObj = itemConvertor.getItemDTO(savedItem);
			return new ResponseEntity<ItemDTO>(dtoObj, HttpStatus.OK);

		}
		return null;
	}

	@GetMapping("/list")
	public ResponseEntity<List<ItemDTO>> getAllItems() {
		List<Item> allItems = itemService.viewAllItems();
		List<ItemDTO> itemDtoList = new ArrayList<>();

		if (allItems != null && allItems.isEmpty() == false) {
			for (Item item : allItems) {
				ItemDTO dto = itemConvertor.getItemDTO(item);
				itemDtoList.add(dto);
			}
		}

		return new ResponseEntity<List<ItemDTO>>(itemDtoList, HttpStatus.OK);
	}

	@PutMapping("/{itemid}/restaurant/{rid}")
	public ResponseEntity<ItemDTO> updateRestuarantByItemId(@PathVariable int itemid, @PathVariable int rid)
			throws Exception {

		Item updatedItem = itemService.updateRestaurantBYItem(rid, itemid);
		if (updatedItem != null) {
			ItemDTO dto = itemConvertor.getItemDTO(updatedItem);
			return new ResponseEntity<ItemDTO>(dto, HttpStatus.OK);

		}

		return null;
	}

	@GetMapping("/{itemid}")
	public ResponseEntity<ItemDTO> getItemById(@PathVariable int itemid) throws Exception {

		Item savedItem = itemService.viewItemById(itemid);
		ItemDTO dto = itemConvertor.getItemDTO(savedItem);
		return new ResponseEntity<ItemDTO>(dto, HttpStatus.OK);

	}

}
