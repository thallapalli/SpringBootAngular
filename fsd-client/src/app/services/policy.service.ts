import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {RequestOptions, Request, RequestMethod} from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {

  constructor(private http: HttpClient) {
  }
  //fetch all policies
  getAll(): Observable<Policy> {
    return this.http.get('http://localhost:8080/fsd/readpolicies');
  }
  
  //Create Policy
    createPolicy(policy: Policy):Observable<number> {
	let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.post('http://localhost:8080/fsd/policy/save', policy, options)
               .map(success => success.status)
               .catch(this.handleError);
    }
    //Fetch Policy by id
    getPolicyByName(policyname: string): Observable<Policy> {
	let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
	let options = new RequestOptions({ headers: cpHeaders });
	return this.http.get('http://localhost:8080/fsd/policy/'+policyname+'/details')
	   .map(this.extractData)
	   .catch(this.handleError);
    }	
    //Update article
    updatePolicy(policy: Policy):Observable<number> {
	let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.put('http://localhost:8080/fsd/policy/update', policy, options)
               .map(success => success.status)
               .catch(this.handleError);
    }
   
    private extractData(res: Response) {
	let body = res.json();
        return body;
    }
    private handleError (error: Response | any) {
	console.error(error.message || error);
	return Observable.throw(error.status);
    }
  
  
}
