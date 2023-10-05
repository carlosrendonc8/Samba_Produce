import { TestBed } from '@angular/core/testing';

import { ReadListMachineryService } from './read-list-machinery.service';

describe('ReadListMachineryService', () => {
  let service: ReadListMachineryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadListMachineryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
