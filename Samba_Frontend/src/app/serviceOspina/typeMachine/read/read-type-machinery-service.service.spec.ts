import { TestBed } from '@angular/core/testing';

import { ReadTypeMachineryServiceService } from './read-type-machinery-service.service';

describe('ReadTypeMachineryServiceService', () => {
  let service: ReadTypeMachineryServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadTypeMachineryServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
