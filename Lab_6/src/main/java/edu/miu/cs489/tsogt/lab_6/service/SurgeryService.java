package edu.miu.cs489.tsogt.lab_6.service;

import edu.miu.cs489.tsogt.lab_6.model.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> findAll();
    Surgery findById(String id);
    Surgery save(Surgery surgery);
    void delete(Surgery surgery);
}
