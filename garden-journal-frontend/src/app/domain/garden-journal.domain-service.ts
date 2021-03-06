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
      return this.gardenJournalService.addJournalItem(journalItem);
    }

    public deleteItem(journalItem: JournalItem) {
      return this.gardenJournalService.deleteJournalItem(journalItem);
    }

    public editItem(journalItem: JournalItem) {
      return this.gardenJournalService.editJournalItem(journalItem);
    }

    public setEditMode(isEditMode: boolean) {
      this.isEditMode.next(isEditMode);
    }
  }
