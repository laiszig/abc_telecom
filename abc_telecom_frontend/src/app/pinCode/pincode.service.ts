import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PinCode } from './pincode';

@Injectable({
  providedIn: 'root'
})
export class PincodeService {

  url: string = 'http://localhost:8080/pincode'

  constructor(private http: HttpClient) {}

  getAllPinCodes(): Observable<PinCode[]> {
    return this.http.get<PinCode[]>(this.url);
  }

}
