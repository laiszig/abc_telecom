import { Component, OnInit } from '@angular/core';
import { ListTicketsService } from './list-tickets.service';
import { PincodeService } from 'src/app/pinCode/pincode.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Ticket } from '../ticket';
import { PinCode } from 'src/app/pinCode/pincode';
import { Status } from '../status';

@Component({
  selector: 'app-list-tickets',
  templateUrl: './list-tickets.component.html',
  styleUrls: ['./list-tickets.component.css']
})
export class ListTicketsComponent implements OnInit{

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private listTicketService: ListTicketsService,
    private pinCodeService: PincodeService,
  ) {}

  tickets: Ticket[];
  pinCodes: PinCode[];
  statuses: Status[];
  filters = {
    keyword: ''
  }

  ngOnInit(): void {
    this.listTicketService
      .getAllTickets()
      .subscribe((result) => {
        console.log(result)

        this.tickets = result
      });
      this.pinCodeService
      .getAllPinCodes()
      .subscribe((result) => (this.pinCodes = result));
  }

  listTickets() {
    this.listTicketService.getAllTickets().subscribe(
      data => this.tickets = this.filterTickets(data)
    )
  }

  filterTickets(tickets: Ticket[]) {
    return tickets.filter((m) => {
      return (m.problemType.toLowerCase().includes(this.filters.keyword.toLowerCase()) || 
      m.status.toString().toLowerCase().includes(this.filters.keyword.toLowerCase()));
    })
  }  

  statusSelection = (event: any) => {
    const status = event.target.value;
    if (status != 0) {
      this.listTicketService
      .getTicketsByStatus(status)
      .subscribe((result) => (this.tickets = result));
    } else {
      this.listTicketService
      .getAllTickets()
      .subscribe((result) => (this.tickets = result));
    }
  }

}
