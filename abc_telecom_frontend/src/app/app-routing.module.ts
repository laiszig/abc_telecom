import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListTicketsComponent } from './ticket/list-tickets/list-tickets.component';
import { CreateTicketComponent } from './ticket/create-ticket/create-ticket.component';
import { UpdateTicketComponent } from './ticket/update-ticket/update-ticket.component';

const routes: Routes = [
  {"path":"ticket", component: ListTicketsComponent},
  {"path":"ticket/add", component: CreateTicketComponent},
  {"path":"ticket/update/:id", component:UpdateTicketComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
