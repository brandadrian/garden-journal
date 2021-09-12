import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, of } from 'rxjs';
import { JournalItem } from '../data/journal-item.interface';
import { journalItemsMock } from '../data/journal-item-mock';

@Injectable({
  providedIn: 'root'
})
export class GardenJournalService {

  private readonly url: string = `${environment.backendUrl}/journal-items`;
  private mockData: Array<JournalItem> = journalItemsMock;

  constructor(
    private http: HttpClient
  ) { }

  public getJournalItems(): Observable<Array<JournalItem>> {
    return this.http.get<Array<JournalItem>>(this.url);
  }

  public addJournalItem(journalItem: JournalItem): Observable<void> {
    return this.http.post<void>(this.url, journalItem);
  }

  public editJournalItem(journalItem: JournalItem): Observable<void> {
    return this.http.put<void>(this.url, journalItem);
  }

  public deleteJournalItem(journalItem: JournalItem): Observable<void> {
    console.warn("DELETE", this.url + '/' + journalItem.id)
    return this.http.delete<void>(this.url + '/' + journalItem.id);
  }
}
