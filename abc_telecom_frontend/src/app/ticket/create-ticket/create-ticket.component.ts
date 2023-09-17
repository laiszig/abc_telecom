import { Component } from '@angular/core';
import { Ticket } from '../ticket';
import { CreateTicketService } from './create-ticket.service';
import { PincodeService } from 'src/app/pinCode/pincode.service';
import { PinCode } from 'src/app/pinCode/pincode';

@Component({
  selector: 'app-create-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})
export class CreateTicketComponent {
  constructor(
    private pinCodeService: PincodeService,
    private createTicketService: CreateTicketService
  ) {}

  tickets: Ticket[];
  pinCodes: PinCode[];

    form: any = {
      status: null,
      problemType: null,
      description: null,
      pinCodeId: null,
    };

  ngOnInit(): void {
      this.pinCodeService
      .getAllPinCodes()
      .subscribe((result) => (this.pinCodes = result));
  }

  onSubmit() {
    console.log(this.form);
    this.createTicketService.addTicket(this.form)

    .subscribe(
      data => {
        console.log("Processed")
      },
      error => {
        console.log("Error processing")
        console.log(error)
      });
  }

  btnClick = () => {
    console.log("Ticket created!");
  };

  pinCodeSelection = (event: any) => {
    const pinCodeId = event.target.value;

    this.form.pinCodeId = pinCodeId;
  };
}
