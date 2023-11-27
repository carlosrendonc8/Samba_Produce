import { TestBed } from '@angular/core/testing';

import { UpdateRegisterActivityServiceService } from './update-register-activity-service.service';

describe('UpdateRegisterActivityServiceService', () => {
  let service: UpdateRegisterActivityServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateRegisterActivityServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
