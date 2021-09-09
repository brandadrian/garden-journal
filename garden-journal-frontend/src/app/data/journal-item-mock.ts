import { JournalItem } from "./journal-item.interface";

export const journalItemsMock: Array<JournalItem> = [
    {id:1,description:"Das Gemüse wächst gut", date: new Date(2021, 4, 1, 9, 10), title: "Gemüse wächst!!!!"},
    {id:1,description:"Schnecken haben das Beet erobert", date: new Date(2021, 7, 11, 6, 33), title: "Schnecken"},
    {id:1,description:"Die Erdbeeren können geerntet werden", date: new Date(2021, 9, 29, 16, 23), title: "Erbeeren erntereif"}];