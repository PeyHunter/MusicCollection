package com.example.musiccollection.Repository;

import com.example.musiccollection.Model.RecordLabel;
import com.example.musiccollection.Model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TrackRepository
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Track> fetchAllTrack()
    {
        String sql = "SELECT * FROM Track";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Track.class));
    }

    public Track findTrackById(int id)
    {
        String sql = "SELECT * FROM Track WHERE trackId = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Track.class), id);
    }

    public void addTrack(Track track)
    {
        String sql = "INSERT INTO Track (trackId = ?, title = ?, time = ?, albumId = ?) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, track.getTrackId(), track.getTitle(), track.getTime(), track.getAlbumId());
    }

    public void updateTrack(Track track)
    {
        String sql = "UPDATE Track SET trackId = ?, title = ?, time = ?, albumId = ?";
        jdbcTemplate.update(sql, track.getTrackId(), track.getTitle(), track.getTime(), track.getAlbumId());
    }

    public boolean deleteTrack(int trackId)
    {
        String sql = "DELETE FROM Track WHERE trackId = ?";
        return jdbcTemplate.update(sql, trackId) > 0;
    }

}
