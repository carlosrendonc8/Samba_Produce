import { TestBed } from '@angular/core/testing';

import { ReadAllRegisterActivityServiceService } from './read-all-register-activity-service.service';

describe('ReadAllRegisterActivityServiceService', () => {
  let service: ReadAllRegisterActivityServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadAllRegisterActivityServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
