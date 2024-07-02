import { Component } from '@angular/core';
import { NormalUserService } from 'src/app/service/normal-user.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {

  constructor(private userService: NormalUserService){}

  public query={
    email : '',
    queries:'',
    name: '',
    subject: ''
  }
  postQuery(){
    this.userService.postQueries(this.query).subscribe(
      data=>{
        console.log(data);
        alert("Query posted successfully")
      },
      error=>{
        console.log(error);
      }
    )
  }
}
