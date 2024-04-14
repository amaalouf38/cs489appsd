package edu.miu.cs489.tsogt.lab_6.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Appointment")
@Data
public class Appointment {
    @Id
    private int id;
    @JsonIgnore
    @ManyToOne
    private Patient patient;
    @JsonIgnore
    @ManyToOne
    private Dentist dentist;
    @JsonIgnore
    @ManyToOne
    private Surgery surgery;
    private String appointmentDate;
    private Double appointmentTime;
}
