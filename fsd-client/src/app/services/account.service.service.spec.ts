import { TestBed } from '@angular/core/testing';

import { Account.ServiceService } from './account.service.service';

describe('Account.ServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Account.ServiceService = TestBed.get(Account.ServiceService);
    expect(service).toBeTruthy();
  });
});
