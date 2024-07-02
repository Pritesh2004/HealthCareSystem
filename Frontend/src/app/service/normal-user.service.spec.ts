import { TestBed } from '@angular/core/testing';

import { NormalUserService } from './normal-user.service';

describe('NormalUserService', () => {
  let service: NormalUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NormalUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
