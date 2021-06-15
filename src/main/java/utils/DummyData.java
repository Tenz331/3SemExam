/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.BoatEntity;
import entities.OwnerEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mathi
 */
public class DummyData {
            private static final EntityManagerFactory EMF = EntityManagerCreator.CreateEntityManagerTest();

    public static void main(String[] args) {
        
        try {
        System.out.println("> SETTING UP DUMMY DATA POGGERS");
        EntityManager em = EMF.createEntityManager();
        OwnerEntity p1 = new OwnerEntity("Person1","Lyngbyvej 132","11223344");
        OwnerEntity p2 = new OwnerEntity("Person2","Egedalcentret 44","11221122");
        BoatEntity b1 = new BoatEntity("Yamaha","Phantom","Speedy","https://www.buster.fi/sites/default/files/2020-10/02_DSC1445.jpeg");
        BoatEntity b2 = new BoatEntity("Yamaha","Husky R8","Dog","https://finnmaster.fi/m/Husky-R8-2021_3.jpg");
        
        p1.addBoat(b1);
        p2.addBoat(b2);
        
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
        System.out.println("> DUMMY DATA DONE");
        System.out.println("> > DUMMY DATA:");
        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getAddress() + " " + p1.getPhone() + "BOAT =");
        System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getAddress() + " " + p2.getPhone());
        } catch(Exception  e){
            System.out.println("ERROR : " + e.toString());
        }
        System.out.println("##########");
        System.out.println("> !! RUN TEST FOR API ApiTest.Java in Test packages. " );
    }

}
