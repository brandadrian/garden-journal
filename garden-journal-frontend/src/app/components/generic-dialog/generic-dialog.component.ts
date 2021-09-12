
/*TODO:Extract to base component*/
import { Component, Inject, Input, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { GenericDialogField } from 'src/app/data/generic-dialog-field';
import { GenericDialogService } from 'src/app/services/generic-dialog.service';

@Component({
  selector: 'app-generic-dialog',
  templateUrl: './generic-dialog.component.html',
  styleUrls: ['./generic-dialog.component.scss']
})
export class GenericDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<GenericDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public readonly genericDialogService: GenericDialogService) { }

  public onCancelClick(): void {
    this.dialogRef.close();
  }

  public ngOnInit(): void {
  }
}
