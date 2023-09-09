import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from '../ticket';
import { Status } from '../status';

@Injectable({
  providedIn: 'root'
})
export class ListTicketsService {

  url: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  //get all tickets
  getAllTickets(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(this.url + "/ticket");
  }

  getTicketsByStatus(id: any): Observable<Ticket[]> {
    return this.http.post<Ticket[]>(this.url + "/ticket/status", {"status" : Status})
  }
}
