/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.OwnerDto;
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
        public OwnerDto createPerson(OwnerEntity rm){
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
        
        public List<OwnerDto> getAllPersons(){
        
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

    public OwnerDto edit(int id, String dtoName) {
    EntityManager em = emf.createEntityManager();
    OwnerEntity personToEdit;
    try{
        personToEdit = (em.find(OwnerEntity.class, id));
        personToEdit.setName(dtoName);
        em.getTransaction().begin();
        em.merge(personToEdit);
        em.getTransaction().commit();
    }catch(Exception e){
        throw new WebApplicationException(e.toString());
    }
    return new OwnerDto(personToEdit);
    }

    public OwnerDto delete(int id) {
        EntityManager em = emf.createEntityManager();
    OwnerEntity personToDelete;
    try{
        personToDelete = (em.find(OwnerEntity.class, id));
        em.getTransaction().begin();
        em.remove(personToDelete);
        em.getTransaction().commit();
    }catch(Exception e){
        throw new WebApplicationException(e.toString());
    }
    return new OwnerDto(personToDelete);
    }
    
        
        
}

