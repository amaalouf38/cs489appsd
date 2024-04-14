package edu.miu.cs489.tsogt.lab_6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.miu.cs489.tsogt.lab_6.model.*;
import edu.miu.cs489.tsogt.lab_6.repository.*;

@SpringBootApplication
public class Lab6Application {

        public static void main(String[] args) {
                SpringApplication.run(Lab6Application.class, args);
        }

        @Bean
        CommandLineRunner run(DentistRepository dentistRepository,
                        PatientRepository patientRepository,
                        AppointmentRepository appointmentRepository,
                        SurgeryRepository surgeryRepository,
                        AddressRepository addressRepository) {
                return args -> {

                        Address address1 = new Address(null, "123 Man St", "New York", "NY", "10001", null);
                        Address address2 = new Address(null, "456 Park Ave", "Los Angeles", "CA", "90001", null);
                        Address address3 = new Address(null, "789 Broadway", "Chicago", "IL", "60601", null);
                        Address address4 = new Address(null, "101 Elm St", "Houston", "TX", "77001", null);
                        Address address5 = new Address(null, "202 Cedar Ln", "Phoenix", "AZ", "85001", null);
                        Address address6 = new Address(null, "303 Pine Rd", "Philadelphia", "PA", "19101", null);
                        Address address7 = new Address(null, "404 Willow Ave", "San Antonio", "TX", "78201", null);

                        Dentist dentist1 = new Dentist(null, "Tony", "Smith", "123-456-7890", "tony.smith@gmail.com",
                                        "Spec1", null);
                        Dentist dentist2 = new Dentist(null, "Helen", "Pearson", "123-123-7890",
                                        "helen.pearson@gmail.com",
                                        "Spec2", null);
                        Dentist dentist3 = new Dentist(null, "Robin", "Plevin", "123-789-7810",
                                        "robin.plevin@gmail.com",
                                        "Spec3", null);

                        Patient patient1 = new Patient(null, "Gillian", "White", "987-654-3210",
                                        "gillian.white@gmail.com", "01-Sep-1999", null, address1);
                        Patient patient2 = new Patient(null, "Jill", "Bell", "431-231-5412", "jill.bell@gmail.com",
                                        "01-Oct-1999", null, address2);
                        Patient patient3 = new Patient(null, "Ian", "MackKay", "902-231-5412",
                                        "ian.bmackey@gmail.com", "01-Oct-1999", null, address3);
                        Patient patient4 = new Patient(null, "John", "Walker", "202-431-5412",
                                        "john.walker@gmail.com", "01-Oct-1989", null, address4);

                        Surgery surgery1 = new Surgery(null, "Clinic One", "432-231-6809", null, address5);
                        Surgery surgery2 = new Surgery(null, "Clinic Two", "432-231-6129", null, address6);
                        Surgery surgery3 = new Surgery(null, "Clinic Three", "432-231-6309", null, address7);

                        List<Appointment> appointments = Arrays.asList(
                                        new Appointment(null, patient1, dentist1, surgery1, LocalDate.of(2013, 9, 12),
                                                        10.00),
                                        new Appointment(null, patient2, dentist1, surgery1, LocalDate.of(2013, 9, 12),
                                                        12.00),
                                        new Appointment(null, patient3, dentist2, surgery2, LocalDate.of(2013, 9, 12),
                                                        10.00),
                                        new Appointment(null, patient3, dentist2, surgery2, LocalDate.of(2013, 9, 14),
                                                        14.00),
                                        new Appointment(null, patient2, dentist3, surgery1, LocalDate.of(2013, 9, 14),
                                                        16.30),
                                        new Appointment(null, patient4, dentist3, surgery3, LocalDate.of(2013, 9, 14),
                                                        18.00));

                        appointmentRepository.saveAll(appointments);
                };
        }
}
