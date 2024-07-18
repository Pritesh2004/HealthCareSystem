import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NormalUserService } from 'src/app/service/normal-user.service';
import { NgxUiLoaderService } from "ngx-ui-loader"; // Import NgxUiLoaderService


@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {

  constructor(private userService: NormalUserService, private snack : MatSnackBar, private ngxService: NgxUiLoaderService){}

  public query={
    email : '',
    queries:'',
    name: '',
    subject: ''
  }
  postQuery(){
    this.ngxService.start();

    this.userService.postQueries(this.query).subscribe(
      data=>{
        console.log(data);
        this.ngxService.stop();
        const snackBarRef = this.snack.open("Message Sent Successfully..", 'ok', {
          verticalPosition: 'top'
        });
      
        snackBarRef.onAction().subscribe(() => {
          window.location.reload();
        });      },
      error=>{
        console.log(error);
        const snackBarRef = this.snack.open("Enter correct email..", 'ok', {
          verticalPosition: 'top'
        });
      
        snackBarRef.onAction().subscribe(() => {
          window.location.reload();
        });
      }
    )
  }
}
