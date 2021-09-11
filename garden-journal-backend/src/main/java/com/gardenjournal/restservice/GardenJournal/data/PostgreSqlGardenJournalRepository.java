package com.gardenjournal.restservice.GardenJournal.data;
import com.gardenjournal.restservice.GardenJournal.core.entities.GardenJournalItem;
import com.gardenjournal.restservice.GardenJournal.core.interfaces.IGardenJournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PostgreSqlGardenJournalRepository")
public class PostgreSqlGardenJournalRepository implements IGardenJournalRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public GardenJournalItem getById(int id) {
        var items = getAll();

        for(GardenJournalItem item : items) {
            if (item.getid() == id) {
                return item;
            }
        }

        return null;
    }

    @Override
    public List<GardenJournalItem> getAll() {
        String sql = "SELECT * FROM GARDENJOURNALITEMS";

        List<GardenJournalItem> items = jdbcTemplate.query(
                sql,
                new GardenJournalItemRowMapper());

        return items;
    }

    @Override
    public void save(GardenJournalItem gardenJournalItem) {
        jdbcTemplate.update(
                "INSERT INTO GARDENJOURNALITEMS (DESCRIPTION, DATE, TITLE) VALUES (?, ?, ?)",
                gardenJournalItem.getDescription(),
                gardenJournalItem.getDate(),
                gardenJournalItem.getTitle()
        );
    }

    @Override
    public void update(GardenJournalItem gardenJournalItem) {
        this.jdbcTemplate.update(
                "UPDATE GARDENJOURNALITEMS SET DESCRIPTION = ?, DATE = ?, TITLE = ? WHERE ID = ?",
                gardenJournalItem.getDescription(),
                gardenJournalItem.getDate(),
                gardenJournalItem.getTitle(),
                gardenJournalItem.getid());
    }

    @Override
    public void delete(int id) {
        this.jdbcTemplate.update(
                "DELETE FROM GARDENJOURNALITEMS WHERE ID = ?",
                id);
    }
}
