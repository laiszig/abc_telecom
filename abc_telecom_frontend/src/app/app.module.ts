import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateTicketComponent } from './create-ticket/create-ticket.component';
import { ListTicketsComponent } from './list-tickets/list-tickets.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateTicketComponent,
    ListTicketsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
