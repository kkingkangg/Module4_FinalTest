package com.example.testfinal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Nation nation;
    private String name;

    private double area;
    private Long quantity;
    private Long GPA;
    private String description;

    public City() {
    }

    public City(Nation nation, String name, double area, Long quantity, Long GPA, String description) {
        this.nation = nation;
        this.name = name;
        this.area = area;
        this.quantity = quantity;
        this.GPA = GPA;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getGPA() {
        return GPA;
    }

    public void setGPA(Long GPA) {
        this.GPA = GPA;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
