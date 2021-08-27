package com.gardenjournal.restservice.GardenJournal.core.interfaces;

import com.gardenjournal.restservice.GardenJournal.core.dtos.GardenJournalItemDto;
import com.gardenjournal.restservice.GardenJournal.core.entities.GardenJournalItem;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IGardenJournalService {
    GardenJournalItemDto getById(int id);

    List<GardenJournalItemDto> getAll();

    void save(GardenJournalItemDto gardenJournalItem);

    void update(GardenJournalItemDto gardenJournalItem);

    void delete(int id);
}
