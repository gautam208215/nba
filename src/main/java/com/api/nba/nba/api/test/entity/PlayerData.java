package com.api.nba.nba.api.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PlayerData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String first_name;
	private int height_feet;
	private int height_inches;
	private String last_name;
	private String position;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Team team;
	
	private String weight_pounds;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getHeight_feet() {
		return height_feet;
	}

	public void setHeight_feet(int height_feet) {
		this.height_feet = height_feet;
	}

	public int getHeight_inches() {
		return height_inches;
	}

	public void setHeight_inches(int height_inches) {
		this.height_inches = height_inches;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getWeight_pounds() {
		return weight_pounds;
	}

	public void setWeight_pounds(String weight_pounds) {
		this.weight_pounds = weight_pounds;
	}

}
