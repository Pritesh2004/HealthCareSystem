import { User } from "./user.model";

export interface NormalUser {
  user: User;
  address: string;
  dateOfBirth: Date;
  gender: string;
}
