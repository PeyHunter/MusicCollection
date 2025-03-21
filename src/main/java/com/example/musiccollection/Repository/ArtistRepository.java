package com.example.musiccollection.Repository;

import com.example.musiccollection.Model.Artist;
import com.example.musiccollection.Model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

            // Fetch Address using the address_id
            int addressId = rs.getInt("address_id");
            Address address = fetchAddressById(addressId); // Fetch Address by addressId
            artist.setAddress(address);

            return artist;
        });
    }

    // Fetch an artist by their ID
    public Artist findArtistById(int artistId) {
        String sql = "SELECT * FROM Artist WHERE artist_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{artistId}, (rs, rowNum) -> {
            Artist artist = new Artist();
            artist.setArtistId(rs.getInt("artist_id"));
            artist.setName(rs.getString("name"));

            // Fetch Address using the address_id
            int addressId = rs.getInt("address_id");
            Address address = fetchAddressById(addressId); // Fetch Address by addressId
            artist.setAddress(address);

            return artist;
        });
    }

    // Add a new artist to the database
    public void addArtist(Artist artist) {
        String sql = "INSERT INTO Artist (name, address_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, artist.getName(), artist.getAddress().getAddressId()); // Using addressId from Address object
    }

    // Update an existing artist's information
    public void updateArtist(Artist artist) {
        String sql = "UPDATE Artist SET name = ?, address_id = ? WHERE artist_id = ?";
        jdbcTemplate.update(sql, artist.getName(), artist.getAddress().getAddressId(), artist.getArtistId());
    }

    // Delete an artist from the database
    public boolean deleteArtist(int artistId) {
        String sql = "DELETE FROM Artist WHERE artist_id = ?";
        return jdbcTemplate.update(sql, artistId) > 0;
    }

    // Helper method to fetch Address by addressId
    private Address fetchAddressById(int addressId) {
        String sql = "SELECT * FROM Address WHERE address_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{addressId}, (rs, rowNum) -> {
            Address address = new Address();
            address.setAddressId(rs.getInt("address_id"));
            address.setStreet(rs.getString("street"));
            address.setCity(rs.getString("city"));
            address.setPostalCode(rs.getString("postal_code"));
            address.setCountry(rs.getString("country"));
            return address;
        });
    }
}
