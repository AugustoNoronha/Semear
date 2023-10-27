package com.example.demo.Project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = Owner.TABLE_NAME)
public class Owner {

    public interface CreateOwner {}
    public interface  UpdateOwner{}
    public static final String TABLE_NAME = "owner";

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long Id;
    @Column(name = "cell_number", length=11, nullable = false)
    @NotNull(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class})
    @Size(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class}, min = 11, max = 11)
    private String CellNumber;
    @Column(name = "document_number", length=11, nullable = false)
    @NotNull(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class})
    @Size(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class}, min = 11, max = 14)
    private String DocumentNumber;
    @Column(name = "email", length=50, nullable = false)
    @NotNull(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class})
    @Size(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class}, min = 10, max = 50)
    private String Email;
    @Column(name = "name", length=50, nullable = false)
    @NotNull(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class})
    @Size(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class}, min = 5, max = 50)
    private String Name;
    @Column(name = "password", length=50, nullable = false)
    @NotNull(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class})
    @Size(groups = {Owner.CreateOwner.class, Owner.CreateOwner.class}, min = 10, max = 50)
    private String Password;

    @OneToMany(mappedBy = "owner")
    private List<Bowvine> bowvines = new ArrayList<Bowvine>();

    public Owner(Long id, String cellNumber, String documentNumber, String email, String name, String password) {
        Id = id;
        CellNumber = cellNumber;
        DocumentNumber = documentNumber;
        Email = email;
        Name = name;
        Password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCellNumber() {
        return CellNumber;
    }

    public void setCellNumber(String cellNumber) {
        CellNumber = cellNumber;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<Bowvine> getBowvines() {
        return bowvines;
    }

    public void setBowvines(List<Bowvine> bowvines) {
        this.bowvines = bowvines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner owner)) return false;
        return Objects.equals(getId(), owner.getId()) && Objects.equals(getCellNumber(), owner.getCellNumber()) && Objects.equals(getDocumentNumber(), owner.getDocumentNumber()) && Objects.equals(getEmail(), owner.getEmail()) && Objects.equals(getName(), owner.getName()) && Objects.equals(getPassword(), owner.getPassword()) && Objects.equals(getBowvines(), owner.getBowvines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCellNumber(), getDocumentNumber(), getEmail(), getName(), getPassword(), getBowvines());
    }
}
