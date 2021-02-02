import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Test, TestService } from './test.service'
import { finalize } from 'rxjs/internal/operators/finalize';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-test-detail',
  templateUrl: './test-detail.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestDetailComponent implements OnInit {

  saveForm: FormGroup;
  listSearch = [];
  invalid = false;
  saving = false;
  test: Test = {} as Test;

  constructor(private sv: TestService
    , private fb: FormBuilder
    , private router: Router
    , private route: ActivatedRoute) {

    this.createForm();

  }

  createForm() {
    this.saveForm = this.fb.group({
      id: null,
      name: [null, Validators.required],
      lastname: [null, Validators.required],
      email: null
    });
  }

  ngOnInit(): void {
    if (this.route.snapshot.params.id) {
      this.onSearchDetail();
    }
  }

  prepareSave() {
    Object.assign(this.test, this.saveForm.value)
  }

  onSearchDetail() {
    this.sv.getSearchDetail(this.route.snapshot.params.id || this.test.id)
      .pipe(finalize(() => {

      }))
      .subscribe(
        (res: any) => {
          this.saveForm.patchValue(res)
        });
  }


  save() {
    if (this.saveForm.invalid) {
      this.invalid = true;
      return;
    }
    this.invalid = false;
    this.prepareSave()
    this.sv.save(this.test)
      .pipe(finalize(() => {
        this.saving = true;
        setTimeout(() => {
        this.saving = false;
        }, 5000);
      }))
      .subscribe(
        (res: any) => {
          this.test.id = res;
          this.onSearchDetail();
          // this.listSearch = res;
        });
  }


  back() {
    this.router.navigate(['/test'], { skipLocationChange: true });
  }

}
