import { TestBed } from '@angular/core/testing';

import { DoctorGuard } from './doctor.guard';

describe('NormalUserGuard', () => {
  let guard: DoctorGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(DoctorGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
