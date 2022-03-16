package com.recipe.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="comment")
public class Comment {

    @Id
    String id ;
    String comment;
    String title;
    Date write_date;
    
}
