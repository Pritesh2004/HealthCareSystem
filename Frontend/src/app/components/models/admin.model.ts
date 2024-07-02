import { User } from "./user.model";

export interface Admin {
  user: User;
  gender: string;
  position: string;
}
