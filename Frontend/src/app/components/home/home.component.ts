import { Component } from '@angular/core';
import { DoctorService } from 'src/app/service/doctor.service';
import { DoctorSpecialization } from '../models/doctorSpecialization.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  
  doctorSpecs: DoctorSpecialization[] = [];

  constructor(private doctorService : DoctorService){
  }

  ngOnInit(): void {
    this.getDoctorSpecs();
  }

  getDoctorSpecs(){
    this.doctorService.getAllDoctorSpec().subscribe(
      data=>{
        this.doctorSpecs = data;
        console.log(this.doctorSpecs);
      },
      error=>{
        console.log(error);
      }
    )
  }
}
