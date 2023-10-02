import { Injectable } from '@angular/core';
import { Manager } from './manager';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  url: string = 'http://localhost:8080/manager'

  constructor(private http: HttpClient) {}

  getAllManagers(): Observable<Manager[]> {
    return this.http.get<Manager[]>(this.url);
  }
}
