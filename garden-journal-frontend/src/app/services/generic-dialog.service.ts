import { Injectable } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { Subject } from "rxjs";
import { GenericDialogComponent } from "../components/generic-dialog/generic-dialog.component";
import { GenericDialogField } from "../data/generic-dialog-field";

@Injectable({
    providedIn: 'root'
  })
  export class GenericDialogService {
     
    public width: string = '250px';
    public title: string = '';
    public text: string = '';
    public fields: Array<GenericDialogField> = [];
    public dialogClosed$: Subject<Array<GenericDialogField>> = new Subject<Array<GenericDialogField>>();

    constructor(
        public dialog: MatDialog
    ) {

    }

    public openDialog(title: string, text: string, fields: Array<GenericDialogField>, closeFunction: Function, width: number = 250): void {
        this.text = text;
        this.title = title;
        this.fields = fields;
        this.width = width + 'px';

        const dialogRef = this.dialog.open(GenericDialogComponent, {
          width: this.width,
          data: this.fields
        });
    
        dialogRef.afterClosed().subscribe(() => {
          closeFunction();
        });
      }
  }