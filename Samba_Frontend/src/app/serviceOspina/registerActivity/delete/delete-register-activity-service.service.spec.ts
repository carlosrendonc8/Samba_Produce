import { TestBed } from '@angular/core/testing';

import { DeleteRegisterActivityServiceService } from './delete-register-activity-service.service';

describe('DeleteRegisterActivityServiceService', () => {
  let service: DeleteRegisterActivityServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteRegisterActivityServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
