import { Role } from "./role.enum";

export interface User {
  username: string;
  password: string;
  email: string;
  firstName: string;
  lastName: string;
  phoneNumber: string;
  role: Role;
}
