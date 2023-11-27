import { TestBed } from '@angular/core/testing';

import { DeleteMachineServiceService } from './delete-machine-service.service';

describe('DeleteMachineServiceService', () => {
  let service: DeleteMachineServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteMachineServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
