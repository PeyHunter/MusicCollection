package com.example.musiccollection.Model;

public class Address
{
    private String street;
    private String city;
    private int postal_code;
    private String country;

    public Address(String street, String city, int postal_code, String country)
    {
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    public String getStreet()
    {
        return street;
    }

    public String getCity()
    {
        return city;
    }

    public int getPostal_code()
    {
        return postal_code;
    }

    public String getCountry()
    {
        return country;
    }
}
