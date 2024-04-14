package edu.miu.cs489.tsogt.lab_6.service.impl;

import edu.miu.cs489.tsogt.lab_6.model.Surgery;
import edu.miu.cs489.tsogt.lab_6.repository.SurgeryRepository;
import edu.miu.cs489.tsogt.lab_6.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {

        private SurgeryRepository surgeryRepository;

        public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
            this.surgeryRepository = surgeryRepository;
        }

    @Override
    public List<Surgery> findAll() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery findById(String id) {
        return surgeryRepository.findById(id).orElse(null);
    }

    @Override
    public Surgery save(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public void delete(Surgery surgery) {
        surgeryRepository.delete(surgery);
    }
}
