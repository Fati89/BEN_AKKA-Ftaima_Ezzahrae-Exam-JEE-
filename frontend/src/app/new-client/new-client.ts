import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ClientService} from '../services/client-service';
import {ClientModel} from '../model/client-model';

@Component({
  selector: 'app-new-client',
  imports: [],
  templateUrl: './new-client.html',
  styleUrl: './new-client.css',
})
export class NewClient {

  newClientFormGroup! : FormGroup;
  constructor(private fb : FormBuilder, private clientService:ClientService, router:Router) { }

  ngOnInit(): void {
    this.newClientFormGroup=this.fb.group({
      name : this.fb.control(null, [Validators.required, Validators.minLength(4)]),
      email : this.fb.control(null,[Validators.required, Validators.email])
    });
  }

  handleSaveClient() {
    let client:ClientModel=this.newClientFormGroup.value;
    this.clientService.saveClient(client).subscribe({
      next : data=>{
        alert("Client has been successfully saved!");
        this.router.navigateByUrl("/clients");
      },
      error : err => {
        console.log(err);
      }
    });
  }
}
