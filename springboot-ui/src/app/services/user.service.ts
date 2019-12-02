import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { User } from '../model/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpSvc: HttpService) { }

  /**
   * Add User
   * @param user  
   */
  userRegister(user: User): Observable<Boolean> {
    return this.httpSvc.post('/register',user).pipe();
  }

  /**
   * User Login
   * @param user 
   */
  userLogin(user: User) : Observable<Boolean> {
    return this.httpSvc.post('/login',user).pipe();
  }

  /**
   * User Update
   * @param user
   */
  userUpdate(user: User): Observable<Boolean> {
    return this.httpSvc.post('/update',user).pipe();
  }

  /**
   * Get User by login name
   * @param loginName
   */
  getUser(loginName: string): Observable<User> {
    var url = '/' + loginName;
    return this.httpSvc.get(url).pipe();
  }

}
