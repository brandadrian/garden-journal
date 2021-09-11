package com.gardenjournal.restservice.GardenJournal;

import com.gardenjournal.restservice.GardenJournal.data.DatabaseMigration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private DatabaseMigration databaseMigration;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        //databaseMigration.init();

        return;
    }
}
