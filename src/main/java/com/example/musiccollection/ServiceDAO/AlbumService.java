package com.example.musiccollection.ServiceDAO;

import com.example.musiccollection.Model.Album;
import com.example.musiccollection.Repository.AlbumRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumService
{
    private AlbumRepository albumRepository;

    public void addAlbum(Album album)
    {
        if (album.getTitle() == null || album.getTitle().isEmpty())
        {
            throw new IllegalArgumentException("Album title cannot be empty");
        }
        albumRepository.addAlbum(album);
    }


}
