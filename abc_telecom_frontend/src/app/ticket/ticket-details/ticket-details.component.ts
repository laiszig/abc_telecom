import { Component } from '@angular/core';
import { ListTicketsService } from '../list-tickets/list-tickets.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Ticket } from '../ticket';
import { TicketDetailsService } from './ticket-details.service';
import { tick } from '@angular/core/testing';
import { PinCode } from 'src/app/pinCode/pincode';

@Component({
  selector: 'app-ticket-details',
  templateUrl: './ticket-details.component.html',
  styleUrls: ['./ticket-details.component.css']
})
export class TicketDetailsComponent {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private ticketService: ListTicketsService,
    private ticketDetailsService: TicketDetailsService
  ) {

    this.ticket = new Ticket();
    this.ticket.pinCode = new PinCode();
  }

  ticket: Ticket;
  
  ngOnInit(): void {
    this.activatedRoute.params.subscribe(ticketId => {
      this.ticketDetailsService.getTicketById(ticketId["id"])
      .subscribe((result) => {
        this.ticket = result;
    });
  })
    
    /**
    this.activatedRoute.queryParams.subscribe((ticket: any) =>{

console.log(ticket)

      this.ticketDetailsService.getTicketById(ticket.ticketId)
        .subscribe((result) => {
          this.ticket = result;
          console.log(result)
        });

    })
    */
  }

  
}
