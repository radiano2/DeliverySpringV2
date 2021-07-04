package com.example.demo.CompleteOrder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class CompleteOrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Double price;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    private String timeStamp = LocalDateTime.now().toString();

    public CompleteOrderModel(String name, String surname, Double price, String description) {
        this.name = name;
        this.surname = surname;
        this.price = price;
        this.description = description;
    }

    public CompleteOrderModel() {
    }
}
