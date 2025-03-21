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
    private Artist artist;
    private RecordLabel recordLabel;

    public Album()
    {
    }

    public Album(String title, int releaseYear, int artistId, int labelId)
    {

        this.title = title;
        this.releaseYear = releaseYear;
        this.artistId = artistId;
        this.labelId = labelId;
    }


    public Album(int albumId, String title, int releaseYear, int artistId, int labelId)
    {
        this.albumId = albumId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.artistId = artistId;
        this.labelId = labelId;
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

    public Artist getArtist()
    {
        return artist;
    }

    public RecordLabel getRecordLabel()
    {
        return recordLabel;
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

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setRecordLabel(RecordLabel recordLabel) {
        this.recordLabel = recordLabel;
    }
}