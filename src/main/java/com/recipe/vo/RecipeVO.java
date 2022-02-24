package com.recipe.vo;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="recipe")
public class RecipeVO {
	
	public String id;
	public String menu;
	public String recipe;
	
}
