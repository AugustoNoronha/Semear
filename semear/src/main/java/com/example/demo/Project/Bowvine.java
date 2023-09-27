package com.example.demo.Project;

import java.sql.Blob;
import java.util.Date;

/**
 * Classe que representa os bovinos
 */
public class Bowvine {
    private long id;
    private String type;
    private Date borndate;
    private String race;
    private String bowvinecol;
    private String sex;
    private String coat;
    private long ownerId;
    private String grandFather;
    private String bloodPercent;
    private Blob img;

    public Bowvine(){

    }
    public Bowvine(long id, String type, Date borndate, String race, String bowvinecol,
                   String sex, String coat, long ownerId, String grandFather,
                   String bloodPercent, Blob img) {
        this.id = id;
        this.type = type;
        this.borndate = borndate;
        this.race = race;
        this.bowvinecol = bowvinecol;
        this.sex = sex;
        this.coat = coat;
        this.ownerId = ownerId;
        this.grandFather = grandFather;
        this.bloodPercent = bloodPercent;
        this.img = img;
    }

    public Bowvine( String type, Date borndate, String race, String bowvinecol,
                    String sex, String coat, long ownerId, String grandFather, String bloodPercent, Blob img) {
        this.type = type;
        this.borndate = borndate;
        this.race = race;
        this.bowvinecol = bowvinecol;
        this.sex = sex;
        this.coat = coat;
        this.ownerId = ownerId;
        this.grandFather = grandFather;
        this.bloodPercent = bloodPercent;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBowvinecol() {
        return bowvinecol;
    }

    public void setBowvinecol(String bowvinecol) {
        this.bowvinecol = bowvinecol;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public long getOwner_id() {
        return ownerId;
    }

    public void setOwner_id(long owner_id) {
        this.ownerId = owner_id;
    }

    public String getGrand_father() {
        return grandFather;
    }

    public void setGrand_father(String grand_father) {
        this.grandFather = grand_father;
    }

    public String getBlood_percent() {
        return bloodPercent;
    }

    public void setBlood_percent(String blood_percent) {
        this.bloodPercent = blood_percent;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Bowvine{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", borndate=" + borndate +
                ", race='" + race + '\'' +
                ", bowvinecol='" + bowvinecol + '\'' +
                ", sex='" + sex + '\'' +
                ", coat='" + coat + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", grandFather='" + grandFather + '\'' +
                ", bloodPercent='" + bloodPercent + '\'' +
                ", img=" + img +
                '}';
    }
}
