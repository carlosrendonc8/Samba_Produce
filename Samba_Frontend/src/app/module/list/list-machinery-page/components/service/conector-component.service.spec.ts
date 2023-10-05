import { TestBed } from '@angular/core/testing';

import { ConectorComponentService } from './conector-component.service';

describe('ConectorComponentService', () => {
  let service: ConectorComponentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConectorComponentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
