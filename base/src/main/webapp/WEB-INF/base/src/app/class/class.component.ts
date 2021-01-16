import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonConstants, DIVISION_LIST, STD_LIST, STREAM, STREAM_LIST } from '../util/CommonConstants';
import { GridDetail } from '../util/GridDetails';
import { ClassService } from './class.service';





@Component({
  selector: 'app-class',
  templateUrl: './class.component.html',
  styleUrls: ['./class.component.css']
})
export class ClassComponent implements OnInit, AfterViewInit  {
  form: FormGroup;
  classDetailsList: any;
  isAddClicked = false;
  streamList = STREAM_LIST;
  stdList = STD_LIST;
  divList = DIVISION_LIST;
  
  displayedDetails = [{ columnId: 'id', displayName: 'Id' },
  { columnId: 'fullName', displayName: 'Full Name' },
  { columnId: 'div', displayName: 'Division' },
  { columnId: 'std', displayName: 'Std' },
  { columnId: 'stream', displayName: 'Stream' }];
  classDetailObj = {
    "id": 0,
    "fullName": "",
    "div": "",
    "std": "",
    "stream": ""
  };

  gridDetail = new GridDetail();
  
  constructor(private fb: FormBuilder, private classService: ClassService) { }
  

  ngOnInit(): void {
    this.getClassDetails();
    this.form = this.fb.group({
      std: ['', Validators.required],
      div: ['', Validators.required],
      stream: ['', Validators.required]
    });
  }

  ngAfterViewInit(): void {
    
  }

  applyFilter(event) {
    //const filterValue = (event.target as HTMLInputElement).value;
    //this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  submit() {
    console.log(this.classDetailObj)
    console.log(this.form.value)
  }

  selectedRecordCallBack(selectedRecordData) {
    let selectedRecord = selectedRecordData.rowObj;
    const eventName = selectedRecordData.eventName;
    switch(eventName) {
      case 'edit':
        this.editDetail(selectedRecord);
        break
    }

  }
  private editDetail(selectedRecord: any) {
    console.log(selectedRecord);
    this.classDetailObj = selectedRecord;
    this.isAddClicked= true
    this.form.setValue({
      "div": selectedRecord.div,
      "std": selectedRecord.std,
      "stream": selectedRecord.stream
    });
  }
  cancelForm(){
    this.isAddClicked= false;
    this.form.setValue({
      "div": '',
      "std": '',
      "stream": ''
    });
  }


  /**
   * to Retrive menu list 
   */
  private getClassDetails() {
    this.classService.getClassDetails().subscribe(data => {
      this.classDetailsList = data.content;
      this.gridDetail.gridData = data.content;
      this.gridDetail.displayColumnDetails = this.displayedDetails;
      //this.dataSource = new MatTableDataSource(this.classDetailsList);
      //this.dataSource.paginator = this.paginator;
    });
  }
}

