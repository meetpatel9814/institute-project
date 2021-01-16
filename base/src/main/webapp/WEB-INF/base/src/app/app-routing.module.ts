import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClassComponent } from './class/class.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { StudentViewComponent } from './student/student-view/student-view.component';
import { StudentComponent } from './student/student.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'home', component: HomeComponent, children: [
      {path: 'classes',component: ClassComponent},
      {path: 'students',component: StudentComponent},
      { path: 'student/:className/:rollNumber' , component :StudentViewComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
