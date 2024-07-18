import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule
import { MatTableModule } from '@angular/material/table';
import { MatListModule } from '@angular/material/list'; // Import MatListModule
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select'; // Import MatSelectModule
import { MatOptionModule } from '@angular/material/core'; // Import MatOptionModule
import { MatInputModule } from '@angular/material/input';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatRadioModule } from '@angular/material/radio';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatToolbarModule } from '@angular/material/toolbar';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatMenuModule} from '@angular/material/menu';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './components/signup/signup.component';
import { UserDashboardComponent } from './components/normalUser/user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './components/admin/admin-dashboard/admin-dashboard.component';
import { DoctorDashboardComponent } from './components/doctor/doctor-dashboard/doctor-dashboard.component';
import { AddDoctorComponent } from './components/admin/add-doctor/add-doctor.component';
import { AddSpecializationComponent } from './components/admin/add-specialization/add-specialization.component';
import { DoctorAppointmentsComponent } from './components/doctor/doctor-appointments/doctor-appointments.component';
import { UserAppointmentsComponent } from './components/normalUser/user-appointments/user-appointments.component';
import { FooterComponent } from './components/footer/footer.component';
import { DoctorDetailsComponent } from './components/doctor/doctor-details/doctor-details.component';
import { UserProfileComponent } from './components/normalUser/user-profile/user-profile.component';
import { AdminProfileComponent } from './components/admin/admin-profile/admin-profile.component';
import { DoctorProfileComponent } from './components/doctor/doctor-profile/doctor-profile.component';
import { ContactComponent } from './components/contact/contact.component';
import {  NgxUiLoaderHttpModule, NgxUiLoaderModule } from "ngx-ui-loader";
import { AboutComponent } from './components/about/about.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    SignupComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    DoctorDashboardComponent,
    AddDoctorComponent,
    AddSpecializationComponent,
    DoctorAppointmentsComponent,
    UserAppointmentsComponent,
    FooterComponent,
    DoctorDetailsComponent,
    UserProfileComponent,
    AdminProfileComponent,
    DoctorProfileComponent,
    ContactComponent,
    AboutComponent
  ],
  imports: [
    MatSelectModule,
    MatSidenavModule,
    MatMenuModule,
    HttpClientModule,
    NgxUiLoaderModule,
    MatIconModule,
    // NgxUiLoaderHttpModule.forRoot({
    //   showForeground:true
    // }),
    MatProgressSpinnerModule,
    FormsModule,
    MatInputModule,
    MatRadioModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatTableModule,
    MatListModule,
    BrowserModule,
    BrowserModule,
    AppRoutingModule,
    MatOptionModule,
    MatFormFieldModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
