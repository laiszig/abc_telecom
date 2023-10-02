import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Engineer } from './engineer';

@Injectable({
  providedIn: 'root'
})
export class EngineerService {

  url: string = 'http://localhost:8080/engineer'

  constructor(private http: HttpClient) {}

  getAllEngineers(): Observable<Engineer[]> {
    return this.http.get<Engineer[]>(this.url);
  }
}
