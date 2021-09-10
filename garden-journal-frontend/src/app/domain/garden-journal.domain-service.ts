import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable, Subject } from "rxjs";
import { JournalItem } from "../data/journal-item.interface";
import { GardenJournalService } from "../services/garden-journal.service";

@Injectable({
    providedIn: 'root'
  })
  export class GardenJournalDomainService {
    private readonly journalItems = new BehaviorSubject<Array<JournalItem>>([]);
    public journalItems$ = this.journalItems.asObservable();

    private readonly isEditMode = new BehaviorSubject<boolean>(false);
    public isEditMode$ = this.isEditMode.asObservable();
  
    constructor(
      private gardenJournalService: GardenJournalService
    ) {

    }

    public init(): void {
      this.getJournalItems().subscribe(items => this.journalItems.next(items));
    }

    public getJournalItems(): Observable<Array<JournalItem>> {
      return this.gardenJournalService.getJournalItems();
    }
  
    public addJournalItem(journalItem: JournalItem): Observable<void> {
      alert("ADD ITEM" + JSON.stringify(journalItem));
      return this.gardenJournalService.addJournalItem(journalItem);
    }

    public deleteItem(item: JournalItem) {
      alert("DELETE ITEM" + JSON.stringify(item));
    }

    public editItem(item: JournalItem) {
      alert("EDIT ITEM" + JSON.stringify(item));
    }

    public setEditMode(isEditMode: boolean) {
      this.isEditMode.next(isEditMode);
    }
  }
