package com.recipe.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {
	
	public int seq;
	public String name;
	public String nickname;
	@Id
	public String id;
	public String pw;
	public String auth;
	public Date join_date;
	public Date leave_date;
	

}
