/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.BoatDto;
import dto.HarbourDto;
import dto.OwnerDto;
import entities.BoatEntity;
import entities.HarbourEntity;
import entities.OwnerEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author mathi
 */
public class testFacade {
        private static EntityManagerFactory emf;
        private static testFacade instance;
        
            private testFacade() {}


    public static testFacade getDummyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new testFacade();
        }
        return instance;
    }
        public OwnerDto createOwner(OwnerEntity rm){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rm);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new OwnerDto(rm);
        }
        
         public BoatDto createBoat(BoatEntity rm){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rm);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new BoatDto(rm);
        }
         
        public List<OwnerDto> getAllOwners(){
        
        EntityManager em = emf.createEntityManager();
          List<OwnerEntity> rms;
        try{
        TypedQuery<OwnerEntity> query = em.createQuery("SELECT p FROM OwnerEntity p", OwnerEntity.class);
            System.out.println(query);
        rms = query.getResultList();
        }catch(Exception e){    
     throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience " + e.toString(),500);
    }
        return OwnerDto.getDtos(rms);
    }

    public List<BoatDto> getBoats(){
        
        EntityManager em = emf.createEntityManager();
          List<BoatEntity> rms;
        try{
        TypedQuery<BoatEntity> query = em.createQuery("SELECT b FROM BoatEntity b", BoatEntity.class);
            System.out.println(query);
        rms = query.getResultList();
        }catch(Exception e){    
     throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience " + e.toString(),500);
    }
        return BoatDto.getDtos(rms);
    }
        
     public List<HarbourDto> getHarbours(){
        
        EntityManager em = emf.createEntityManager();
          List<HarbourEntity> rms;
        try{
        TypedQuery<HarbourEntity> query = em.createQuery("SELECT h FROM HarbourEntity h", HarbourEntity.class);
            System.out.println(query);
        rms = query.getResultList();
        }catch(Exception e){    
     throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience " + e.toString(),500);
    }
        return HarbourDto.getDtos(rms);
    }
        
        
    public BoatDto boatEdit(int dtoid, String dtobrand, String dtomake, String dtoboatName, String dtoimage) {
    EntityManager em = emf.createEntityManager();
    BoatEntity boatToEdit;
    try{
        boatToEdit = (em.find(BoatEntity.class, dtoid));
        boatToEdit.setBrand(dtobrand);
        boatToEdit.setMake(dtomake);
        boatToEdit.setBoatName(dtoboatName);
         boatToEdit.setImage(dtoimage);
        em.getTransaction().begin();
        em.merge(boatToEdit);
        em.getTransaction().commit();
    }catch(Exception e){
        throw new WebApplicationException(e.toString());
    }
    return new BoatDto(boatToEdit);
    }

    public BoatDto delete(int id) {
        EntityManager em = emf.createEntityManager();
    BoatEntity boatToDelete;
    try{
        boatToDelete = (em.find(BoatEntity.class, id));
        em.getTransaction().begin();
        em.remove(boatToDelete);
        em.getTransaction().commit();
    }catch(Exception e){
        throw new WebApplicationException(e.toString());
    }
    return new BoatDto(boatToDelete);
    }
    
        
        
}

