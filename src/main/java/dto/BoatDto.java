/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BoatEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melo-
 */
public class BoatDto {
    
     private String dtobrand;
    private String dtomake;
    private String dtoboatName;
    private String dtoimage;
    private int harbour_id;

    public String getDtobrand() {
        return dtobrand;
    }

    public int getHarbour_id() {
        return harbour_id;
    }

    public void setHarbour_id(int harbour_id) {
        this.harbour_id = harbour_id;
    }

    public void setDtobrand(String dtobrand) {
        this.dtobrand = dtobrand;
    }

    public String getDtomake() {
        return dtomake;
    }

    public void setDtomake(String dtomake) {
        this.dtomake = dtomake;
    }

    public String getDtoboatName() {
        return dtoboatName;
    }

    public void setDtoboatName(String dtoboatName) {
        this.dtoboatName = dtoboatName;
    }

    public String getDtoimage() {
        return dtoimage;
    }

    public void setDtoimage(String dtoimage) {
        this.dtoimage = dtoimage;
    }

    public BoatDto(String dtobrand, String dtomake, String dtoboatName, String dtoimage,int dtoharbour_id) {
        this.dtobrand = dtobrand;
        this.dtomake = dtomake;
        this.dtoboatName = dtoboatName;
        this.dtoimage = dtoimage;
        this.harbour_id = dtoharbour_id;
    }
    
      public BoatDto(BoatEntity rm) {
        this.dtobrand = rm.getBrand();
        this.dtomake = rm.getMake();
        this.dtoboatName = rm.getBoatName();
        this.dtoimage = rm.getImage();
    }
    
      public static List<BoatDto> getDtos(List<BoatEntity> rms){
        List<BoatDto> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new BoatDto(rm)));
        return rmdtos;
    }
}
