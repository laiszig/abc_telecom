import { TestBed } from '@angular/core/testing';

import { UpdateTicketService } from './update-ticket.service';

describe('UpdateTicketService', () => {
  let service: UpdateTicketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateTicketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
