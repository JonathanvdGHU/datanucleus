package com.test.klassen;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class Persoon {
    @Id
    @GeneratedValue
    private long persoonID;
    private String naam;
    private int age;
    @OneToMany(cascade = CascadeType.PERSIST)
    private ArrayList<Dier> dieren = new ArrayList<>();

    public Persoon(String naam, int age) {
        this.naam = naam;
        this.age = age;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Dier> getDieren() {
        return new ArrayList<>(dieren);
    }

    public void addDier(Dier dier) {
        dieren.add(dier);
    }

    public long getPersoonID() {
        return persoonID;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "naam='" + naam + '\'' +
                ", age=" + age +
                ", dieren=" + dieren +
                '}';
    }
}