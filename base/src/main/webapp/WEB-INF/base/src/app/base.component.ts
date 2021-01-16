import { Component } from '@angular/core';
import { Router } from '@angular/router';


export class BaseComponent {
    constructor(private router: Router) { }


    navigate(path: string): void {
        this.router.navigate([path]);
    }
}