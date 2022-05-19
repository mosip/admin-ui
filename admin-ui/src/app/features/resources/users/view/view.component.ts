import { Component, OnInit } from '@angular/core';
import { AuditService } from 'src/app/core/services/audit.service';
import { TranslateService } from '@ngx-translate/core';
import { AppConfigService } from 'src/app/app-config.service';
import { BASE_URL } from 'src/app/app.constants';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {

  private BASE_URL = this.appService.getConfig().baseUrl;
  private ENV_URL = BASE_URL.substring(0,BASE_URL.length-3);
  keycloakUrl =
    this.ENV_URL+'keycloak/auth/admin/master/console/#/realms/mosip/users';

  constructor(
    private auditService: AuditService,
    private translate: TranslateService,
    private appService: AppConfigService
  ) {
    translate.use(appService.getConfig()['primaryLangCode']);
  }
  ngOnInit() {
    this.auditService.audit(3, 'ADM-042', 'users');
  }
}
