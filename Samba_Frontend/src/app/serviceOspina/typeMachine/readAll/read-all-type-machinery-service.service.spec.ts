import { TestBed } from '@angular/core/testing';

import { ReadAllTypeMachineryServiceService } from './read-all-type-machinery-service.service';

describe('ReadAllTypeMachineryServiceService', () => {
  let service: ReadAllTypeMachineryServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadAllTypeMachineryServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
