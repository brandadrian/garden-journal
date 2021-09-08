package com.gardenjournal.restservice.GardenJournal.api;

import com.gardenjournal.restservice.GardenJournal.core.dtos.GardenJournalItemDto;
import com.gardenjournal.restservice.GardenJournal.core.interfaces.IGardenJournalService;
import com.gardenjournal.restservice.GardenJournal.core.services.GardenJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class GardenJournalController {

    @Autowired
    private IGardenJournalService gardenJournalService;

    public GardenJournalController() {

    }

    @CrossOrigin()
    @GetMapping(path="/journal-items/{id}", produces = "application/json")
    public GardenJournalItemDto getJournalItemById(@PathVariable("id") int id)
    {
        return this.gardenJournalService.getById(id);
    }

    @CrossOrigin()
    @GetMapping(path="/journal-items", produces = "application/json")
    public List<GardenJournalItemDto> getJournalItems()
    {
        return this.gardenJournalService.getAll();
    }

    @CrossOrigin()
    @PostMapping(path= "/journal-items", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addJournalItem(@RequestBody GardenJournalItemDto gardenJournalItem)
    {
        this.gardenJournalService.save(gardenJournalItem);

        return ResponseEntity.ok("");
    }

    @CrossOrigin()
    @DeleteMapping(path= "/journal-items/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteJournalItem(@PathVariable("id") int id)
    {
        this.gardenJournalService.delete(id);

        return ResponseEntity.ok("");
    }

    @CrossOrigin()
    @PutMapping(path= "/journal-items", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateJournalItem(@RequestBody GardenJournalItemDto gardenJournalItem)
    {
        this.gardenJournalService.update(gardenJournalItem);

        return ResponseEntity.ok("");
    }
}