import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {
  private isAuthenticated = false;


  constructor() {}

  // Call this method to set the user as authenticated
  setAuthenticated(value: boolean) {
    this.isAuthenticated = value;
  }

  // Call this method to check if the user is authenticated

  constructor() {
   
    const storedAuthStatus = localStorage.getItem('isAuthenticated');
    this.isAuthenticated = storedAuthStatus ? JSON.parse(storedAuthStatus) : false;
  }

  
  setAuthenticated(value: boolean) {
    this.isAuthenticated = value;

    localStorage.setItem('isAuthenticated', JSON.stringify(value));
  }

  


  isAuthenticatedUser(): boolean {
    return this.isAuthenticated;
  }
}
