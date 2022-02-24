package com.recipe.vo;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="food_ingredient")
public class IngredientVO {
	
	public String id ;
	public String menu ;
	public String amount ;

}
