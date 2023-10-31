import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { OnboardingComponent } from './onboarding/onboarding.component';

const routes: Routes = [
  {
    component:HomeComponent,
    path:''
  },
  {
    component:RegisterComponent,
    path:'register'
  },
  {
    component:LoginComponent,
    path:'login'
  },{
    component:OnboardingComponent,
    path:'onboarding'
  },
  {
    component: PagenotfoundComponent,
    path:'**'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
