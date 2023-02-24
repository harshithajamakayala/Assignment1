package com.nv.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.nv.foodapp.dto.BillDTO;
import com.nv.foodapp.dto.RestaurantDTO;
import com.nv.foodapp.entity.Bill;
import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.service.bill.IBillService;
import com.nv.foodapp.util.BillDTOConvertor;

@RestController
@RequestMapping("/bill")
@CrossOrigin(origins= {"http://localhost:4200","http://localhost:2022"},allowedHeaders = "*")
public class BillRestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BillDTOConvertor billDTOConvertor;

	@Autowired
	IBillService billService;

	public BillRestController() {
		logger.info("Bill rest controller");
		System.err.println("Bill rest controller");

	}

	@PostMapping("/register")
	public ResponseEntity<BillDTO> saveBill(@RequestBody Bill bill) throws Exception {
		Bill savedBill = billService.addBill(bill);
		logger.info(" --->> Bill saved " + savedBill);

		if (savedBill != null) {
			BillDTO dtoObj = billDTOConvertor.getBillDTO(savedBill);
			return new ResponseEntity<BillDTO>(dtoObj, HttpStatus.OK);

		}
		return null;
	}

	@GetMapping("/list")
	public ResponseEntity<List<BillDTO>> getAllBills() {
		List<Bill> allBillsInDB = billService.viewAllBills();

		List<BillDTO> dtoList = new ArrayList<>();
		for (Bill bill : allBillsInDB) {

			BillDTO dtoObj = billDTOConvertor.getBillDTO(bill);
			dtoList.add(dtoObj);
		}

		return new ResponseEntity<List<BillDTO>>(dtoList, HttpStatus.OK);
	}
	

}
