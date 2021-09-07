import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { JournalItem } from 'src/app/data/journal-item.interface';
import { GardenJournalDomainService } from 'src/app/domain/garden-journal.domain-service';
import { GardenJournalService } from 'src/app/services/garden-journal.service';

@Component({
  selector: 'app-garden-journal',
  templateUrl: './garden-journal.component.html',
  styleUrls: ['./garden-journal.component.scss']
})
export class GardenJournalComponent implements OnInit {

  public journalItems$: Observable<Array<JournalItem>> | undefined;

  constructor(
    private readonly gardenJournalDomainService: GardenJournalDomainService
  ) { }

  public ngOnInit(): void {
    this.journalItems$ = this.gardenJournalDomainService.getJournalItems();
  }

  public addItem(): void {
    const newItem: JournalItem = {id: 42, description: 'newItem'};
    this.gardenJournalDomainService.addJournalItem(newItem);
  }

}
