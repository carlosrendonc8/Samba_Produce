import { TestBed } from '@angular/core/testing';

import { CreateRegisterActivityServiceService } from './create-register-activity-service.service';

describe('CreateRegysterActivityServiceService', () => {
  let service: CreateRegisterActivityServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateRegisterActivityServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
