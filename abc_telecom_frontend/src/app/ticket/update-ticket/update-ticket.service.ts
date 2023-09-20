import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from '../ticket';

@Injectable({
  providedIn: 'root'
})
export class UpdateTicketService {

  url: string = "http://localhost:8080"

  constructor(private httpClient : HttpClient) { }

  updateTicket(id: number, ticket: Ticket): Observable<Ticket> {
    const updateUrl = `${this.url}/ticket/update/${id}`;
    return this.httpClient.put<Ticket>(updateUrl, ticket);
}

}
