package com.goanna;

import javax.persistence.*;

@Entity
@Table
public class InputVariables {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String gender;
    private double weight;
    private double standardDrinks;
    private double hoursDrinking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getHoursDrinking() {
        return hoursDrinking;
    }

    public void setHoursDrinking(double hoursDrinking) {
        this.hoursDrinking = hoursDrinking;
    }

    public double getStandardDrinks() {
        return standardDrinks;
    }

    public void setStandardDrinks(double standardDrinks) {
        this.standardDrinks = standardDrinks;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}

