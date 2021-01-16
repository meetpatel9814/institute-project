import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuConstatns } from '../util/MenuConstants';
import { MenuService } from './menu.service';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit, OnDestroy {
  mobileQuery: MediaQueryList;
  private _mobileQueryListener: () => void;

  menus: Array<any> = [];
  selectedMenuItem = { displayName: 'Home' };
  @ViewChild(MatSidenav) snav: MatSidenav;

  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private menuService: MenuService, private router: Router, private activatedRoute: ActivatedRoute) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }
  ngOnInit(): void {
    this.getMenuDetails();
  }
  /**
   * open selected menu page
   * @param menuItem
   */
  openMenu(menuItem): void {
    this.selectedMenuItem = menuItem;
    this.router.navigate([MenuConstatns.getMenuPath(menuItem.menuKey)], {relativeTo: this.activatedRoute});
    this.snav.toggle();
  }
  /**
   * to Retrive menu list 
   */
  private getMenuDetails() {
    this.menuService.getMenus().subscribe(data => {
      this.menus = data.content;
    });
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }
}
