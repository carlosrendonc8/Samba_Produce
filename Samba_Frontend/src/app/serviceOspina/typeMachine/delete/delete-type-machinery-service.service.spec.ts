import { TestBed } from '@angular/core/testing';

import { DeleteTypeMachineryServiceService } from './delete-type-machinery-service.service';

describe('DeleteTypeMachineryServiceService', () => {
  let service: DeleteTypeMachineryServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteTypeMachineryServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
