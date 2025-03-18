package com.example.musiccollection.Repository;

import com.example.musiccollection.Model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // Fetch all artists from the database
    public List<Artist> fetchAllArtist() {
        String sql = "SELECT * FROM Artist";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Artist artist = new Artist();
            artist.setArtistId(rs.getInt("artist_id"));
            artist.setName(rs.getString("name"));
            artist.setAddressId(rs.getInt("address_id"));
            return artist;
        });
    }

    // Fetch an artist by their ID
    public Artist fetchArtistById(int artistId) {
        String sql = "SELECT * FROM Artist WHERE artist_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{artistId}, (rs, rowNum) -> {
            Artist artist = new Artist();
            artist.setArtistId(rs.getInt("artist_id"));
            artist.setName(rs.getString("name"));
            artist.setAddressId(rs.getInt("address_id"));
            return artist;
        });
    }

    // Add a new artist to the database
    public void addArtist(Artist artist) {
        String sql = "INSERT INTO Artist (name, address_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, artist.getName(), artist.getAddressId());
    }

    // Update an existing artist's information
    public void updateArtist(Artist artist) {
        String sql = "UPDATE Artist SET name = ?, address_id = ? WHERE artist_id = ?";
        jdbcTemplate.update(sql, artist.getName(), artist.getAddressId(), artist.getArtistId());
    }

    // Delete an artist from the database
    public boolean deleteArtist(int artistId) {
        String sql = "DELETE FROM Artist WHERE artist_id = ?";
        return jdbcTemplate.update(sql, artistId) > 0;
    }
}
