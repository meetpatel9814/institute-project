import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-attendanceDetail-view',
  templateUrl: './attendanceDetail-view.component.html',
  styleUrls: ['./attendanceDetail-view.component.css']
})
export class StudentViewComponent implements OnInit {
  className: String;
  rollNumber: String;
  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.className = this.activatedRoute.snapshot.paramMap.get('className');
    this.rollNumber = this.activatedRoute.snapshot.paramMap.get('rollNumber');
    console.log();
  }

}
