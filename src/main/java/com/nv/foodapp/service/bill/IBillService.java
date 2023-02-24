package com.nv.foodapp.service.bill;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.foodapp.entity.Bill;
import com.nv.foodapp.entity.Item;
import com.nv.foodapp.entity.Restaurant;
@Service
public interface IBillService {
	public Bill addBill(Bill bill)throws Exception;
	public boolean removeBill(int billId);
	public Bill viewBillById(int id)throws Exception;
	public List<Bill> viewAllBills();
	

}
