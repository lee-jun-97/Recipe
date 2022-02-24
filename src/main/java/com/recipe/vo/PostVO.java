package com.recipe.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="post")
public class PostVO {
	
	public String id ;
	public String menu ;
	public String title ;
	public Date reg_date ;
	
}
