import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  listMenu = [{ "menu": 'Test', "link": '/test' },{ "menu": 'Milk', "link": '/milk' },{ "menu": 'Kafuu', "link": '/kafuu' }];
  title = 'Web';

  constructor(private router: Router) {
  }

  next(link) {
    this.router.navigate([link]);
  }
}
