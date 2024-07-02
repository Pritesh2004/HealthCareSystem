import { Component, Input, OnInit } from '@angular/core';
import { DoctorService } from 'src/app/service/doctor.service';
import { DoctorSpecialization } from '../../models/doctorSpecialization.model';

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit{

  doctorSpecs: any[] = [];


  ngOnInit(): void {
    this.getAllDoctorSpec();
  }
  constructor(private doctorService : DoctorService){}

  getAllDoctorSpec() {

    this.doctorService.getAllDoctorSpec().subscribe(
      data => {
        this.doctorSpecs = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    )
  }
}