package com.example.musiccollection.Repository;

import com.example.musiccollection.Model.Address;
import com.example.musiccollection.Model.RecordLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RecordLabelRepository
{


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<RecordLabel> fetchAllRecordLabel()
    {
        String sql = "SELECT * FROM RecordLabel";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RecordLabel.class));
    }

    public RecordLabel findRecordLabelById(int id)
    {
        String sql = "SELECT * FROM RecordLabel WHERE label_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(RecordLabel.class));
    }

    public void addRecordLabel(RecordLabel recordLabel)
    {
        String sql = "INSERT INTO RecordLabel (labelId, name, addressId)";
        jdbcTemplate.update(sql, recordLabel.getLabelId(), recordLabel.getName(), recordLabel.getAddressId());
    }

    public void updateRecordLabel(RecordLabel recordLabel)
    {
        String sql = "UPDATE RecordLabel SET labelId = ?, name = ?, addressId = ?";
    }

    public boolean deleteRecordLabel(int recordLabelId)
    {
        String sql = "DELETE FROM RecordLabel WHERE label_id = ?";
        return jdbcTemplate.update(sql, recordLabelId) > 0;
    }

}
