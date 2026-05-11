import { Component } from '@angular/core';
import {catchError, map, Observable, throwError} from 'rxjs';
import {FormBuilder, FormGroup, ReactiveFormsModule} from '@angular/forms';
import {ClientModel} from '../model/client-model';
import {ClientService} from '../services/client-service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-client',
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './client.html',
  styleUrl: './client.css',
})
export class Client {


  clients! : Observable<Array<ClientModel>>;
  errorMessage!: string;
  searchFormGroup!: FormGroup;
  constructor(private clientService : ClientService, private fb : FormBuilder) { }

  ngOnInit(): void {
    this.searchFormGroup=this.fb.group({
      keyword : this.fb.control("")
    });
    this.handleSearchClients();
  }


  handleSearchClients() {
    let kw=this.searchFormGroup?.value.keyword;
    this.clients=this.clientService.searchClients(kw).pipe(
      catchError(err => {
        this.errorMessage=err.message;
        return throwError(err);
      })
    );
  }

  handleDeleteClient(c: ClientModel) {
    let conf = confirm("Are you sure?");
    if(!conf) return;
    this.clientService.deleteClient(c.id).subscribe({
      next : (resp) => {
        this.clients=this.clients.pipe(
          map(data=>{
            let index=data.indexOf(c);
            data.slice(index,1)
            return data;
          })
        );
      },
      error : err => {
        console.log(err);
      }
    })
  }

}

