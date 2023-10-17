import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LogoutService } from '../logout.service';



    constructor(private router: Router,private logoutService: LogoutService) {}


    showCreateUserForm() {
        this.router.navigate(['/create']);
    }

    showCreateMultipleUsersForm() {
        this.router.navigate(['/upload-excel']);
    }


    logout() {
        this.logoutService.logout();
      }
}
