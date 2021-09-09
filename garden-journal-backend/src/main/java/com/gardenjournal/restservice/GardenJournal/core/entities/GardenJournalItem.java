package com.gardenjournal.restservice.GardenJournal.core.entities;

import java.util.Date;

public class GardenJournalItem {

    private final int id;

    private final String description;

    private final String title;

    private final Date date;

    public GardenJournalItem(int id, String description, Date date, String title) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.title = title;
    }

    public int getid() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitle() {
        return this.title;
    }

    public Date getDate() {
        return this.date;
    }
}
