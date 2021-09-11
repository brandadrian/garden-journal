package com.gardenjournal.restservice.GardenJournal.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseMigration {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void init() {
        jdbcTemplate.update(
                "CREATE TABLE IF NOT EXISTS public.gardenjournalitems\n" +
                        "(\n" +
                        "    id SERIAL PRIMARY KEY,\n" +
                        "    description text,\n" +
                        "    title text,\n" +
                        "    date date\n" +
                        ")"
        );
    }
}
