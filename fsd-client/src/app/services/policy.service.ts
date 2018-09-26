import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import {AppComponent} from "../app.component";

@Injectable({
  providedIn: 'root'
})
export class PolicyService {

  constructor(private http: HttpClient) { }
  getPolicy() {
  return this.http.get(AppComponent.API_URL+"/fsd/policy/test/details");
}
}
