package com.nv.foodapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	private String itemName;
	private String category;
	private int cost;
	private String imageName;

	public Item(String itemName, String category,int cost,String imageName) {
		super();
		this.itemName = itemName;
		this.category = category;
		this.cost = cost;
		this.imageName=imageName;
	}

}
