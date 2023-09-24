import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Ticket } from '../ticket';
import { TicketDetailsService } from './ticket-details.service';
import { PinCode } from 'src/app/pinCode/pincode';
import { Engineer } from 'src/app/roles/engineer';

@Component({
  selector: 'app-ticket-details',
  templateUrl: './ticket-details.component.html',
  styleUrls: ['./ticket-details.component.css']
})
export class TicketDetailsComponent {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private ticketDetailsService: TicketDetailsService
  ) {

    this.ticket = new Ticket();
    this.ticket.pinCode = new PinCode();
    this.ticket.engineerAssigned = new Engineer();
  }

  ticket: Ticket;
  
  ngOnInit(): void {
    this.activatedRoute.params.subscribe(ticketId => {
      this.ticketDetailsService.getTicketById(ticketId["id"])
      .subscribe((result) => {
        this.ticket = result;
        console.log(this.ticket)
    });
  })}
  
}
