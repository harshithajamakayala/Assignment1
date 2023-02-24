package com.nv.foodapp.service.item;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.foodapp.entity.Item;

@Service
public interface IItemService {
	
	public Item addItem(Item item)throws Exception;
	public Item viewItemById(int id)throws Exception;
	public Item updateRestaurantBYItem(int restaurantid,int itemid)throws Exception;
	public List<Item> viewAllItems();
	public Item viewAllItemsByName(String name);

	

}
