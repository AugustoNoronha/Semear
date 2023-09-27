package com.example.demo.Project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public interface CreateUser{}
    public interface UpdateUser{}
    public static final String TABLE_NAME = "owner";

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long Id;
    @Column(name = "name", length=50, nullable = false)
    @NotNull(groups = {User.CreateUser.class, User.UpdateUser.class})
    @Size(groups = {User.CreateUser.class, User.UpdateUser.class}, min = 2, max = 50)
    private String Name;
    @Column(name = "email", length=50, nullable = false)
    @NotNull(groups = {User.CreateUser.class, User.UpdateUser.class})
    @Size(groups = {User.CreateUser.class, User.UpdateUser.class}, min = 2, max = 50)
    private String Email;
    @Column(name = "document_number", length=50, nullable = false)
    @NotNull(groups = {User.CreateUser.class, User.UpdateUser.class})
    @Size(groups = {User.CreateUser.class, User.UpdateUser.class}, min = 2, max = 50)
    private String DocumentNumber;
    @Column(name = "cell_number", length=50, nullable = false)
    @NotNull(groups = {User.CreateUser.class, User.UpdateUser.class})
    @Size(groups = {User.CreateUser.class, User.UpdateUser.class}, min = 2, max = 50)
    private String CellNumber;
    @Column(name = "id_address", length=50, nullable = false)
    @NotNull(groups = {User.CreateUser.class, User.UpdateUser.class})
    @Size(groups = {User.CreateUser.class, User.UpdateUser.class}, min = 2, max = 50)
    private Long IdAddress;

    public User() {
    }

    public User(Long id, String name, String email, String documentNumber, String cellNumber,Long idAddress) {
        Id = id;
        Name = name;
        Email = email;
        DocumentNumber = documentNumber;
        CellNumber = cellNumber;
        IdAddress = idAddress;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Long getAddress() {
        return IdAddress;
    }

    public void setAddress(long idAddress) {
        IdAddress = idAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User owner)) return false;
        return Objects.equals(getId(), owner.getId()) && Objects.equals(getName(), owner.getName()) && Objects.equals(getEmail(), owner.getEmail()) && Objects.equals(getDocumentNumber(), owner.getDocumentNumber()) && Objects.equals(getCellNumber(), owner.getCellNumber()) && Objects.equals(getAddress(), owner.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getDocumentNumber(), getCellNumber(), getAddress());
    }
}
