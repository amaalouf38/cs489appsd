package edu.miu.cs489.tsogt.lab_6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.tsogt.lab_6.model.Patient;
import edu.miu.cs489.tsogt.lab_6.service.PatientService;

@RequestMapping("/patients")
@RestController
public class PatientController {
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Patient>> listPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

}
