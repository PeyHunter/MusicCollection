package com.example.musiccollection.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.musiccollection.Model.Album;
import com.example.musiccollection.Repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService
{
    private static final Logger logger = LoggerFactory.getLogger(AlbumService.class);

    @Autowired
    AlbumRepository albumRepository;

    public List<Album> fetchAllAlbum()
    {
        return albumRepository.fetchAllAlbum();
    }


    public void addAlbum(Album album)
    {
        try
        {


            if (album.getTitle() == null || album.getTitle().isEmpty())
            {
                throw new IllegalArgumentException("Album title cannot be empty");
            }
            albumRepository.addAlbum(album);
            logger.info("Album added:" + album.getTitle());
        } catch (Exception e)
        {
            logger.error("Error adding album: " + e.getMessage());
            throw new RuntimeException("Failed to add Album", e);

        }
    }

    public Album findAlbumById(int albumId)
    {
        return albumRepository.findAlbumById(albumId);
    }

    public void updateAlbum(Album album)
    {
        albumRepository.updateAlbum(album);
    }

    public boolean deleteAlbum(int albumId)
    {
        return albumRepository.deleteAlbum(albumId);
    }



}
