package edu.miu.cs489.tsogt.lab_6.service;

import edu.miu.cs489.tsogt.lab_6.model.Appointment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;

public interface AppointmentService {
    List<Appointment> getAppointments();

    List<Appointment> getAppointmentsByStreetAddress(String street_address);

    List<Appointment> getAppointmentsByDateJPQL(LocalDate street_address);

    Page<Appointment> getAppointmentsByDate(LocalDate date, int page, int size);

    Appointment addAppointment(Appointment appointment);

    Appointment updateAppointment(Appointment appointment);

    void deleteAppointment(Appointment appointment);

    Appointment getAppointment(Integer id);
}
