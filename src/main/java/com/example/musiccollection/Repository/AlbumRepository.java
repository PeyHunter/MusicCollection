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

    public void addAlbum(Album album){
        String sql = "INSERT INTO Album (title, release_year, artist_id, label_id)  VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, album.getTitle(), album.getRelease_year(), album.getArtist_id(), album.getLabel_id());
    }

    public List<Album> fetchAll()
    {
        String sql = "SELECT * FROM Album";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class);
        return jdbcTemplate.query(sql, rowMapper);

    }


    public void updateAlbum(Album album)
    {
        String sql = "UPDATE Album SET title = ?, release_year = ?, artist_id = ?, label_id = ? WHERE album_id = ?";
        jdbcTemplate.update(sql, album.getTitle(), album.getRelease_year(), album.getArtist_id(), album.getLabel_id());
    }

    public void deleteAlbum(int album_id)
    {
        String sql = "DELETE FROM Album WHERE album_id = ?";
        jdbcTemplate.update(sql, album_id);
    }


}

