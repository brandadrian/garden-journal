package com.gardenjournal.restservice.GardenJournal.core.interfaces;
import com.gardenjournal.restservice.GardenJournal.core.entities.GardenJournalItem;

import java.util.List;

public interface IGardenJournalRepository {

    GardenJournalItem getById(int id);

    List<GardenJournalItem> getAll();

    void save(GardenJournalItem gardenJournalItem);

    void update(GardenJournalItem gardenJournalItem);

    void delete(int id);
}
