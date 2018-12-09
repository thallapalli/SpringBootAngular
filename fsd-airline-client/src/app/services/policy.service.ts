import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions,Request, RequestMethod } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Policy} from "../model/policy.model";
@Injectable({
  providedIn: 'root'
})
export class PolicyService {
  constructor(private http: Http) {
  }
  //fetch all policies
  
  getAllPolicies(): Observable<Policy[]> {
   let headers = new Headers();
    
    headers.append('Accept', 'application/json')
    // creating base64 encoded String from user name and password
    var pwd= localStorage.getItem('pwd');
     var usr=localStorage.getItem('user');
    var localst= localStorage.getItem('currentUser');
     var base64Credential: string = btoa(usr + ':' + pwd);
    headers.append("Authorization", "Basic " + base64Credential);
    let options = new RequestOptions();
    options.headers=headers;
    return this.http.get('http:localhost:8080/fsd/fetchallbookings',options).map(this.extractData)
	   .catch(this.handleError);;
  }
  
 //Create article
    createPolicy(policy: Policy):Observable<number> {
	 let headers = new Headers();
     headers.append('Accept', 'application/json')
    // creating base64 encoded String from user name and password
    var pwd= localStorage.getItem('pwd');
     var usr=localStorage.getItem('user');
    var localst= localStorage.getItem('currentUser');
     var base64Credential: string = btoa(usr + ':' + pwd);
    headers.append("Authorization", "Basic " + base64Credential);
    let options = new RequestOptions();
    options.headers=headers;
    
        return this.http.put('http://localhost:8080/fsd/policy/save', policy, options)
               .map(success => success.status)
               .catch(this.handleError);
    }
    //Fetch article by id
    getPolicyById(Id: number): Observable<Policy> {
	let headers = new Headers();
     headers.append('Accept', 'application/json')
    // creating base64 encoded String from user name and password
    var pwd= localStorage.getItem('pwd');
     var usr=localStorage.getItem('user');
    var localst= localStorage.getItem('currentUser');
     var base64Credential: string = btoa(usr + ':' + pwd);
    headers.append("Authorization", "Basic " + base64Credential);
    let options = new RequestOptions();
    options.headers=headers;
    
	return this.http.get('http://localhost:8080/fsd/policy' +"/"+Id+'/details',options)
	   .map(this.extractData)
	   .catch(this.handleError);
    }	
    //Update article
    updatePolicy(policy: Policy):Observable<number> {
	let headers = new Headers();
     headers.append('Accept', 'application/json')
    // creating base64 encoded String from user name and password
    var pwd= localStorage.getItem('pwd');
     var usr=localStorage.getItem('user');
    var localst= localStorage.getItem('currentUser');
     var base64Credential: string = btoa(usr + ':' + pwd);
    headers.append("Authorization", "Basic " + base64Credential);
    let options = new RequestOptions();
    options.headers=headers;
        return this.http.post('http://localhost:8080/fsd/policy/update', policy, options)
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
