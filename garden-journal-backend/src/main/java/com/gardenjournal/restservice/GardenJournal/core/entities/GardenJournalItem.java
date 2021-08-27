package com.gardenjournal.restservice.GardenJournal.core.entities;

public class GardenJournalItem {

    private final int id;

    private final String description;

    public GardenJournalItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getid() {

        return this.id;
    }

    public String getDescription() {

        return this.description;
    }
}
