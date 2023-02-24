package com.nv.foodapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.nv.foodapp.dto.ItemDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int restaurantId;
	private String restaurantName;
	private String managerName;
	private String contactNumber;
	private String imageName;
	


	@Embedded
	@Column(nullable = true)
	private Address address;
    //cascade = CascadeType.ALL
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurantid") // has to be one to many
	private List<Item> item=new ArrayList<>();

	public Restaurant(String restaurantName, String managerName, String contactNumber, Address address,String imageName) {
		super();
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
		this.imageName=imageName;
		this.address = address;
	}

}
