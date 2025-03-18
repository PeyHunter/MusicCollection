package com.example.musiccollection.Service;

import com.example.musiccollection.Model.Address;
import com.example.musiccollection.Model.ArtistLabel;
import com.example.musiccollection.Repository.ArtistLabelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArtistLabelService
{
    private static final Logger logger = LoggerFactory.getLogger(ArtistLabelService.class);

    @Autowired
    ArtistLabelRepository  artistLabelRepository;


    public List<ArtistLabel> fetchAllArtistLabel()
    {
        return artistLabelRepository.fetchAllArtistLabel();
    }

    public void addArtistLabel(ArtistLabel artistLabel)
    {
        try
        {
            if (artistLabel.getArtistId() == 0) {
                throw new IllegalArgumentException("Artist Label cannot have an invalid artistId (0)");
            }

            // Add the artist label
            artistLabelRepository.addArtistLabel(artistLabel);
            logger.info("ArtistLabel added: " + artistLabel.getArtistId());

        } catch (Exception e)
        {
            // Log error related to ArtistLabel
            logger.error("Error adding ArtistLabel: " + e.getMessage());
            throw new RuntimeException("Failed to add ArtistLabel", e);
        }
    }


    public ArtistLabel findArtistLabelById(int artistLabel)
    {
        return artistLabelRepository.findArtistLabelById(artistLabel);
    }

    public void updateArtistLabel(ArtistLabel artistLabel)
    {
        artistLabelRepository.updateArtistLabel(artistLabel);
    }

    public boolean deleteArtistLabel(int artistLabel)
    {
        return artistLabelRepository.deleteArtistLabel(artistLabel);
    }


}
