package com.example.musiccollection.Service;

import com.example.musiccollection.Model.RecordLabel;
import com.example.musiccollection.Repository.RecordLabelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordLabelService
{
    private static final Logger logger = LoggerFactory.getLogger(RecordLabelService.class);

    @Autowired
    RecordLabelRepository recordLabelRepository;

    public List<RecordLabel> fetchAllRecordLabel()
    {
        return recordLabelRepository.fetchAllRecordLabel();
    }

    public void addRecordLabel(RecordLabel recordLabel)
    {
        try
        {
            if (recordLabel.getName() == null || recordLabel.getName().isEmpty())
            {
                throw new IllegalArgumentException("Record Label name cannot be empty");
            }
            recordLabelRepository.addRecordLabel(recordLabel);
            logger.info("Record Label added: " + recordLabel.getName());
        } catch (Exception e)
        {
            logger.error("Error adding Record Label: " + e.getMessage());
            throw new RuntimeException("Failed to add Record Label", e);
        }
    }

    public RecordLabel findRecordLabelById(int recordLabelId)
    {
        return recordLabelRepository.findRecordLabelById(recordLabelId);
    }

    public void updateRecordLabel(RecordLabel recordLabel)
    {
        recordLabelRepository.updateRecordLabel(recordLabel);
    }

    public boolean deleteRecordLabel(int recordLabelId)
    {
        return recordLabelRepository.deleteRecordLabel(recordLabelId);
    }
}
