import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListTicketsComponent } from './ticket/list-tickets/list-tickets.component';
import { CreateTicketComponent } from './ticket/create-ticket/create-ticket.component';
import { UpdateTicketComponent } from './ticket/update-ticket/update-ticket.component';
import { TicketDetailsComponent } from './ticket/ticket-details/ticket-details.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {"path":"ticket", component: ListTicketsComponent},
  {"path":"ticket/add", component: CreateTicketComponent},
  {"path":"ticket/update/:id", component:UpdateTicketComponent},
  {"path":"ticket/details/:id", component:TicketDetailsComponent},
  // {"path":"ticket/:id", component:TicketDetailsComponent}
  {"path":"register",component:RegisterComponent},
  {"path":"login",component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
