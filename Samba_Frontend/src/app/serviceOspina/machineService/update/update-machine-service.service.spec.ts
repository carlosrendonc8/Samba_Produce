import { TestBed } from '@angular/core/testing';

import { UpdateMachineServiceService } from './update-machine-service.service';

describe('UpdateMachineServiceService', () => {
  let service: UpdateMachineServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateMachineServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
