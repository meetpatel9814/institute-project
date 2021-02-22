import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClassService } from '../class/class.service';
import { DIVISION_LIST, STD_LIST, STREAM_LIST } from '../util/CommonConstants';
import { GridDetail } from '../util/GridDetails';
import { StudentService } from './attendanceDetail.service';

@Component({
  selector: 'app-attendanceDetail',
  templateUrl: './attendanceDetail.component.html',
  styleUrls: ['./attendanceDetail.component.css']
})
export class StudentComponent implements OnInit {

  form: FormGroup;
  studentList: any;
  isAddClicked = false;
  classList = [];


  displayedDetails = [{ columnId: 'rollNumber', displayName: 'Roll Number',  isCallBackElement :true , callBackEventName: "viewStudent"},
  { columnId: 'fullName', displayName: 'Full Name' },
  { columnId: 'gender', displayName: 'Gender' },
  { columnId: 'className', displayName: 'Class', isNestedValue:true,  nestedColmunPath:"class.fullName"},
  { columnId: 'streamName', displayName: 'Stream', isNestedValue:true,  nestedColmunPath:"class.stream" }];

  plainStudentDetailObj = {
    "fName": "",
    "lName": "",
    "mName": "",
    "rollNumber": "",
    "gender": "",
    "classId" : "",
};
studentDetailObj = this.plainStudentDetailObj;

  gridDetail = new GridDetail();

  constructor(private fb: FormBuilder, private attendanceService: StudentService, private router: Router, private activatedRoute: ActivatedRoute,
    private classService: ClassService) { }


  ngOnInit(): void {
    this.getClassList();
    this.form = this.fb.group({
      fName: ['', Validators.required],
      lName: ['', Validators.required],
      mName: ['', Validators.required],
      rollNumber: ['', Validators.required],
      gender: ['', Validators.required],
      classId: ['', Validators.required]
    });
  }

  ngAfterViewInit(): void {

  }

  applyFilter(event) {
    //const filterValue = (event.target as HTMLInputElement).value;
    //this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  submit() {
    console.log(this.studentDetailObj)
    console.log(this.form.value)
  }

  selectedRecordCallBack(selectedRecordData) {
    let selectedRecord = selectedRecordData.rowObj;
    const eventName = selectedRecordData.eventName;
    switch(eventName) {
      case 'edit':
        this.editDetail(selectedRecord);
        break
      case 'viewStudent':
        this.viewStudentDetail(selectedRecord);
        break
    }


  }
  viewStudentDetail(selectedRecord: any) {
    this.router.navigate(['../attendanceDetail/'+selectedRecord.class.fullName+'/'+selectedRecord.rollNumber], {relativeTo : this.activatedRoute});
  }

  editDetail(selectedRecord) {
    console.log(selectedRecord);
    this.studentDetailObj = selectedRecord;
    this.isAddClicked= true
    this.form.setValue({
    "fName": selectedRecord.fName,
    "lName": selectedRecord.lName,
    "mName": selectedRecord.mName,
    "rollNumber": selectedRecord.rollNumber,
    "gender": selectedRecord.gender,
    "classId" : selectedRecord.class.id

    });
  }

  cancelForm(){
    this.isAddClicked= false;
    this.form.setValue(this.plainStudentDetailObj);
  }

  onClassChange(classFullName) {
    this.getStudentDetails(classFullName)
  }

  /**
   * to Retrive menu list
   */
  private getStudentDetails(classFullName: string) {
    this.attendanceService.getStudentDetails().subscribe(data => {
      this.studentList = data.content;
      this.gridDetail.gridData = data.content;
      this.gridDetail.displayColumnDetails = this.displayedDetails;
    });
  }


  private getClassList() {
    this.classService.getClassDetails().subscribe(data => {
      this.classList = data.content;
      this.getStudentDetails(this.classList[0].fullName);
    });
  }
}
