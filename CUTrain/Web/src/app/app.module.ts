import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { TestDetailComponent } from './test/test-detail.component';
import { TestService } from './test/test.service';
import { MilkComponent } from './milk/milk.component';
import { KafuuComponent } from './kafuu/kafuu.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    TestDetailComponent,
    MilkComponent,
    KafuuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule

  ],
  providers: [TestService],
  bootstrap: [AppComponent],
  exports: [HttpClientModule,
    FormsModule,
    ReactiveFormsModule]
})
export class AppModule { }
