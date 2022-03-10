package com.recipe.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="food_ingredient")
public class Ingredient {
	
	public int seq;
	public String id ;
	@Id
	public String menu ;
	public String ingredient;
	public String amount ;

}
