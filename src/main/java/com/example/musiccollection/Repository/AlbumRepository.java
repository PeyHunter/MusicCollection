package com.example.musiccollection.Repository;

import com.example.musiccollection.Model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository
{

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Album> fetchAllAlbum() {
        String sql = "SELECT a.album_id, a.title, a.release_year, " +
                "COALESCE(art.name, '') AS artist_name, " +
                "COALESCE(lbl.name, '') AS label_name " +
                "FROM Album a " +
                "LEFT JOIN Artist art ON a.artist_id = art.artist_id " +
                "LEFT JOIN RecordLabel lbl ON a.label_id = lbl.label_id";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Album album = new Album();
            album.setAlbumId(rs.getInt("album_id"));
            album.setTitle(rs.getString("title"));
            album.setReleaseYear(rs.getInt("release_year"));
            album.setArtistName(rs.getString("artist_name"));
            album.setLabelName(rs.getString("label_name"));
            return album;
        });
    }



    public void addAlbum(Album album) {
        String sql = "INSERT INTO Album (title, release_year, artist_id, label_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, album.getTitle(), album.getReleaseYear(), album.getArtistId(), album.getLabelId());
    }

    // Update an existing album with artist and label objects
    public void updateAlbum(Album album) {
        String sql = "UPDATE Album SET title = ?, release_year = ?, artist_id = ?, label_id = ? WHERE album_id = ?";

        jdbcTemplate.update(sql, album.getTitle(), album.getReleaseYear(),
                album.getArtist() != null ? album.getArtist().getArtistId() : null,  // Update artist_id
                album.getRecordLabel() != null ? album.getRecordLabel().getLabelId() : null, // Update label_id
                album.getAlbumId());
    }


    public Album findAlbumById(int albumId) {
        String sql = "SELECT * FROM Album WHERE album_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Album.class), albumId);
    }

    public boolean deleteAlbum(int albumId)
    {
        String sql = "DELETE FROM Album WHERE album_id = ?";
        return jdbcTemplate.update(sql, albumId) > 0;
    }

    private static class AlbumRowMapper implements RowMapper<Album> {
        @Override
        public Album mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Album album = new Album();
            album.setAlbumId(rs.getInt("album_id"));
            album.setTitle(rs.getString("title"));
            album.setReleaseYear(rs.getInt("release_year"));
            album.setArtistName(rs.getString("artist_name"));
            album.setLabelName(rs.getString("label_name"));
            return album;
        }
    }



}