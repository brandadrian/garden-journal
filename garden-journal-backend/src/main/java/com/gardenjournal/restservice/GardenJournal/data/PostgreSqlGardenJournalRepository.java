//package com.gardenjournal.restservice.GardenJournal.data;
//import com.gardenjournal.restservice.GardenJournal.core.entities.GardenJournalItem;
//import com.gardenjournal.restservice.GardenJournal.core.interfaces.IGardenJournalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//
//public class PostgreSqlGardenJournalRepository implements IGardenJournalRepository {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public GardenJournalItem getById(int id) {
//        return null;
//    }
//
//    @Override
//    public List<GardenJournalItem> getAll() {
//        String sql = "SELECT * FROM GARDENJOURNALITEMS";
//
//        List<GardenJournalItem> items = jdbcTemplate.query(
//                sql,
//                new GardenJournalItemRowMapper());
//
//        return items;
//    }
//
//    @Override
//    public void save(GardenJournalItem gardenJournalItem) {
//
//    }
//
//    @Override
//    public void update(GardenJournalItem gardenJournalItem) {
//
//    }
//
//    @Override
//    public void delete(int id) {
//
//    }
//}
//