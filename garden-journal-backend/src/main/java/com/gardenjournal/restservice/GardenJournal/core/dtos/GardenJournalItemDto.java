package com.gardenjournal.restservice.GardenJournal.core.dtos;

public class GardenJournalItemDto {

    private final int id;

    private final String description;

    public GardenJournalItemDto(int id, String description) {
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
