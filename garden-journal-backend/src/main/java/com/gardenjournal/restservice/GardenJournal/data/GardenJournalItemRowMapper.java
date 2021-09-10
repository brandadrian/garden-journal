package com.gardenjournal.restservice.GardenJournal.data;
import com.gardenjournal.restservice.GardenJournal.core.dtos.GardenJournalItemDto;
import com.gardenjournal.restservice.GardenJournal.core.entities.GardenJournalItem;
import org.springframework.jdbc.core.RowMapper;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class GardenJournalItemRowMapper implements RowMapper<GardenJournalItem> {

    @Override
    public GardenJournalItem mapRow(ResultSet rs, int rowNum) throws SQLException {

        GardenJournalItem customer = new GardenJournalItem(
                rs.getInt("ID"),
                rs.getString("DESCRIPTION"),
                rs.getDate("DATE"),
                rs.getString("TITLE")
        );

        return customer;

    }
}