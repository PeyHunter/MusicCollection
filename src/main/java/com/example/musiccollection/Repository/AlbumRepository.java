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


    public List<Album> fetchAll() {
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



    public void updateAlbum(Album album)
    {
        String sql = "UPDATE Album SET title = ?, release_year = ?, artist_id = ?, label_id = ? WHERE album_id = ?";
        jdbcTemplate.update(sql, album.getTitle(), album.getReleaseYear(), album.getArtistId(), album.getLabelId());
    }

    public void deleteAlbum(int album_id)
    {
        String sql = "DELETE FROM Album WHERE album_id = ?";
        jdbcTemplate.update(sql, album_id);
    }


}

