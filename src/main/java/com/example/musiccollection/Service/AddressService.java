package com.example.musiccollection.Service;

import com.example.musiccollection.Model.Address;
import com.example.musiccollection.Model.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.musiccollection.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService
{

    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    AddressRepository addressRepository;

    public List<Address> fetchAllAddress()
    {
        return addressRepository.fetchAllAddress();
    }

    public void addAddress(Address address)
    {
        try
        {
            if (address.getStreet() == null || address.getStreet().isEmpty())
            {
                throw new IllegalArgumentException("Album title cannot be empty");
            }
            addressRepository.addAddress(address);
            logger.info("Address added:" + address.getStreet());

        } catch (Exception e)
        {
            logger.error("Error adding address: " + e.getMessage());
            throw new RuntimeException("Failed to add Address", e);
        }
    }


    public Address findAddressById(int addressId)
    {
        return addressRepository.findAddressById(addressId);
    }

    public void updateAddress(Address address)
    {
        addressRepository.updateAddress(address);
    }

    public boolean deleteAddress(int addressId)
    {
        return addressRepository.deleteAddress(addressId);
    }

}
