package edu.miu.cs489.tsogt.lab_6.service.impl;

import edu.miu.cs489.tsogt.lab_6.model.Appointment;
import edu.miu.cs489.tsogt.lab_6.repository.AppointmentRepository;
import edu.miu.cs489.tsogt.lab_6.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Page<Appointment> getAppointmentsByDate(LocalDate date, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("appointmentTime"));
        Page<Appointment> retVal = appointmentRepository.findByAppointmentDate(date, pageRequest);
        return retVal;
    }

    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAppointmentsByStreetAddress(String street_address) {
        return appointmentRepository.findByStreetAddress(street_address);
    }

    @Override
    public List<Appointment> getAppointmentsByDateJPQL(LocalDate street_address) {
        List<Appointment> retVal = appointmentRepository.findByApppointmentDateJPQL3(street_address);
        return retVal;
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        this.appointmentRepository.delete(appointment);
    }

    @Override
    public Appointment getAppointment(Integer id) {
        return appointmentRepository.findById(id).orElse(null);
    }
}
