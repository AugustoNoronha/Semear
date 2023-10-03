package com.example.demo.Project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
@Entity
@Table(name = AddressToGo.TABLE_NAME)

public class AddressToGo {
    public interface CreateAddress {}
    public interface  UpdateAddress{}
    public static final String TABLE_NAME = "address";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "postal_code", length=50, nullable = false)
    @NotNull(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class})
    @Size(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class}, min = 2, max = 50)
    private String PostalCode;
    @Column(name = "street", length=50, nullable = false)
    @NotNull(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class})
    @Size(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class}, min = 2, max = 50)
    private String Street;
    @Column(name = "number", nullable = false)
    @NotNull(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class})
    @Size(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class}, min = 2, max = 50)
    private int Number;
    @Column(name = "state", length=50, nullable = false)
    @NotNull(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class})
    @Size(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class}, min = 2, max = 50)
    private String State;
    @Column(name = "city", length=50, nullable = false)
    @NotNull(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class})
    @Size(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class}, min = 2, max = 50)
    private String City;
    @Column(name = "neighborhood", length=50, nullable = false)
    @NotNull(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class})
    @Size(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class}, min = 2, max = 50)
    private String Neighborhood;
    @Column(name = "additional_field", length=50, nullable = false)
    @NotNull(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class})
    @Size(groups = {AddressToGo.CreateAddress.class, AddressToGo.UpdateAddress.class}, min = 2, max = 50)
    private String AdditionalField;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    public AddressToGo() {
    }

    public AddressToGo(Long id, String postalCode, String street, int number, String state, String city, String neighborhood, String additionalField) {
        this.id = id;
        PostalCode = postalCode;
        Street = street;
        Number = number;
        State = state;
        City = city;
        Neighborhood = neighborhood;
        AdditionalField = additionalField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getNeighborhood() {
        return Neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        Neighborhood = neighborhood;
    }

    public String getAdditionalField() {
        return AdditionalField;
    }

    public void setAdditionalField(String additionalField) {
        AdditionalField = additionalField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressToGo address)) return false;
        return getNumber() == address.getNumber() && Objects.equals(getId(), address.getId()) && Objects.equals(getPostalCode(), address.getPostalCode()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getState(), address.getState()) && Objects.equals(getCity(), address.getCity()) && Objects.equals(getNeighborhood(), address.getNeighborhood()) && Objects.equals(getAdditionalField(), address.getAdditionalField());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPostalCode(), getStreet(), getNumber(), getState(), getCity(), getNeighborhood(), getAdditionalField());
    }
}
