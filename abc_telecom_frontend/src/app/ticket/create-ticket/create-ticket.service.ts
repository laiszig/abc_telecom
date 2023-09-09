import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { Ticket } from '../ticket';

@Injectable({
  providedIn: 'root'
})
export class CreateTicketService {

  url: string = "http://localhost:8080"

  constructor(private httpClient : HttpClient) { }

  addTicket(ticket: Ticket) {
    return this.httpClient.post<any>(this.url + "/ticket/add", ticket)
    .pipe(map(result => {
      console.log("SERVICE LOG PIPE")
      console.log(result)
      return result;
    }));
  }
}
