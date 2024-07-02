import { AppointmentStatus } from "./appointmentStatus.enum";
import { Doctor } from "./doctor.model";
import { NormalUser } from "./normalUser.model";

export interface Appointment {
    user: NormalUser;
    doctor: Doctor;
    appointmentDate: Date;
    appointmentTime: string;
    bookingDate: Date;
    status: AppointmentStatus;
    reason: string;
  }