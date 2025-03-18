package com.example.musiccollection.Model;

public class ArtistLabel
{

    private int artistId;
    private int labelId;
    private int signYear;

    public ArtistLabel(){}


    public ArtistLabel(int artistId, int labelId, int signYear)
    {
        this.artistId = artistId;
        this.labelId = labelId;
        this.signYear = signYear;
    }

    public int getArtistId()
    {
        return artistId;
    }

    public int getLabelId()
    {
        return labelId;
    }

    public int getSignYear()
    {
        return signYear;
    }

    public void setArtistId(int artistId)
    {
        this.artistId = artistId;
    }

    public void setLabelId(int labelId)
    {
        this.labelId = labelId;
    }

    public void setSignYear(int signYear)
    {
        this.signYear = signYear;
    }
}
