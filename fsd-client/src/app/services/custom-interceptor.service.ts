import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomInterceptorService implements HttpInterceptor {

  constructor() { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        request = request.clone(
        {
        
        	setHeaders: {
      
        withCredentials:true
      }
        
          
        }
        
        );
	
        return next.handle(request);
    }
}
