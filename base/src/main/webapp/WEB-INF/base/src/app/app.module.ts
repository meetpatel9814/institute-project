import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { MaterialModule } from './material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { BaseComponent } from './base.component';
import { MenuComponent } from './menu/menu.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ClassComponent } from './class/class.component';
import { TableComponent } from './framwork/tabel/table.component';
import { CommonInterceptor } from './framwork/CommonInterceptor';
import { NgxSpinner } from 'ngx-spinner/lib/ngx-spinner.enum';
import { NgxSpinnerModule } from 'ngx-spinner';
import { CommonDialogComponent } from './framwork/dialog/common-dialog/common-dialog.component';
import { StudentComponent } from './attendanceDetail/attendanceDetail.component';
import { StudentViewComponent } from './attendanceDetail/attendanceDetail-view/attendanceDetail-view.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MenuComponent,
    ClassComponent,
    TableComponent,
    CommonDialogComponent,
    StudentComponent,
    StudentViewComponent
  ],
  imports: [
    MaterialModule,
    MatSliderModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxSpinnerModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: CommonInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
