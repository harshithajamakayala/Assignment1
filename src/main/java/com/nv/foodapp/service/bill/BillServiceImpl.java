package com.nv.foodapp.service.bill;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.foodapp.entity.Bill;
import com.nv.foodapp.entity.Item;
import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.exception.InvalidInputDataException;
import com.nv.foodapp.repository.bill.IBillRepository;
import com.nv.foodapp.repository.restaurant.IRestaurantRepository;
@Service
public class BillServiceImpl implements IBillService {

	@Autowired
	IBillRepository billRepository;
	
	@Autowired
	IRestaurantRepository restaurantRepository;

	@Override
	public Bill addBill(Bill bill)throws Exception {
		// TODO Auto-generated method stub
		if (bill != null) {
			bill.setGstAmount((int)(bill.getGrossBillAmount()*0.10));
			bill.setGrossBillAmount(bill.getGstAmount()+bill.getGrossBillAmount());
			Bill savedBill = billRepository.save(bill);
			return savedBill;
		} else
			throw new NullPointerException("restaurant is null");
	}

	
	@Override
	public boolean removeBill(int billId) {
		// TODO Auto-generated method stub
		billRepository.deleteById(billId);
		return true;
	}

	@Override
	public Bill viewBillById(int id)throws Exception {
		// TODO Auto-generated method stub
		if (id >= 1) {
			Bill savedBill = billRepository.getReferenceById(id);
			if (savedBill != null)
				return savedBill;
			else {
				throw new EntityNotFoundException("Invalid Bill ID : " + id);
			}
		}
		return null;
	}

	@Override
	public List<Bill> viewAllBills() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

}
