package com.example.demo.Project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public interface CreateUser {}
    public interface  UpdateUser{}
    public static final String TABLE_NAME = "user";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "name", length=50, nullable = false)
    @NotNull(groups = {User.CreateUser.class, User.UpdateUser.class})
    @Size(groups = {User.CreateUser.class, User.UpdateUser.class}, min = 10, max = 50)
    private String Name;

    @Column(name = "email", length=10, nullable = false)
    @NotNull(groups = {User.CreateUser.class, User.UpdateUser.class})
    @Size(groups = {User.CreateUser.class, User.UpdateUser.class}, min = 10, max = 70)
    private String Email;
    @Column(name = "document_number", length=50, nullable = false)
    @NotNull(groups = {User.CreateUser.class, User.UpdateUser.class})
    @Size(groups = {User.CreateUser.class, User.UpdateUser.class}, min = 11, max = 14)
    private String DocumentNumber;
    @Column(name = "cell_number", nullable = false)
    @NotNull(groups = {User.CreateUser.class, User.UpdateUser.class})
    @Size(groups = {User.CreateUser.class, User.UpdateUser.class}, min = 8, max = 11)
    private String CellNumber;

    @OneToMany(mappedBy = "user")
    private List<Bowvine> Bowvines = new ArrayList<Bowvine>();

    @OneToOne(mappedBy = "user")
    private com.example.demo.Project.models.Address Address = new Address();
    public User() {
    }

    public User(Long id, String name, String email, String documentNumber, String cellNumber) {
        this.id = id;
        Name = name;
        Email = email;
        DocumentNumber = documentNumber;
        CellNumber = cellNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }

    public String getCellNumber() {
        return CellNumber;
    }

    public void setCellNumber(String cellNumber) {
        CellNumber = cellNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getDocumentNumber(), user.getDocumentNumber()) && Objects.equals(getCellNumber(), user.getCellNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getDocumentNumber(), getCellNumber());
    }
}
