import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestComponent } from './test/test.component';
import { TestDetailComponent } from './test/test-detail.component';
import { MilkComponent } from './milk/milk.component';
import { KafuuComponent } from './kafuu/kafuu.component';

const routes: Routes = [
  { path: 'test', component: TestComponent },
  { path: 'test/detail', component: TestDetailComponent },
  { path: 'milk', component: MilkComponent },
  { path: 'kafuu', component: KafuuComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
