import { TestBed } from '@angular/core/testing';

import { NormalUserGuard } from './normal-user.guard';

describe('NormalUserGuard', () => {
  let guard: NormalUserGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(NormalUserGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
