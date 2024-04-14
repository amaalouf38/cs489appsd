package edu.miu.cs489.tsogt.lab_6.service;

import edu.miu.cs489.tsogt.lab_6.model.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> findAll();

    Surgery findById(Integer id);

    Surgery save(Surgery surgery);

    void delete(Surgery surgery);
}
