package com.gardenjournal.restservice.GardenJournal.data;

import com.gardenjournal.restservice.GardenJournal.core.entities.GardenJournalItem;
import com.gardenjournal.restservice.GardenJournal.core.interfaces.IGardenJournalRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Component("InMemoryGardenJournalRepository")
public class InMemoryGardenJournalRepository implements IGardenJournalRepository {

    private ArrayList<GardenJournalItem> inMemoryData;

    public InMemoryGardenJournalRepository() {
        this.inMemoryData = new ArrayList<GardenJournalItem>();
        this.inMemoryData.add(new GardenJournalItem(
                1,
                "Gemüse wächst!!!!",
                new Date(2021, 4, 1, 9, 10), "Das Gemüse wächst gut"));
        this.inMemoryData.add(new GardenJournalItem(
                2,
                "Schnecken überall",
                new Date(2021, 7, 11, 6, 33),
                "Schnecken haben das Beet erobert"));
        this.inMemoryData.add(new GardenJournalItem(3,
                "Die Erdbeeren können geerntet werden",
                new Date(2021, 9, 29, 16, 23),
                "Feine Erdbeeren"));
    }

    @Override
    public GardenJournalItem getById(int id) {

        for (var item: inMemoryData){
            if (item.getid() == id) {
                return item;
            }
        }

        return null;
    }

    @Override
    public List<GardenJournalItem> getAll() {

        return inMemoryData;
    }

    @Override
    public void save(GardenJournalItem gardenJournalItem) {
        var itemWithMaxId = inMemoryData
                .stream()
                .max(Comparator.comparing(GardenJournalItem::getid));

        var id = itemWithMaxId != null ? itemWithMaxId.get().getid() + 1 : 0;
        this.inMemoryData.add(new GardenJournalItem(id, gardenJournalItem.getDescription(), gardenJournalItem.getDate(), gardenJournalItem.getTitle()));
    }

    @Override
    public void update(GardenJournalItem gardenJournalItem) {
        var tempInMemoryData =  new ArrayList<GardenJournalItem>();

        for (var item: inMemoryData){
            if (item.getid() == gardenJournalItem.getid()) {
                tempInMemoryData.add(new GardenJournalItem(gardenJournalItem.getid(), gardenJournalItem.getDescription(), gardenJournalItem.getDate(), gardenJournalItem.getTitle()));
            } else {
                tempInMemoryData.add(new GardenJournalItem(item.getid(), item.getDescription(), item.getDate(), item.getTitle()));
            }
        }

        this.inMemoryData.clear();
        this.inMemoryData.addAll(tempInMemoryData);
    }

    @Override
    public void delete(int id) {
        var tempInMemoryData =  new ArrayList<GardenJournalItem>();

        for (var item: inMemoryData){
            if (item.getid() != id) {
                tempInMemoryData.add(item);
            }
        }

        this.inMemoryData.clear();
        this.inMemoryData.addAll(tempInMemoryData);
    }
}