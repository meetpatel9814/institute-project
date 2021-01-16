import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatDialog, MatDialogConfig, DialogPosition } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NgxSpinnerService } from 'ngx-spinner';
import { Observable } from 'rxjs';
import { finalize, tap } from "rxjs/operators";
import { CommonDialogComponent } from './dialog/common-dialog/common-dialog.component';

@Injectable()
export class CommonInterceptor implements HttpInterceptor {
    private reqCount = 0 ;
    constructor(private spinner: NgxSpinnerService, public dialog: MatDialog) {

    }
    private dialogConfig :MatDialogConfig = {
        position : {top : '10px' },
        data : {
            errorMessage: '',
            successMessage: '',
            warningMessage: ''
        }
    };
    


    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        this.reqCount++;
        this.spinner.show();
        return next.handle(req).pipe(
            tap((event) => {
                if(event instanceof HttpResponse && event.body != undefined 
                    && event.body.message != undefined && event.body.message == 'ERROR') {
                    this.dialogConfig.data.errorMessage = event.body.code +': ' + event.body.message;
                    const dialogRef = this.dialog.open(CommonDialogComponent, this.dialogConfig)    
                }
            }),
            finalize(() => {
                this.reqCount--;
                if(this.reqCount == 0) {
                    this.spinner.hide()
                }
                
            })
        );
    }
}