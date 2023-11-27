import { TestBed } from '@angular/core/testing';

import { ReadAllMachineServiceService } from './read-all-machine-service.service';

describe('ReadAllMachineServiceService', () => {
  let service: ReadAllMachineServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadAllMachineServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
