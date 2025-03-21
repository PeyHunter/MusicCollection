package com.example.musiccollection.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Address
{

    @Id
    @GeneratedValue
    private int addressId; // Unique identifier for the address

    private String street;
    private String city;
    private String postalCode;
    private String country;

    // Default constructor
    public Address()
    {
    }

    // Constructor with all fields
    public Address(String street, String city, String postalCode, String country)
    {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    // Getters and setters for each field
    public int getAddressId()
    {
        return addressId;
    }

    public void setAddressId(int addressId)
    {
        this.addressId = addressId;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}
