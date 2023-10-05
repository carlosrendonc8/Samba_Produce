import { TestBed } from '@angular/core/testing';

import { ReadTypeMachinaryIdService } from './read-type-machinary-id.service';

describe('ReadTypeMachinaryIdService', () => {
  let service: ReadTypeMachinaryIdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadTypeMachinaryIdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
