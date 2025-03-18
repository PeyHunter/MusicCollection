package com.example.musiccollection.Model;

import java.time.Duration;

public class Track
{
    private int trackId;
    private String title;
    private Duration time;
    private int albumId;

    public Track()
    {}

    public Track(int trackId, String title, Duration time, int albumId)
    {
        this.trackId = trackId;
        this.title = title;
        this.time = time;
        this.albumId = albumId;
    }

    public int getTrackId()
    {
        return trackId;
    }

    public String getTitle()
    {
        return title;
    }

    public Duration getTime()
    {
        return time;
    }

    public int getAlbumId()
    {
        return albumId;
    }

    public void setTrackId(int trackId)
    {
        this.trackId = trackId;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setTime(Duration time)
    {
        this.time = time;
    }

    public void setAlbumId(int albumId)
    {
        this.albumId = albumId;
    }
}
