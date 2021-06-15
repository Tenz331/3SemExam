/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
        OwnerEntity df1 = new OwnerEntity("Person1","Lyngbyvej 132","11223344");
        OwnerEntity df2 = new OwnerEntity("Person2","Egedalcentret 44","11221122");
        em.getTransaction().begin();
        em.persist(df1);
        em.persist(df2);
        em.getTransaction().commit();
        System.out.println("> DUMMY DATA DONE");
        System.out.println("> > DUMMY DATA:");
        System.out.println(df1.getId() + " " + df1.getName() + " " + df1.getAddress() + " " + df1.getPhone());
        System.out.println(df2.getId() + " " + df2.getName() + " " + df2.getAddress() + " " + df2.getPhone());
        } catch(Exception  e){
            System.out.println("ERROR : " + e.toString());
        }
        System.out.println("##########");
        System.out.println("> !! RUN TEST FOR API ApiTest.Java in Test packages. " );
    }

}
