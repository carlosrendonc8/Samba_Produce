import { TestBed } from '@angular/core/testing';

import { UpdateMaintenanceServiceService } from './update-maintenance-service.service';

describe('UpdateMaintenanceServiceService', () => {
  let service: UpdateMaintenanceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateMaintenanceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
