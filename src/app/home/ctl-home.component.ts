import { Component } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';

import { AppStore } from '../common/models/appstore.model';
import { User, EnterpriseInfo } from '../common/models/user.model';
import { AuthService } from '../common/service/auth.service';



@Component({
  selector: 'ctl-home',
  templateUrl: './ctl-home.template.html'
})
export class CtlHomeComponent {
   user: Observable<User>;

   constructor(public authService: AuthService,
              public store: Store<AppStore>) {
      this.user = authService.user;
      authService.init();

  }

  addUserInfo() {
    let entInfo: EnterpriseInfo = {
      ein: 12345,
      ownTransport: true
    };
    this.authService.addUserInfo(entInfo);
  }

  logout() {
    this.authService.logout();
  }

}
