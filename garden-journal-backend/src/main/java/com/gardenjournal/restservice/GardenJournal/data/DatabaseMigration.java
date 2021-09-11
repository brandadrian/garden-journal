package com.gardenjournal.restservice.GardenJournal.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseMigration {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void init() {
        try {
            System.out.println("Init database");
            jdbcTemplate.update(
                    "CREATE TABLE IF NOT EXISTS public.gardenjournalitems\n" +
                            "(\n" +
                            "    id SERIAL PRIMARY KEY,\n" +
                            "    description text,\n" +
                            "    title text,\n" +
                            "    date date\n" +
                            ")"
            );

            System.out.println("Init database succesfull");
        }
        catch(Exception exception) {
            System.out.println("Init database with errors" + exception.getMessage());
            //Todo: Log exception
        }

    }
}
