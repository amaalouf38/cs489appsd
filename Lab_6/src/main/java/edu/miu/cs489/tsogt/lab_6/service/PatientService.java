package edu.miu.cs489.tsogt.lab_6.service;

import edu.miu.cs489.tsogt.lab_6.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getPatients();

    Patient getPatient(Integer id);

    Patient addPatient(Patient patient);

    Patient updatePatient(Patient patient);

    void deletePatient(Patient patient);
}
