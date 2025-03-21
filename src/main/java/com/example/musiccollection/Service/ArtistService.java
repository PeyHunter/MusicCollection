package com.example.musiccollection.Service;

import com.example.musiccollection.Model.Address;
import com.example.musiccollection.Model.Album;
import com.example.musiccollection.Model.Artist;
import com.example.musiccollection.Model.ArtistLabel;
import com.example.musiccollection.Repository.AlbumRepository;
import com.example.musiccollection.Repository.ArtistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ArtistService
{

    private static final Logger logger = LoggerFactory.getLogger(ArtistService.class);

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    AddressService addressService;

    public List<Artist> fetchAllArtist()
    {
        return artistRepository.fetchAllArtist();
    }

    public void addArtist(Artist artist)
    {
        try
        {
            if (artist.getName() == null || artist.getName().isEmpty())
            {
                throw new IllegalArgumentException("Artist title cannot be empty");
            }
            artistRepository.addArtist(artist);
            logger.info("Artist added: " + artist.getName());
        } catch (Exception e)
        {
            logger.error("Error adding Artist: " + e.getMessage());
            throw new RuntimeException("Failed to add artist", e);
        }
    }

    public Artist findArtistById(int artistId) {
        Artist artist = artistRepository.findArtistById(artistId);
        Address address = addressService.findAddressById(artist.getAddress().getAddressId());
        artist.setAddress(address);  // Correctly setting the address
        logger.info("Artist object: " + artist);  // Log to check if address is set correctly
        return artist;
    }



    public void updateArtist(Artist artist)
    {
        artistRepository.updateArtist(artist);
    }

    public boolean deleteArtist(int artistId)
    {
        return artistRepository.deleteArtist(artistId);
    }
}








