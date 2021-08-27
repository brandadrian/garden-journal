package com.gardenjournal.restservice.GardenJournal.core.services;

import com.gardenjournal.restservice.GardenJournal.core.dtos.GardenJournalItemDto;
import com.gardenjournal.restservice.GardenJournal.core.entities.GardenJournalItem;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static List<GardenJournalItemDto> ToDto(List<GardenJournalItem> items) {
        var dtos = new ArrayList<GardenJournalItemDto>();

        for (var item:items) {
            dtos.add(ToDto(item));
        }

        return dtos;
    }

    public static GardenJournalItemDto ToDto(GardenJournalItem item) {

      return new GardenJournalItemDto(item.getid(), item.getDescription());
    }

    public static List<GardenJournalItem> FromDto(List<GardenJournalItemDto> dtos) {
        var items = new ArrayList<GardenJournalItem>();

        for (var dto:dtos) {
            items.add(FromDto(dto));
        }

        return items;
    }

    public static GardenJournalItem FromDto(GardenJournalItemDto item) {

        return new GardenJournalItem(item.getid(), item.getDescription());
    }
}
