package com.example.musiccollection.Repository;

import com.example.musiccollection.Model.Address;
import com.example.musiccollection.Model.ArtistLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class ArtistLabelRepository
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ArtistLabel> fetchAllArtistLabel()
    {
        String sql = "SELECT * FROM ArtistLabel";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ArtistLabel.class));
    }

    public ArtistLabel findArtistLabelById(int id)
    {
        String sql = "SELECT * FROM ArtistLabel WHERE address_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ArtistLabel.class), id);
    }


    public void addArtistLabel(ArtistLabel artistLabel)
    {
        String sql = "INSERT INTO ArtistLabel (artistId, labelId, signYear) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, artistLabel.getArtistId(), artistLabel.getLabelId(), artistLabel.getSignYear());
    }

    public void updateArtistLabel(ArtistLabel artistLabel)
    {
        String sql = "UPDATE ArtistLabel SET artistId = ?, labelId = ?, signYear = ? WHERE artistLabel = ?";
        jdbcTemplate.update(sql, artistLabel.getArtistId(), artistLabel.getLabelId(), artistLabel.getSignYear());
    }

    public boolean deleteArtistLabel(int artistLabelId)
    {
        String sql = "DELETE FROM ArtistLabel WHERE artistLabel_id = ?";
        return jdbcTemplate.update(sql, artistLabelId) > 0;
    }


}
