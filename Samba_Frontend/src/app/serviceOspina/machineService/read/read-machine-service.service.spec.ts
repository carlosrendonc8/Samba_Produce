import { TestBed } from '@angular/core/testing';

import { ReadMachineServiceService } from './read-machine-service.service';

describe('ReadMachineServiceService', () => {
  let service: ReadMachineServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadMachineServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
