import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { finalize } from 'rxjs/internal/operators/finalize';
import { Router } from '@angular/router';

@Component({
  selector: 'app-milk',
  templateUrl: './milk.component.html',
  styleUrls: ['./milk.component.scss']
})
export class MilkComponent implements OnInit {

  constructor(private fb: FormBuilder
    , private router: Router,) {


  }

  ngOnInit(): void {

  }
}
