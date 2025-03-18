package com.example.musiccollection.Service;

import com.example.musiccollection.Model.Album;
import com.example.musiccollection.Model.Artist;
import com.example.musiccollection.Repository.AlbumRepository;
import com.example.musiccollection.Repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService
{
    @Autowired
    ArtistRepository artistRepository;

    public List<Artist> fetchAll()
    {
        return artistRepository.fetchAll();
    }




}
