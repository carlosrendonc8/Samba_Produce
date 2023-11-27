import { TestBed } from '@angular/core/testing';

import { BringAllMachinesEnableForTypeMachineTypeMachineServiceService } from './bring-all-machines-enable-for-type-machine-type-machine-service.service';

describe('BringAllMachinesEnableForTypeMachineTypeMachineServiceService', () => {
  let service: BringAllMachinesEnableForTypeMachineTypeMachineServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BringAllMachinesEnableForTypeMachineTypeMachineServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
