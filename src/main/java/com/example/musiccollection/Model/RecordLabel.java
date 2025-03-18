package com.example.musiccollection.Model;

public class RecordLabel
{

    private int labelId;
    private String name;
    private int addressId;


    public RecordLabel()
    {}

    public RecordLabel(int labelId, String name, int addressId)
    {
        this.labelId = labelId;
        this.name = name;
        this.addressId = addressId;
    }

    public int getLabelId()
    {
        return labelId;
    }

    public String getName()
    {
        return name;
    }

    public int getAddressId()
    {
        return addressId;
    }

    public void setLabelId(int labelId)
    {
        this.labelId = labelId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddressId(int addressId)
    {
        this.addressId = addressId;
    }
}

