package com.test.klassen;


import org.datanucleus.transaction.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tutorial");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Persoon p1 = new Persoon("Julian", 19);
            Dier d1 = new Dier("Mees", "Kat");
            Dier d2 = new Dier("Milo", "Kat");
            p1.addDier(d2);
            p1.addDier(d1);
            d1.setBaasje(p1);

            em.persist(p1);

            tx.commit();

            Long baasjeID = p1.getPersoonID();
            System.out.println("Baasje is gepersisteerd");

            Persoon retrievedPersoon = em.find(Persoon.class, baasjeID);

            System.out.println("Persoon: " + retrievedPersoon.getNaam() + " - " + retrievedPersoon.getAge());

            for (Dier dier : retrievedPersoon.getDieren()) {
                System.out.println("Dier: " + dier.getNaam() + " - " + dier.getSoort());
            }
        } catch (Exception e) {
            System.out.println("Er is iets foutgegaan: " + e.getMessage());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}