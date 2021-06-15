/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.BoatEntity;
import entities.HarbourEntity;
import entities.OwnerEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author mathi
 */
public class DummyData {
            private static final EntityManagerFactory EMF = EntityManagerCreator.CreateEntityManagerTest();

    public static void main(String[] args) {
        
        try {
        System.out.println("> SETTING UP DUMMY DATA");
        EntityManager em = EMF.createEntityManager();
        OwnerEntity p1 = new OwnerEntity("Flemming","Lyngbyvej 132","11223344");
        OwnerEntity p2 = new OwnerEntity("Jonas","Egedalcentret 44","11221122");
        BoatEntity b1 = new BoatEntity("Yamaha","Phantom","Speedy","https://www.buster.fi/sites/default/files/2020-10/02_DSC1445.jpeg");
        BoatEntity b2 = new BoatEntity("Yamaha","Husky R8","Dog","https://finnmaster.fi/m/Husky-R8-2021_3.jpg");
        BoatEntity b3 = new BoatEntity("Maxi","95","Bounty","https://www.scanboat.com/images/boats/sejlbaad-maxi-95-solgtsoldverkauft-lignende-soeges-scanboat-picture-5225531.jpg");
        HarbourEntity h1 = new HarbourEntity("Brøndbyhavn","Brøndby Havnevej 20",10);
        HarbourEntity h2 = new HarbourEntity("rungstedhavn","Rungsted Havn 10",12);
        
        p1.addBoat(b1);
        p2.addBoat(b2);
        p2.addBoat(b3);
        
        h1.addBoat(b1);
        h2.addBoat(b2);
        h2.addBoat(b3);
        
        em.getTransaction().begin();
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.persist(p1);
        em.persist(p2);
        em.persist(h1);
        em.persist(h2);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        p2.removeBoat(b3);
        em.getTransaction().commit();
        
        
        System.out.println("> DUMMY DATA DONE");
        System.out.println("> > DUMMY DATA:");
        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getAddress() + " " + p1.getPhone());
        System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getAddress() + " " + p2.getPhone());
        System.out.println("hvem ejer båd b1 = " + b1.getOwnerList());
        System.out.println("Hvilken havn ligger b2 i" + b2.getHarbour());
        
        TypedQuery<BoatEntity> q1 = em.createQuery("SELECT b FROM BoatEntity b", BoatEntity.class);
        List<BoatEntity> boatList = q1.getResultList();
        
        System.out.println("Hvilke både ligger i h1: ");
            System.out.println(h1.getBoatList());
        
        } catch(Exception  e){
            System.out.println("ERROR : " + e.toString());
        }
        System.out.println("##########");
        System.out.println("> !! RUN TEST FOR API ApiTest.Java in Test packages. " );
    }

}
