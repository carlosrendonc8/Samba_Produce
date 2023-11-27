import { TestBed } from '@angular/core/testing';

import { CreateTypeMachineryServiceService } from './create-type-machinery-service.service';

describe('CreateTypeMachineryServiceService', () => {
  let service: CreateTypeMachineryServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateTypeMachineryServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
