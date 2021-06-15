/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author melo-
 */
@Entity
public class BoatEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String make;
    private String boatName;
    private String image;
    
    @ManyToMany
    private List<OwnerEntity> ownerList;

    public BoatEntity() {
    }

    public BoatEntity(String brand, String make, String boatName, String image) {
        this.brand = brand;
        this.make = make;
        this.boatName = boatName;
        this.image = image;
        this.ownerList = new ArrayList<>();
    }

    public List<OwnerEntity> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<OwnerEntity> ownerList) {
        this.ownerList = ownerList;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "BoatEntity{" + "id=" + id + ", brand=" + brand + ", make=" + make + ", boatName=" + boatName + ", image=" + image + '}';
    }
    
    
}
