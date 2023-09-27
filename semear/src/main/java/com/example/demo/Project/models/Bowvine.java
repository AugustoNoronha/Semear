package com.example.demo.Project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name = Bowvine.TABLE_NAME)
public class Bowvine {

    public interface CreateBowvine {}
    public interface  UpdateBowvine{}
    public static final String TABLE_NAME = "bowvine";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "type", length=50, nullable = false)
    @NotNull(groups = {CreateBowvine.class, UpdateBowvine.class})
    @Size(groups = {CreateBowvine.class, UpdateBowvine.class}, min = 2, max = 50)
    private String Type;

    @Column(name = "born_date", length=10, nullable = false)
    @NotNull(groups = {CreateBowvine.class, UpdateBowvine.class})
    @Size(groups = {CreateBowvine.class, UpdateBowvine.class}, min = 2, max = 10)
    private String BornDate;
    @Column(name = "race", length=50, nullable = false)
    @NotNull(groups = {CreateBowvine.class, UpdateBowvine.class})
    @Size(groups = {CreateBowvine.class, UpdateBowvine.class}, min = 2, max = 50)
    private String Race;
    @Column(name = "weight", nullable = false)
    @NotNull(groups = {CreateBowvine.class, UpdateBowvine.class})
    private Float Weight;
    @Column(name = "sex", length=1, nullable = false)
    @NotNull(groups = CreateBowvine.class)
    private String Sex;
    @Column(name = "coat", length=50, nullable = false)
    @NotNull(groups = CreateBowvine.class)
    @Size(groups = CreateBowvine.class, min = 2, max = 50)
    private String Coat;
    @Column(name = "Id_owner", nullable = false)
    @NotNull(groups = CreateBowvine.class)
    private Long IdOwner;
    @Column(name = "grand_father", length=100, nullable = false)
    @NotNull(groups = CreateBowvine.class)
    @Size(groups = CreateBowvine.class, min = 2, max = 100)
    private String GrandFather;
    @Column(name = "blood_percent", length=50, nullable = false)
    @NotNull(groups = CreateBowvine.class)
    private Float BloodPercent;
    @Column(name = "image", length=50)
    private Blob Image;

    public Bowvine() {

    }

    public Bowvine(Long id, String type, String bornDate, String race, Float weight, String sex, String coat, Long idOwner, String grandFather, Float bloodPercent, Blob image) {
        this.id = id;
        Type = type;
        BornDate = bornDate;
        Race = race;
        Weight = weight;
        Sex = sex;
        Coat = coat;
        IdOwner = idOwner;
        GrandFather = grandFather;
        BloodPercent = bloodPercent;
        Image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBornDate() {
        return BornDate;
    }

    public void setBornDate(String bornDate) {
        BornDate = bornDate;
    }

    public String getRace() {
        return Race;
    }

    public void setRace(String race) {
        Race = race;
    }

    public Float getWeight() {
        return Weight;
    }

    public void setWeight(Float weight) {
        Weight = weight;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getCoat() {
        return Coat;
    }

    public void setCoat(String coat) {
        Coat = coat;
    }

    public Long getIdOwner() {
        return IdOwner;
    }

    public void setIdOwner(Long idOwner) {
        IdOwner = idOwner;
    }

    public String getGrandFather() {
        return GrandFather;
    }

    public void setGrandFather(String grandFather) {
        GrandFather = grandFather;
    }

    public Float getBloodPercent() {
        return BloodPercent;
    }

    public void setBloodPercent(Float bloodPercent) {
        BloodPercent = bloodPercent;
    }

    public Blob getImage() {
        return Image;
    }

    public void setImage(Blob image) {
        Image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bowvine bowvine)) return false;
        return Objects.equals(getId(), bowvine.getId()) && Objects.equals(getType(), bowvine.getType()) && Objects.equals(getBornDate(), bowvine.getBornDate()) && Objects.equals(getRace(), bowvine.getRace()) && Objects.equals(getWeight(), bowvine.getWeight()) && Objects.equals(getSex(), bowvine.getSex()) && Objects.equals(getCoat(), bowvine.getCoat()) && Objects.equals(getIdOwner(), bowvine.getIdOwner()) && Objects.equals(getGrandFather(), bowvine.getGrandFather()) && Objects.equals(getBloodPercent(), bowvine.getBloodPercent()) && Objects.equals(getImage(), bowvine.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getBornDate(), getRace(), getWeight(), getSex(), getCoat(), getIdOwner(), getGrandFather(), getBloodPercent(), getImage());
    }
}
