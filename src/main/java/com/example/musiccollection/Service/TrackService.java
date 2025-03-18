package com.example.musiccollection.Service;

import com.example.musiccollection.Model.Track;
import com.example.musiccollection.Repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService
{
    private static final Logger logger = LoggerFactory.getLogger(TrackService.class);

    @Autowired
    TrackRepository trackRepository;

    public List<Track> fetchAllTrack()
    {
        return trackRepository.fetchAllTrack();
    }

    public void addTrack(Track track)
    {
        try
        {
            // Validate track name is not empty
            if (track.getTitle() == null || track.getTitle().isEmpty())
            {
                throw new IllegalArgumentException("Track name cannot be empty");
            }

            // Add the track
            trackRepository.addTrack(track);
            logger.info("Track added: " + track.getTitle());
        } catch (Exception e)
        {
            logger.error("Error adding track: " + e.getMessage());
            throw new RuntimeException("Failed to add track", e);
        }
    }

    public Track findTrackById(int trackId)
    {
        return trackRepository.findTrackById(trackId);
    }

    public void updateTrack(Track track)
    {
        trackRepository.updateTrack(track);
    }

    public boolean deleteTrack(int trackId)
    {
        return trackRepository.deleteTrack(trackId);
    }
}
