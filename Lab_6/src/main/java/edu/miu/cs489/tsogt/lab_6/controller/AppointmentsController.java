package edu.miu.cs489.tsogt.lab_6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.tsogt.lab_6.model.Appointment;
import edu.miu.cs489.tsogt.lab_6.service.AppointmentService;

@RequestMapping("/appointments")
@RestController
public class AppointmentsController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentsController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Appointment>> listAppointments() {
        return ResponseEntity.ok(appointmentService.getAppointments());
    }

}