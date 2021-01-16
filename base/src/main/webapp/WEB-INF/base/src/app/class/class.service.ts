import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClassService {
  private classPath_ = '/assets/data/class.json';

  constructor(private http: HttpClient) { }
  getClassDetails(): Observable<any> {
    return this.http.get(this.classPath_);
  }
}
