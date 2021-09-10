import { Injectable } from "@angular/core";
import { Observable, Subject } from "rxjs";
import { JournalItem } from "../data/journal-item.interface";
import { GardenJournalService } from "../services/garden-journal.service";

@Injectable({
    providedIn: 'root'
  })
  export class GardenJournalDomainService {
    public journalItems$: Observable<Array<JournalItem>> | undefined;

  
    constructor(
      private gardenJournalService: GardenJournalService
    ) {

    }

    public init(): void {
      this.journalItems$ = this.getJournalItems();
    }

    public getJournalItems(): Observable<Array<JournalItem>> {
      return this.gardenJournalService.getJournalItems();
    }
  
    public addJournalItem(journalItem: JournalItem): Observable<void> {
      return this.gardenJournalService.addJournalItem(journalItem);
    }

    public deleteItem(item: JournalItem) {
      console.warn("DELETE ITEM", item);
    }

    public editItem(item: JournalItem) {
      console.warn("EDIT ITEM", item);
    }
  }
