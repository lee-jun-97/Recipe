package com.recipe.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="recipe")
public class RecipeVO {
	
	public int seq;
	public String id;
	@Id
	public String menu;
	public String recipe;
	
}
