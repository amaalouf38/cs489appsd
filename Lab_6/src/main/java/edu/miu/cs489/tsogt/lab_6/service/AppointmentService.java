package edu.miu.cs489.tsogt.lab_6.service;

import edu.miu.cs489.tsogt.lab_6.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAppointments();
    Appointment addAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    Appointment getAppointment(int id);
}
