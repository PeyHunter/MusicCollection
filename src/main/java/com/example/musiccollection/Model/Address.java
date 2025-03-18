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

    public void setStreet(String street)
    {
        this.street = street;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setPostal_code(int postal_code)
    {
        this.postal_code = postal_code;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}
