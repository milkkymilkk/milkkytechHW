import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

export interface Test {
  id: number;
  name: string;
  lastname: string;
  email: string;
}

@Injectable()
export class TestService {

  serverUrl = `${environment.apiUrl}test`;

  constructor(private http: HttpClient) { }

  getSearch(data) {
    const param = {
      name: data.name,
      lastname: data.lastname
    };
    return this.http.get<any>(`${this.serverUrl}/search`, { params: param });
  }

  save(data) {
    if (data.id) {
      return this.http.post<any>(`${this.serverUrl}/update`, data);
    } {
      return this.http.post<any>(`${this.serverUrl}/save`, data);
    }
  }

  getDelete(id) {
    const param = {
      id: id,
    };
    return this.http.get<any>(`${this.serverUrl}/delete`, { params: param });
  }

  getSearchDetail(id) {
    const param = {
      id: id,
    };
    return this.http.get<any>(`${this.serverUrl}/searchDetail`, { params: param });
  }
}
