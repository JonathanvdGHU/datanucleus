package com.test.klassen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dier {
    @Id
    @GeneratedValue
    private int dierID;
    private String naam;
    private String soort;
    private Persoon baasje;

    public Dier(String naam, String soort) {
        this.naam = naam;
        this.soort = soort;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public Persoon getBaasje() {
        return baasje;
    }

    public void setBaasje(Persoon baasje) {
        this.baasje = baasje;
    }

    public int getDierID() {
        return dierID;
    }

    @Override
    public String toString() {
        return "Dier{" +
                "naam='" + naam + '\'' +
                ", soort='" + soort + '\'' +
                ", baasje=" + baasje +
                '}';
    }
}