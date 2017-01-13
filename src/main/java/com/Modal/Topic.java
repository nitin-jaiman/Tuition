package com.Modal;


import javax.persistence.*;

/**
 * Created by apple on 24/12/16.
 */
@Entity
@Table(name = "topic")
public class Topic {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer name;
    private String description;
    private String category;



    public Integer getName() {
        return name;

    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
