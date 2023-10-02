import { Component } from '@angular/core';
import { PincodeService } from 'src/app/pinCode/pincode.service';
import { UpdateTicketService } from './update-ticket.service';
import { ListTicketsService } from '../list-tickets/list-tickets.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Ticket } from '../ticket';
import { PinCode } from 'src/app/pinCode/pincode';
import { TicketDetailsService } from '../ticket-details/ticket-details.service';
import { ManagerService } from 'src/app/roles/manager.service';
import { EngineerService } from 'src/app/roles/engineer.service';
import { Manager } from 'src/app/roles/manager';
import { Engineer } from 'src/app/roles/engineer';

@Component({
  selector: 'app-update-ticket',
  templateUrl: './update-ticket.component.html',
  styleUrls: ['./update-ticket.component.css']
})
export class UpdateTicketComponent {

  constructor(
    private pincodeService: PincodeService,
    private updateTicketService: UpdateTicketService,
    private managerService: ManagerService,
    private engineerService: EngineerService,
    private ticketDetailsService: TicketDetailsService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  tickets: Ticket[];
  ticket: Ticket;
  pinCodes: PinCode[];
  managers: Manager[];
  engineers: Engineer[];

    form: any = {
      problemType: null,
      description: null,
      pinCode: null,
      managerAssigned:null,
      engineerAssigned: null
    };

  ngOnInit(): void {
    this.ticketDetailsService.getTicketById(this.route.snapshot.params['id'])
      .subscribe((result) => {
        this.ticket = result;
        this.form.problemType = this.ticket.problemType;
        this.form.description = this.ticket.description;
        this.form.pincode = this.ticket.pinCode;
        this.form.managerAssigned = this.ticket.managerAssigned;
        this.form.engineerAssigned = this.ticket.engineerAssigned
      });
      this.pincodeService
      .getAllPinCodes()
      .subscribe((result) => (this.pinCodes = result));
      this.engineerService
      .getAllEngineers()
      .subscribe((result) => (this.engineers = result));
      this.managerService
      .getAllManagers()
      .subscribe((result) => (this.managers = result));
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

  pinCodeSelection = (event: any) => {
    const pinCodeId = event.target.value;
    this.form.pinCodeId = pinCodeId;
  };

  managerSelection = (event: any) => {
    const managerId = event.target.value;
    this.form.managerId = managerId;
  };

  btnClick = () => {
    console.log("Movie Updated!");  
  };

}
