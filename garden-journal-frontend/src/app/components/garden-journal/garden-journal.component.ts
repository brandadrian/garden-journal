import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { GenericDialogField } from 'src/app/data/generic-dialog-field';
import { JournalItem } from 'src/app/data/journal-item.interface';
import { GardenJournalDomainService } from 'src/app/domain/garden-journal.domain-service';
import { GenericDialogService } from 'src/app/services/generic-dialog.service';
import { GenericDialogComponent } from '../generic-dialog/generic-dialog.component';

@Component({
  selector: 'app-garden-journal',
  templateUrl: './garden-journal.component.html',
  styleUrls: ['./garden-journal.component.scss']
})
export class GardenJournalComponent implements OnInit {

  constructor(
    public readonly genericDialogService: GenericDialogService,
    public readonly gardenJournalDomainService: GardenJournalDomainService
  ) { }

  public ngOnInit(): void {
    this.gardenJournalDomainService.init();
  }

  public addItem(): void {
    const newItem: JournalItem = {id: 42, description: '', title: '', date: new Date()};

    const fields: Array<GenericDialogField> =       [
      {name: 'title', value: newItem.title},
      {name: 'description', value: newItem.description}
    ];

    this.genericDialogService.openDialog(     
      "Add item",
      "A new item will be added",
      fields,
      () => {
        this.mapFields(fields, newItem)
        this.gardenJournalDomainService.addJournalItem(newItem).subscribe(() => {
          this.gardenJournalDomainService.init();
        });
      });
  }

  public editItem(journalItem: JournalItem): void {
    const fields =       [
      {name: 'title', value: journalItem.title},
      {name: 'description', value: journalItem.description}
    ];

    this.genericDialogService.openDialog(     
      "Edit items",
      "Change the values",
      fields,
      () => {
        this.mapFields(fields, journalItem)
        this.gardenJournalDomainService.editItem(journalItem).subscribe(() => {
          this.gardenJournalDomainService.init();
        });
      });
  }

  public deleteItem(journalItem: JournalItem): void {
    this.gardenJournalDomainService.deleteItem(journalItem).subscribe(() => {
      this.gardenJournalDomainService.init();
    });
  }

  private mapFields(fields: Array<GenericDialogField>, target: JournalItem) {
    const title = fields.find(f => f.name === 'title')?.value;
    const description = fields.find(f => f.name === 'description')?.value;
    target.description = description ?? '';
    target.title = title ?? '';
  }
}
