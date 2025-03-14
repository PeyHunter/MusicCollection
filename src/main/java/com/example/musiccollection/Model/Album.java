package com.example.musiccollection.Model;

public class Album
{
    private int album_id;
    private String title;
    private int release_year;
    private int artist_id;
    private int label_id;

    public Album()
    {}

    //MED ALBUM ID CONSTRUCTOREN
    public Album(int album_id, String title, int release_year, int artist_id, int label_id) {
        this.album_id = album_id;
        this.title = title;
        this.release_year = release_year;
        this.artist_id = artist_id;
        this.label_id = label_id;
    }

    //UDEN ALBUM ID CONSTRUCTOREN
    public Album(String title, int release_year, int artist_id, int label_id)
    {
        this.title = title;
        this.release_year = release_year;
        this.artist_id = artist_id;
        this.label_id = label_id;
    }

    public String getTitle()
    {
        return title;
    }

    public int getRelease_year()
    {
        return release_year;
    }

    public int getArtist_id()
    {
        return artist_id;
    }

    public int getLabel_id()
    {
        return label_id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setRelease_year(int release_year)
    {
        this.release_year = release_year;
    }

    public void setArtist_id(int artist_id)
    {
        this.artist_id = artist_id;
    }

    public void setLabel_id(int label_id)
    {
        this.label_id = label_id;
    }
}
