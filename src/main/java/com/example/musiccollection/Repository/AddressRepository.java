package com.example.musiccollection.Repository;

import com.example.musiccollection.Model.Address;
import com.example.musiccollection.Model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Address> fetchAllAddress()
    {
        String sql = "SELECT * FROM Address";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Address.class));
    }

    public Address findAddressById(int id)
    {
        String sql = "SELECT * FROM Address WHERE address_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Address.class), id);
    }

    public void addAddress(Address address)
    {
        String sql =  "INSERT INTO Address (street, city, postalCode, country) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getPostalCode(), address.getCountry());
    }

    public void updateAddress(Address address)
    {
        String sql = "UPDATE Address SET street = ?, city = ?, postalCode = ?, country = ? WHERE address_id = ?";
        jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getPostalCode(), address.getCountry(), address.getAddressId());
    }

    public boolean deleteAddress(int addressId)
    {
        String sql = "DELETE FROM Address WHERE address_id = ?";
        return jdbcTemplate.update(sql, addressId) > 0;
    }


}
