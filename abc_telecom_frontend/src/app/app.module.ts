import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateTicketComponent } from './ticket/create-ticket/create-ticket.component';
import { ListTicketsComponent } from './ticket/list-tickets/list-tickets.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UpdateTicketComponent } from './ticket/update-ticket/update-ticket.component';
import { TicketDetailsComponent } from './ticket/ticket-details/ticket-details.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SecurityInterceptorService } from './security-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    CreateTicketComponent,
    ListTicketsComponent,
    UpdateTicketComponent,
    TicketDetailsComponent,
    RegisterComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: SecurityInterceptorService, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
