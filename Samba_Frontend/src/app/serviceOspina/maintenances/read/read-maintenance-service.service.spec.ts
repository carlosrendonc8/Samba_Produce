import { TestBed } from '@angular/core/testing';

import { ReadMaintenanceServiceService } from './read-maintenance-service.service';

describe('ReadMaintenanceServiceService', () => {
  let service: ReadMaintenanceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadMaintenanceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
