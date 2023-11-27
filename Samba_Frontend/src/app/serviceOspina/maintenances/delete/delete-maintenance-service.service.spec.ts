import { TestBed } from '@angular/core/testing';

import { DeleteMaintenanceServiceService } from './delete-maintenance-service.service';

describe('DeleteMaintenanceServiceService', () => {
  let service: DeleteMaintenanceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteMaintenanceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
