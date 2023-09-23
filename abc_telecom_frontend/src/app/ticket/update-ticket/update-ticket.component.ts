import { Component } from '@angular/core';
import { PincodeService } from 'src/app/pinCode/pincode.service';
import { UpdateTicketService } from './update-ticket.service';
import { ListTicketsService } from '../list-tickets/list-tickets.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Ticket } from '../ticket';
import { PinCode } from 'src/app/pinCode/pincode';
import { TicketDetailsService } from '../ticket-details/ticket-details.service';

@Component({
  selector: 'app-update-ticket',
  templateUrl: './update-ticket.component.html',
  styleUrls: ['./update-ticket.component.css']
})
export class UpdateTicketComponent {

  constructor(
    private pincodeService: PincodeService,
    private updateTicketService: UpdateTicketService,
    private ticketService: ListTicketsService,
    private ticketDetailsService: TicketDetailsService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  tickets: Ticket[];
  ticket: Ticket;
  pinCodes: PinCode[];

    form: any = {
      problemType: null,
      description: null,
      pinCode: null,
    };

  ngOnInit(): void {
    this.ticketDetailsService.getTicketById(this.route.snapshot.params['id'])
      .subscribe((result) => {
        this.ticket = result;
        this.form.problemType = this.ticket.problemType;
        this.form.description = this.ticket.description;
        this.form.pincode = this.ticket.pinCode;
      });
  }

  onSubmit() {
    console.log(this.form);
    const id = this.ticket.id;
    this.updateTicketService.updateTicket(id, this.form)

    .subscribe(
      data => {
        console.log("Processed")
        this.router.navigate(['/ticket']);
      },
      error => {
        console.log("Error processing")
        console.log(error)
      }
    );
  }

  btnClick = () => {
    console.log("Movie Updated!");
  };

}
