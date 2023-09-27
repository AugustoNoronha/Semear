package com.example.demo.Project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = Addres.TABLE_NAME)

public class Addres {
    public static final String TABLE_NAME = "addres";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "postal_code", length=50, nullable = false)
    @NotNull(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class})
    @Size(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class}, min = 2, max = 50)
    private String PostalCode;
    @Column(name = "street", length=50, nullable = false)
    @NotNull(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class})
    @Size(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class}, min = 2, max = 50)
    private String Street;
    @Column(name = "number", nullable = false)
    @NotNull(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class})
    @Size(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class}, min = 2, max = 50)
    private int Number;
    @Column(name = "state", length=50, nullable = false)
    @NotNull(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class})
    @Size(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class}, min = 2, max = 50)
    private String State;
    @Column(name = "city", length=50, nullable = false)
    @NotNull(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class})
    @Size(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class}, min = 2, max = 50)
    private String City;
    @Column(name = "neighborhood", length=50, nullable = false)
    @NotNull(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class})
    @Size(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class}, min = 2, max = 50)
    private String Neighborhood;
    @Column(name = "additional_field", length=50, nullable = false)
    @NotNull(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class})
    @Size(groups = {Bowvine.CreateBowvine.class, Bowvine.UpdateBowvine.class}, min = 2, max = 50)
    private String AdditionalField;

}
