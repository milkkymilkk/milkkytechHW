import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { TestService } from './test.service'
import { finalize } from 'rxjs/internal/operators/finalize';
import { Router } from '@angular/router';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {

  searchForm: FormGroup;
  listSearch = [];

  constructor(private sv: TestService
    , private fb: FormBuilder
    , private router: Router,) {

    this.createForm();

  }

  createForm() {
    this.searchForm = this.fb.group({
      name: null,
      lastname: null,
    });
  }

  ngOnInit(): void {
    this.onSearch();
  }


  onSearch() {
    this.sv.getSearch(this.searchForm.getRawValue())
      .pipe(finalize(() => {

      }))
      .subscribe(
        (res: any) => {
          this.listSearch = res;

        });
  }

  add() {
    this.router.navigate(['/test/detail'], { skipLocationChange: true });
  }

  edit(id) {
    this.router.navigate(['/test/detail', { id: id }], { skipLocationChange: true });
  }

  delete(id) {
    this.sv.getDelete(id)
      .pipe(finalize(() => {
        this.onSearch();
      }))
      .subscribe(
        (res: any) => {
          this.listSearch = res;
        });
  }
}
