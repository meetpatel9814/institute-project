import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClassComponent } from './class/class.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { StudentViewComponent } from './attendanceDetail/attendanceDetail-view/attendanceDetail-view.component';
import { StudentComponent } from './attendanceDetail/attendanceDetail.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'home', component: HomeComponent, children: [
      {path: 'classes',component: ClassComponent},
      {path: 'students',component: StudentComponent},
      { path: 'attendanceDetail/:className/:rollNumber' , component :StudentViewComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
