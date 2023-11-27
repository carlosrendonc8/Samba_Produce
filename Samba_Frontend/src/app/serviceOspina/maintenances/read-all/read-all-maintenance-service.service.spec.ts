import { TestBed } from '@angular/core/testing';

import { ReadAllMaintenanceServiceService } from './read-all-maintenance-service.service';

describe('ReadAllMaintenanceServiceService', () => {
  let service: ReadAllMaintenanceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadAllMaintenanceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
