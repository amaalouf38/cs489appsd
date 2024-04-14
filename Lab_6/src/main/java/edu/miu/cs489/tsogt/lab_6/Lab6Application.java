package edu.miu.cs489.tsogt.lab_6;

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

                        Address address1 = new Address(1, "123 Main St", "New York", "NY", "10001", null);
                        Address address2 = new Address(2, "456 Park Ave", "Los Angeles", "CA",
                                        "90001", null);
                        Address address3 = new Address(3, "789 Broadway", "Chicago", "IL", "60601", null);
                        Address address4 = new Address(4, "101 Elm St", "Houston", "TX", "77001", null);
                        Address address5 = new Address(5, "202 Cedar Ln", "Phoenix", "AZ", "85001", null);
                        Address address6 = new Address(6, "303 Pine Rd", "Philadelphia", "PA",
                                        "19101", null);
                        Address address7 = new Address(7, "404 Willow Ave", "San Antonio", "TX",
                                        "78201", null);

                        addressRepository.saveAll(Arrays.asList(address1, address2, address3,
                                        address4, address5, address6, address7));

                        Dentist dentist1 = new Dentist(1, "Tony", "Smith", "123-456-7890",
                                        "tony.smith@gmail.com", "Spec1", null);
                        Dentist dentist2 = new Dentist(2, "Helen", "Pearson", "123-123-7890",
                                        "helen.pearson@gmail.com", "Spec2", null);
                        Dentist dentist3 = new Dentist(3, "Robin", "Plevin", "123-789-7810",
                                        "robin.plevin@gmail.com", "Spec3", null);

                        dentistRepository.saveAll(Arrays.asList(dentist1, dentist2, dentist3));

                        Patient patient1 = new Patient("P100", "Gillian", "White", "987-654-3210",
                                        "gillian.white@gmail.com",
                                        "01-Sep-1999", null, address1);
                        Patient patient2 = new Patient("P105", "Jill", "Bell", "431-231-5412",
                                        "jill.bell@gmail.com", "01-Oct-1999",
                                        null, address2);
                        Patient patient3 = new Patient("P108", "Ian", "MackKay", "902-231-5412",
                                        "ian.bmackey@gmail.com", "01-Oct-1999",
                                        null, address3);
                        Patient patient4 = new Patient("P110", "John", "Walker", "202-431-5412",
                                        "john.walker@gmail.com", "01-Oct-1989",
                                        null, address4);

                        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3,
                                        patient4));

                        Surgery surgery1 = new Surgery("S15", "Clinic One", "432-231-6809", null,
                                        address5);
                        Surgery surgery2 = new Surgery("S10", "Clinic Two", "432-231-6129", null,
                                        address6);
                        Surgery surgery3 = new Surgery("S13", "Clinic Three", "432-231-6309", null,
                                        address7);

                        surgeryRepository.saveAll(Arrays.asList(surgery1, surgery2, surgery3));

                        List<Appointment> appointments = Arrays.asList(
                                        new Appointment(1, patient1, dentist1, surgery1, "12-Sep-13", 10.00),
                                        new Appointment(2, patient2, dentist1, surgery1, "12-Sep-13", 12.00),
                                        new Appointment(3, patient3, dentist2, surgery2, "12-Sep-13", 10.00),
                                        new Appointment(4, patient3, dentist2, surgery2, "14-Sep-13", 14.00),
                                        new Appointment(5, patient2, dentist3, surgery1, "14-Sep-13", 16.30),
                                        new Appointment(6, patient4, dentist3, surgery3, "15-Sep-13", 18.00));

                        appointmentRepository.saveAll(appointments);

                        patient1.setAppointmentList(Arrays.asList(appointments.get(0)));
                        patient2.setAppointmentList(Arrays.asList(appointments.get(1),
                                        appointments.get(4)));
                        patient3.setAppointmentList(Arrays.asList(appointments.get(2),
                                        appointments.get(3)));
                        patient4.setAppointmentList(Arrays.asList(appointments.get(5)));

                        dentist1.setAppointments(Arrays.asList(appointments.get(0),
                                        appointments.get(1)));
                        dentist2.setAppointments(Arrays.asList(appointments.get(2),
                                        appointments.get(3)));
                        dentist3.setAppointments(Arrays.asList(appointments.get(4),
                                        appointments.get(5)));

                        surgery1.setAppointments(Arrays.asList(appointments.get(0),
                                        appointments.get(1), appointments.get(4)));
                        surgery2.setAppointments(Arrays.asList(appointments.get(2),
                                        appointments.get(3)));
                        surgery3.setAppointments(Arrays.asList(appointments.get(5)));

                        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3,
                                        patient4));
                        dentistRepository.saveAll(Arrays.asList(dentist1, dentist2, dentist3));
                        surgeryRepository.saveAll(Arrays.asList(surgery1, surgery2, surgery3));
                };
        }
}
