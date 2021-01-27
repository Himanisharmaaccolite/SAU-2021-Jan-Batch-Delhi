package com.example;

import javax.persistence.*;

@Entity
public class Himani {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int number;

    private int weight;
    private int height;
    //    @Transient
    private int age;
    private int favFood;

    public Himani( ){}

    public Himani(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFavFood(int favFood) {
        this.favFood = favFood;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public int getFavFood() {
        return favFood;
    }


    @Override
    public String toString() {
        return "Himani{" +
                "number=" + number +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", favFood=" + favFood +
                '}';
    }
}
