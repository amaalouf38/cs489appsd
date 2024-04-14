package edu.miu.cs489.tsogt.lab_6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Surgery")
public class Surgery {
    @Id
    private String id;
    private String name;
    private String telephoneNumber;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
    @OneToOne
    private Address address;

}
