import { Injectable } from "@angular/core";
import { Observable, Subject } from "rxjs";
import { JournalItem } from "../data/journal-item.interface";
import { GardenJournalService } from "../services/garden-journal.service";

@Injectable({
    providedIn: 'root'
  })
  export class GardenJournalDomainService {
    public journalItems$!: Subject<JournalItem>;

  
    constructor(
      private gardenJournalService: GardenJournalService
    ) { }

    public getJournalItems(): Observable<Array<JournalItem>> {
      this.gardenJournalService.getJournalItems().subscribe(result => alert("RESULT FROM SERVER" + result[0].description));
      return this.gardenJournalService.getJournalItemsMock();
    }
  
    public addJournalItem(journalItem: JournalItem): Observable<void> {
      this.journalItems$.next();
      return this.gardenJournalService.addJournalItem(journalItem);
    }
  }
