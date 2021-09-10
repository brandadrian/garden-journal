package com.gardenjournal.restservice.GardenJournal.core.services;

import com.gardenjournal.restservice.GardenJournal.core.dtos.GardenJournalItemDto;
import com.gardenjournal.restservice.GardenJournal.core.interfaces.IGardenJournalRepository;
import com.gardenjournal.restservice.GardenJournal.core.interfaces.IGardenJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("GardenJournalService")
public class GardenJournalService implements IGardenJournalService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IGardenJournalRepository gardenJournalRepository;

    public GardenJournalService(){

    }

    @Override
    public GardenJournalItemDto getById(int id) {

        return Mapper.ToDto(this.gardenJournalRepository.getById(id));
    }

    @Override
    public List<GardenJournalItemDto> getAll() {


        return Mapper.ToDto(this.gardenJournalRepository.getAll());
    }

    @Override
    public void save(GardenJournalItemDto gardenJournalItem) {

        this.gardenJournalRepository.save(Mapper.FromDto(gardenJournalItem));
    }

    @Override
    public void update(GardenJournalItemDto gardenJournalItem) {

        this.gardenJournalRepository.update(Mapper.FromDto(gardenJournalItem));
    }

    @Override
    public void delete(int id) {

        this.gardenJournalRepository.delete(id);
    }
}
