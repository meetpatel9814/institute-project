import { SelectionModel } from '@angular/cdk/collections';
import { AfterViewInit, ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { GridDetail } from 'src/app/util/GridDetails';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit, AfterViewInit {
  @Input()
  gridDetail :GridDetail;
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  displayedColumns: string[];
  displayColumnDetails:any[];

  /* @Input() 
  onEditCallBack: (args :any) => void;
 */
  @Output() onSelectedRecordCallBack = new EventEmitter<any>();

  constructor(private cdr: ChangeDetectorRef) {
    
   }


  ngAfterViewInit(): void {
    this.addChangesInGridData();
      this.dataSource = new MatTableDataSource(this.gridDetail.gridData);
      this.displayColumnDetails = this.gridDetail.displayColumnDetails
      this.displayedColumns = this.displayColumnDetails.map(function(val, index){ 
        return val.columnId;
      });
      this.displayedColumns.push('manage')
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      this.cdr.detectChanges();
  }
  addChangesInGridData() {
    this.gridDetail.displayColumnDetails.filter(columnDetail => columnDetail.hasOwnProperty("isNestedValue")).forEach(columnDetail => {
      this.gridDetail.gridData.forEach(rowData => {
        rowData[columnDetail.columnId] = this.fetchNestedValue(rowData, columnDetail.nestedColmunPath);
      })
    });
  }
  fetchNestedValue(rowData: any, nestedColmunPath: String): any {
    let nestedObj = rowData;
    let path = nestedColmunPath.split('.');
    for(var i = 0; i < path.length-1; i++) {
      var elem = path[i];
      if( !nestedObj[elem] ) nestedObj[elem] = {}
      nestedObj = nestedObj[elem];
  }
  return nestedObj[path[path.length-1]];
  }

  ngOnInit(): void {
  }

  applyFilter(event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  callBackFunction(rowObj, eventName) {
    //this.onEditCallBack(rowObj);
    const selectedRecordData  = {
      rowObj : rowObj,
      eventName : eventName
    }
    this.onSelectedRecordCallBack.emit(selectedRecordData);
  }
  

}
