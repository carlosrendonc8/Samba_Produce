import { TestBed } from '@angular/core/testing';

import { ReadRegisterActivityServiceService } from './read-register-activity-service.service';

describe('ReadTypeMachineryServiceService', () => {
  let service: ReadRegisterActivityServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadRegisterActivityServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
