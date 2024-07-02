import { Doctor } from './doctor.model';
import { Specialization } from './specialization.model';

export interface DoctorSpecialization {
  doctor: Doctor;
  specialization: Specialization;
}
