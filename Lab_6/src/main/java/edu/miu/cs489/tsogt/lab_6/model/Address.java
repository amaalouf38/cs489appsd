package edu.miu.cs489.tsogt.lab_6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address {
    @Id
    private int id;
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Patient patient;
}
