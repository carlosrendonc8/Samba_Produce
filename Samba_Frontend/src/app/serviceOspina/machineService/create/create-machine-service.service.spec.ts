import { TestBed } from '@angular/core/testing';

import { CreateMachineServiceService } from './create-machine-service.service';

describe('CreateMachineServiceService', () => {
  let service: CreateMachineServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateMachineServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
