import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ListTicketsService } from '../list-tickets/list-tickets.service';
import { Ticket } from '../ticket';

@Injectable({
  providedIn: 'root'
})
export class TicketDetailsService {

  url: string = 'http://localhost:8080';
  

  constructor(private http: HttpClient, private router: Router, private ticketService: ListTicketsService) { }

  getTicketById(id: number): Observable<Ticket> {
    console.log(id)
    return this.http.get<Ticket>(this.url + "/ticket/" + id);
  }

}
