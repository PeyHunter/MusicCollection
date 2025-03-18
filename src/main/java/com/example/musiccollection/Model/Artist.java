package com.example.musiccollection.Model;

public class Artist
{
    private int artistId;
    private String name;
    private int address;

    public Artist()
    {}

    public Artist(int artistId, String name, int address)
    {
        this.artistId = artistId;
        this.name = name;
        this.address = address;
    }

    public Artist(String name, int address)
    {
        this.name = name;
        this.address = address;
    }

    public int getArtistId()
    {
        return artistId;
    }

    public String getName()
    {
        return name;
    }

    public int getAddressId()
    {
        return address;
    }

    public void setArtistId(int artistId)
    {
        this.artistId = artistId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddressId(int address)
    {
        this.address = address;
    }
}

