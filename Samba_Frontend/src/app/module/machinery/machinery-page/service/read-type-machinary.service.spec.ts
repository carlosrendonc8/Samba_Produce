import { TestBed } from '@angular/core/testing';

import { ReadTypeMachinaryService } from './read-type-machinary.service';

describe('ReadTypeMachinaryIdService', () => {
  let service: ReadTypeMachinaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadTypeMachinaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
