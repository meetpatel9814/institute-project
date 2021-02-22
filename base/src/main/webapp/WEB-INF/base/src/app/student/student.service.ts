import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private studentPath_ = '/assets/data/attendanceDetail.json';

  constructor(private http: HttpClient) { }
  getStudentDetails(): Observable<any> {
    return this.http.get(this.studentPath_);
  }
}
