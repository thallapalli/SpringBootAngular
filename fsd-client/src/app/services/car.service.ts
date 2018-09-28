import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  public API ='//localhost:3000';
  public CAR_API = this.API+'/cars';

  constructor(private http: HttpClient) {
  }
  getAll(): Observable<any> {
    return this.http.get(this.API+'/cool-cars');
  }
  get(id: string) {
    return this.http.get(this.API+'/'+id);
  }
  save(car: any): Observable<any> {
    let result: Observable<Object>;
    if (car['href']) {
      result = this.http.put(car.href, car);
    } else {
      result = this.http.post(this.API, car);
    }
    return result;
  }
}
