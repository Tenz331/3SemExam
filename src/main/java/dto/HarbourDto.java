/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.HarbourEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melo-
 */
public class HarbourDto {
    private int dtoHarbourid;
     private String dtoHarbourName;
    private String dtoHarbourAddress;
    private int dtoCapacity;

    public String getDtoHarbourName() {
        return dtoHarbourName;
    }

    public void setDtoHarbourName(String dtoHarbourName) {
        this.dtoHarbourName = dtoHarbourName;
    }

    public String getDtoHarbourAddress() {
        return dtoHarbourAddress;
    }

    public void setDtoHarbourAddress(String dtoHarbourAddress) {
        this.dtoHarbourAddress = dtoHarbourAddress;
    }

    public int getDtoCapacity() {
        return dtoCapacity;
    }

    public void setDtoCapacity(int dtoCapacity) {
        this.dtoCapacity = dtoCapacity;
    }

    public int getDtoHarbourid() {
        return dtoHarbourid;
    }

    public void setDtoHarbourid(int dtoHarbourid) {
        this.dtoHarbourid = dtoHarbourid;
    }

    public HarbourDto(String dtoHarbourName, String dtoHarbourAddress, int dtoCapacity, int dtoHarbourid) {
        this.dtoHarbourid = dtoHarbourid;
        this.dtoHarbourName = dtoHarbourName;
        this.dtoHarbourAddress = dtoHarbourAddress;
        this.dtoCapacity = dtoCapacity;
    }
    
    public HarbourDto(HarbourEntity rm) {
        this.dtoHarbourid = rm.getId();
        this.dtoHarbourName = rm.getHarbourName();
        this.dtoHarbourAddress = rm.getHarbourAddress();
        this.dtoCapacity = rm.getCapacity();
    }

    
    public static List<HarbourDto> getDtos(List<HarbourEntity> rms){
        List<HarbourDto> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new HarbourDto(rm)));
        return rmdtos;
    }
    
    @Override
    public String toString() {
        return "HarbourDto{" + "dtoHarbourName=" + dtoHarbourName + ", dtoHarbourAddress=" + dtoHarbourAddress + ", dtoCapacity=" + dtoCapacity + '}';
    }
    
    
}
