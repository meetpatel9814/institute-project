import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  private menuPath_ = '/assets/data/menu.json';
  
  constructor(private http: HttpClient) { }

  public getMenus(): Observable<any> {
    return this.http.get(this.menuPath_);
  }
}
