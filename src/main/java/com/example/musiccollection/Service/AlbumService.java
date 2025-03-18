package com.example.musiccollection.Service;

import com.example.musiccollection.Model.Album;
import com.example.musiccollection.Repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService
{
    @Autowired
    AlbumRepository albumRepository;

    public List<Album> fetchAllAlbum()
    {
        return albumRepository.fetchAllAlbum();
    }


    public void addAlbum(Album album)
    {
        if (album.getTitle() == null || album.getTitle().isEmpty())
        {
            throw new IllegalArgumentException("Album title cannot be empty");
        }
        albumRepository.addAlbum(album);
    }

    public Album findAlbumById(int albumId){
        return albumRepository.findAlbumById(albumId);
    }

    public boolean deleteAlbum(int albumId)
    {
        return albumRepository.deleteAlbum(albumId) ;
    }







/*



    public Boolean deletePerson(int id){
        return personRepo.deletePerson(id);
    }

    public void updatePerson(Person p){
        personRepo.updatePerson(p);
    }*/



}
