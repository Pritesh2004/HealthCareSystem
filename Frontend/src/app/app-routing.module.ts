import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { UserDashboardComponent } from './components/normalUser/user-dashboard/user-dashboard.component';
import { NormalUserGuard } from './service/auth/normal-user.guard';
import { AdminDashboardComponent } from './components/admin/admin-dashboard/admin-dashboard.component';
import { AdminGuard } from './service/auth/admin.guard';
import { DoctorDashboardComponent } from './components/doctor/doctor-dashboard/doctor-dashboard.component';
import { DoctorGuard } from './service/auth/doctor.guard';
import { AddSpecializationComponent } from './components/admin/add-specialization/add-specialization.component';
import { AddDoctorComponent } from './components/admin/add-doctor/add-doctor.component';
import { UserAppointmentsComponent } from './components/normalUser/user-appointments/user-appointments.component';
import { DoctorAppointmentsComponent } from './components/doctor/doctor-appointments/doctor-appointments.component';
import { UserProfileComponent } from './components/normalUser/user-profile/user-profile.component';
import { DoctorProfileComponent } from './components/doctor/doctor-profile/doctor-profile.component';
import { AdminProfileComponent } from './components/admin/admin-profile/admin-profile.component';
import { ContactComponent } from './components/contact/contact.component';
import { DoctorDetailsComponent } from './components/doctor/doctor-details/doctor-details.component';
import { AboutComponent } from './components/about/about.component';

const routes: Routes = [

  {
    path:'',
    component:HomeComponent
  },

  {
    path: 'login',
    component : LoginComponent
  },

  {
    path : 'signup',
    component : SignupComponent
  },
  {
    path : 'userDashboard',
    component : UserDashboardComponent,
    canActivate : [NormalUserGuard]
  },
  {
    path : 'userAppointments',
    component : UserAppointmentsComponent,
    canActivate : [NormalUserGuard]
  },
  {
    path : 'userProfile',
    component: UserProfileComponent,
    canActivate : [NormalUserGuard]
  },

  {
    path : 'doctorProfile',
    component: DoctorProfileComponent,
    canActivate : [DoctorGuard]
  },
  {
    path : 'adminProfile',
    component: AdminProfileComponent,
    canActivate : [AdminGuard]
  },
  {

    path : 'adminDashboard',
    component : AdminDashboardComponent,
    canActivate : [AdminGuard]
  },
  {
    path : 'addSpecialization',
    component : AddSpecializationComponent,
    canActivate : [AdminGuard]
  },
  {
    path : 'addDoctor',
    component : AddDoctorComponent,
    canActivate : [AdminGuard]
  },
  {
    path : 'doctorAppointments',
    component : DoctorAppointmentsComponent,
    canActivate : [DoctorGuard]
  },
  {
    path : 'doctorDashboard',
    component : DoctorDashboardComponent,
    canActivate : [DoctorGuard]
  },
  {
    path : 'doctors',
    component : DoctorDetailsComponent
  },
  {
    path: 'about',
    component : AboutComponent
  },
  {
    path: 'contact',
    component : ContactComponent,
  }

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
