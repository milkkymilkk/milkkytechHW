import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { finalize } from 'rxjs/internal/operators/finalize';
import { Router } from '@angular/router';

@Component({
  selector: 'app-kafuu',
  templateUrl: './kafuu.component.html',
  styleUrls: ['./kafuu.component.scss']
})
export class KafuuComponent implements OnInit {

  constructor(private fb: FormBuilder
    , private router: Router,) {


  }

  ngOnInit(): void {

  }
}
function clock() {
var time = new Date(),
    hours = time.getHours(),
    minutes = time.getMinutes(),
    seconds = time.getSeconds();
document.querySelectorAll('.clock')[0].innerHTML = harold(hours) + ":" + harold(minutes) + ":" + harold(seconds);
  function harold(standIn) {
    if (standIn < 10) {
      standIn = '0' + standIn
    }
    return standIn;
  }
}
setInterval(clock, 1000);