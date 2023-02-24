package com.nv.foodapp.repository.bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.foodapp.entity.Bill;
@Repository
public interface IBillRepository extends JpaRepository<Bill,Integer>,CustomBillRepository{

}
