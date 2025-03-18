package com.example.musiccollection.Model;

public class Address
{
    private int addressId;
    private String street;
    private String city;
    private int postalCode;
    private String country;

    public Address(){}

    public Address(int addressId, String street, String city, int postalCode, String country)
    {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(String street, String city, int postalCode, String country)
    {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getAddressId()
    {
        return addressId;
    }

    public String getStreet()
    {
        return street;
    }

    public String getCity()
    {
        return city;
    }

    public int getPostalCode()
    {
        return postalCode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setAddressId(int addressId)
    {
        this.addressId = addressId;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setPostalCode(int postalCode)
    {
        this.postalCode = postalCode;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}
