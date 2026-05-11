import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ClientModel} from '../model/client-model';


@Injectable({
  providedIn: 'root',
})
export class ClientService {

  backendHost = "http://localhost:8085";
  constructor(private http:HttpClient) { }

  public getClients():Observable<Array<ClientModel>>{
    return this.http.get<Array<ClientModel>>(this.backendHost+"/clients")
  }
  public searchClients(keyword : string):Observable<Array<ClientModel>>{
    return this.http.get<Array<ClientModel>>(this.backendHost+"/clients/search?keyword="+keyword)
  }

  public saveClient(client: ClientModel):Observable<ClientModel>{
    return this.http.post<ClientModel>(this.backendHost+"/clients",client);
  }
  public deleteClient(id: number){
    return this.http.delete(this.backendHost+"/clients/"+id);
  }
}
