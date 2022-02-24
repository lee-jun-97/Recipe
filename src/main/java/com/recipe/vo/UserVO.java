package com.recipe.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user")
public class UserVO {
	
	public String name;
	public String nickname;
	public String id;
	public String pw;
	public Date join_date;
	public Date leave_date;
	

}
