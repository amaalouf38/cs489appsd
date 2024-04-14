package edu.miu.cs489.tsogt.lab_6.service;

import edu.miu.cs489.tsogt.lab_6.model.Patient;

import javax.swing.*;
import java.util.List;

public interface PatientService {
    List<Patient> getPatients();
    Patient getPatient(String id);
    Patient addPatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
