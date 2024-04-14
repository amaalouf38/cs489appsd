package edu.miu.cs489.tsogt.lab_6.service.impl;

import edu.miu.cs489.tsogt.lab_6.model.Address;
import edu.miu.cs489.tsogt.lab_6.repository.AddressRepository;
import edu.miu.cs489.tsogt.lab_6.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }
}
