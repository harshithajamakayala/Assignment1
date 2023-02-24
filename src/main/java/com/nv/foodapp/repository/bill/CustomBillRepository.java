package com.nv.foodapp.repository.bill;

import com.nv.foodapp.entity.Bill;
import com.nv.foodapp.entity.Restaurant;

public interface CustomBillRepository {
	public Bill updateRestaurantByBill(Bill bill,Restaurant restaurant);

}
