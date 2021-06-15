/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;   
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 *
 * @author mathi
 */
@Entity

public class OwnerEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
    
    @ManyToMany(mappedBy="ownerList", cascade = CascadeType.PERSIST)
    List<BoatEntity> boatList;

    public OwnerEntity() {
    }

    public void addBoat(BoatEntity boat){
        if(boat != null){
        this.boatList.add(boat);
        boat.getOwnerList().add(this);
        }
        }
    
    public void removeBoat(BoatEntity boat){
        if(boat != null){
            boatList.remove(boat);
            boat.getOwnerList().remove(this);
        }
    }
            
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OwnerEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OwnerEntity(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.boatList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DummyEntity{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + '}';
    }
    

    
}
