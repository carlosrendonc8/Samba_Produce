import { TestBed } from '@angular/core/testing';

import { CreateMaintenanceServiceService } from './create-maintenance-service.service';

describe('CreateMaintenanceServiceService', () => {
  let service: CreateMaintenanceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateMaintenanceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
