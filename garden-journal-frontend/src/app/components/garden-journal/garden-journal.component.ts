import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { JournalItem } from 'src/app/data/journal-item.interface';
import { GardenJournalDomainService } from 'src/app/domain/garden-journal.domain-service';

@Component({
  selector: 'app-garden-journal',
  templateUrl: './garden-journal.component.html',
  styleUrls: ['./garden-journal.component.scss']
})
export class GardenJournalComponent implements OnInit {

  constructor(
    public readonly gardenJournalDomainService: GardenJournalDomainService
  ) { }

  public ngOnInit(): void {
    this.gardenJournalDomainService.init();
  }

  public addItem(): void {
    const newItem: JournalItem = {id: 42, description: 'newItem', title: 'title', date: new Date()};
    this.gardenJournalDomainService.addJournalItem(newItem);
  }

  public editItem(journalItem: JournalItem): void {
    this.gardenJournalDomainService.editItem(journalItem);
  }

  public deleteItem(journalItem: JournalItem): void {
    this.gardenJournalDomainService.deleteItem(journalItem);
  }
}
