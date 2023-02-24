package com.nv.foodapp.service.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.foodapp.entity.Item;
import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.exception.InvalidInputDataException;
import com.nv.foodapp.repository.item.ItemRepository;
import com.nv.foodapp.repository.restaurant.IRestaurantRepository;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	ItemRepository itemrepository;

	@Autowired
	IRestaurantRepository restaurantRepository;

	@Override
	@Transactional
	public Item addItem(Item item) throws Exception {
		// TODO Auto-generated method stub
		if (item != null) {
			if (item.getItemName().equals("")) {
				throw new InvalidInputDataException("item name", "item name is null");
			}
			Item savedItem = itemrepository.save(item);
			return savedItem;
		} else
			throw new NullPointerException("item is null");

	}

	@Override
	public Item viewItemById(int id) throws Exception {
		// TODO Auto-generated method stub

		if (id >= 1) {
			Item savedItem = itemrepository.getReferenceById(id);
			if (savedItem != null)
				return savedItem;
			else {
				throw new EntityNotFoundException("Invalid Item ID : " + id);
			}
		}
		return null;
	}

	@Override
	public Item updateRestaurantBYItem(int restaurantid, int itemid) throws Exception {
		// TODO Auto-generated method stub

		Item itemFromDB = viewItemById(itemid);

		Restaurant restaurantFromDB = restaurantRepository.getReferenceById(restaurantid);
		
		
		if (itemFromDB != null & restaurantFromDB != null) {
			List<Item> allItems = restaurantFromDB.getItem();

			if (allItems != null && allItems.isEmpty() == false) {
				allItems.add(itemFromDB);
				restaurantFromDB.setItem(allItems);
			} else {
				List<Item> newItemList = new ArrayList<>();
				newItemList.add(itemFromDB);
				restaurantFromDB.setItem(newItemList);
				;
			}
			// call repository save method
			restaurantRepository.saveAndFlush(restaurantFromDB);
			itemrepository.save(itemFromDB);
			return itemFromDB;
		} else {

			throw new NullPointerException(
					"Either Item " + itemFromDB + "or Restaurant " + restaurantFromDB + " is Null ");
		}

	}

	@Override
	public List<Item> viewAllItems() {
		// TODO Auto-generated method stub
		return itemrepository.findAll();
	}

	@Override
	public Item viewAllItemsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
