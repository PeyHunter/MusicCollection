package com.example.musiccollection.Model;

public class Album
{
    private int albumId;
    private String title;
    private int releaseYear;
    private String artistName;
    private String labelName;
    private int artistId;
    private int labelId;

    public Album()
    {
    }

    public Album(int albumId, String title, int releaseYear, String artistName, String labelName)
    {
        this.albumId = albumId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.artistName = artistName;
        this.labelName = labelName;
    }

    // Getters and Setters
    public int getAlbumId()
    {
        return albumId;
    }

    public int getArtistId()
    {
        return artistId;
    }

    public int getLabelId()
    {
        return labelId;
    }


    public String getTitle()
    {
        return title;
    }

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public String getArtistName()
    {
        return artistName;
    }


    public String getLabelName()
    {
        return labelName;
    }



    public void setAlbumId(int albumId)
    {
        this.albumId = albumId;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }

    public void setArtistName(String artistName)
    {
        this.artistName = artistName;
    }

    public void setLabelName(String labelName)
    {
        this.labelName = labelName;
    }
}
