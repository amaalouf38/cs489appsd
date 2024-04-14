package edu.miu.cs489.tsogt.lab_6.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.tsogt.lab_6.model.Appointment;
import edu.miu.cs489.tsogt.lab_6.service.AppointmentService;
import jakarta.validation.Valid;

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

    @GetMapping(value = "/list/{street_address}")
    public ResponseEntity<List<Appointment>> listAppointmentsByStreetAddress(@PathVariable String street_address) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByStreetAddress(street_address));
    }

    @GetMapping(value = "/list/bydate/{appointment_date}/{page_number}/{page_size}")
    public ResponseEntity<Page<Appointment>> listAppointmentsByDateJPQL(
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate appointment_date,
            @PathVariable int page_number, @PathVariable int page_size) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDate(appointment_date, page_number, page_size));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Appointment> saveAppointment(@RequestBody @Valid Appointment apt) {
        return new ResponseEntity<>(appointmentService.addAppointment(apt), HttpStatus.CREATED);
    }

}