/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author melo-
 */
@Entity
public class HarbourEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String harbourName;
    private String harbourAddress;
    private int capacity;

    @OneToMany(mappedBy = "harbour", cascade = CascadeType.PERSIST)
    List<BoatEntity> harbourBoatList;
    
    
    public HarbourEntity() {
    }

    public HarbourEntity(String harbourName, String harbourAddress, int capacity) {
        this.harbourName = harbourName;
        this.harbourAddress = harbourAddress;
        this.capacity = capacity;
        this.harbourBoatList = new ArrayList<>();
    }

    public List<BoatEntity> getBoatList() {
        return harbourBoatList;
    }

    public void addBoat(BoatEntity boat) {
        this.harbourBoatList.add(boat);
        if(boat != null){
        boat.setHarbour(this);
        }
    }
    
    public void removeBoat(BoatEntity boat){
        if(boat != null){
            harbourBoatList.remove(boat);
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHarbourName() {
        return harbourName;
    }

    public void setHarbourName(String harbourName) {
        this.harbourName = harbourName;
    }

    public String getHarbourAddress() {
        return harbourAddress;
    }

    public void setHarbourAddress(String harbourAddress) {
        this.harbourAddress = harbourAddress;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "HarbourEntity{" + "id=" + id + ", harbourName=" + harbourName + ", harbourAddress=" + harbourAddress + ", capacity=" + capacity + '}';
    }
  
    
}
