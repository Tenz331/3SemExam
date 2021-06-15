/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.OwnerEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melo-
 */
public class OwnerDto {
    private int dtoOwnerid;
    private String dtoName;
    private String dtoAddress;
    private String dtoPhone;

    public String getDtoAddress() {
        return dtoAddress;
    }

    public void setDtoAddress(String dtoAddress) {
        this.dtoAddress = dtoAddress;
    }

    public String getDtoPhone() {
        return dtoPhone;
    }

    public void setDtoPhone(String dtoPhone) {
        this.dtoPhone = dtoPhone;
    }

    public String getDtoName() {
        return dtoName;
    }

    public void setDtoName(String dtoName) {
        this.dtoName = dtoName;
    }

    @Override
    public String toString() {
        return "DummyDto{" + "dtoName=" + dtoName + ", dtoAddress=" + dtoAddress + ", dtoPhone=" + dtoPhone + '}';
    }

    public int getDtoOwnerid() {
        return dtoOwnerid;
    }

    public void setDtoOwnerid(int dtoOwnerid) {
        this.dtoOwnerid = dtoOwnerid;
    }

    public OwnerDto(String dtoName, String dtoAddress, String dtoPhone, int dtoOwnerid) {
        this.dtoOwnerid = dtoOwnerid;
        this.dtoName = dtoName;
        this.dtoAddress = dtoAddress;
        this.dtoPhone = dtoPhone;
    }


    public OwnerDto(OwnerEntity rm) {
        this.dtoOwnerid = rm.getId();
        this.dtoName = rm.getName();
        this.dtoAddress = rm.getAddress();
        this.dtoPhone = rm.getPhone();
    }

    
public static List<OwnerDto> getDtos(List<OwnerEntity> rms){
        List<OwnerDto> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new OwnerDto(rm)));
        return rmdtos;
    }

}

