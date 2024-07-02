import { User } from "./user.model";

export interface Doctor {
  user: User;
  licenseNumber: string;
  clinicAddress: string;
  yearsOfExperience: number;
  bio: string;
}
