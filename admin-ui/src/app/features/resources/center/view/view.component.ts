import { Component, OnDestroy, OnInit } from '@angular/core';
import { CenterRequest } from 'src/app/core/models/centerRequest.model';
import { CenterService } from 'src/app/core/services/center.service';
import { RequestModel } from 'src/app/core/models/request.model';
import { AppConfigService } from 'src/app/app-config.service';
import { SortModel } from 'src/app/core/models/sort.model';
import { PaginationModel } from 'src/app/core/models/pagination.model';
import { ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import Utils from '../../../../app.utils';
import { DialogComponent } from 'src/app/shared/dialog/dialog.component';
import { MatDialog } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';
import { AuditService } from 'src/app/core/services/audit.service';
import { DataStorageService } from 'src/app/core/services/data-storage.service';
import { HeaderService } from 'src/app/core/services/header.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit, OnDestroy {
  displayedColumns = [];
  actionButtons = [];
  primaryLang: string;
  actionEllipsis = [];
  paginatorOptions: any;
  sortFilter = [];
  pagination = new PaginationModel();
  centerRequest = {} as CenterRequest;
  requestModel: RequestModel;
  centers = [];
  subscribed: any;
  errorMessages: any;
  noData = false;
  filtersApplied = false;

  constructor(
    private dataStorageService: DataStorageService,
    private centerService: CenterService,
    private appService: AppConfigService,
    private headerService: HeaderService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog,
    private translateService: TranslateService,
    private auditService: AuditService
  ) {
    this.getCenterConfigs();
    this.primaryLang = this.headerService.getUserPreferredLanguage();
    this.translateService.use(this.primaryLang);
    this.translateService.getTranslation(this.primaryLang).subscribe(response => {
      this.errorMessages = response.errorPopup;
    });
    this.subscribed = router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        if(this.displayedColumns)
          this.getCenterConfigs();
      }
    });
  }

  ngOnInit() {
    //this.auditService.audit(3, centerConfig.auditEventIds[0], 'centers');
  }

  getCenterConfigs() {
    this.dataStorageService
      .getSpecFileForMasterDataEntity("center")
      .subscribe(response => {
        this.displayedColumns = response.columnsToDisplay;
        this.actionButtons = response.actionButtons.filter(
          value => value.showIn.toLowerCase() === 'ellipsis'
        );
        this.actionEllipsis = response.actionButtons.filter(
          value => value.showIn.toLowerCase() === 'button'
        );
        this.paginatorOptions = response.paginator;
        this.auditService.audit(3, response.auditEventIds[0], 'center');
        this.getRegistrationCenters();
      });
  }

  pageEvent(event: any) {
    const filters = Utils.convertFilter(
      this.activatedRoute.snapshot.queryParams,
      this.primaryLang
    );
    filters.pagination.pageFetch = event.pageSize;
    filters.pagination.pageStart = event.pageIndex;
    const url = Utils.convertFilterToUrl(filters);
    this.router.navigateByUrl(`admin/resources/centers/view?${url}`);
  }

  getSortColumn(event: SortModel) {
    console.log(event);
    this.sortFilter.forEach(element => {
      if (element.sortField === event.sortField) {
        const index = this.sortFilter.indexOf(element);
        this.sortFilter.splice(index, 1);
      }
    });
    if (event.sortType != null) {
      this.sortFilter.push(event);
    }
    console.log(this.sortFilter);
    const filters = Utils.convertFilter(
      this.activatedRoute.snapshot.queryParams,
      this.primaryLang
    );
    filters.sort = this.sortFilter;
    const url = Utils.convertFilterToUrl(filters);
    this.router.navigateByUrl('admin/resources/centers/view?' + url);
  }

  getRegistrationCenters() {
    this.centers = [];
    this.noData = false;
    this.filtersApplied = false;
    const filters = Utils.convertFilter(
      this.activatedRoute.snapshot.queryParams,
      this.primaryLang
    );
    if (filters.filters.length > 0) {
      this.filtersApplied = true;
    }    
    this.sortFilter = filters.sort;
    if(this.sortFilter.length == 0){
      this.sortFilter.push({"sortType":"desc","sortField":"createdDateTime"});      
    }
    this.requestModel = new RequestModel(null, null, filters);
    console.log(JSON.stringify(this.requestModel));
    this.centerService
      .getRegistrationCentersDetails(this.requestModel)
      .subscribe(({ response, errors }) => {
        console.log(response);
        if (response != null) {
          this.paginatorOptions.totalEntries = response.totalRecord;
          this.paginatorOptions.pageIndex = filters.pagination.pageStart;
          this.paginatorOptions.pageSize = filters.pagination.pageFetch;
          console.log(this.paginatorOptions);
          if (response.data !== null) {
            this.centers = response.data ? [...response.data] : [];
          } else {
            this.noData = true;
          //   this.dialog
          //   .open(DialogComponent, {
          //      data: {
          //       case: 'MESSAGE',
          //       title: this.errorMessages.noData.title,
          //       message: this.errorMessages.noData.message,
          //       btnTxt: this.errorMessages.noData.btnTxt
          //      } ,
          //     width: '700px'
          //   })
          //   .afterClosed()
          //   .subscribe(result => {
          //     console.log('dislog is closed');
          //     this.router.navigateByUrl(
          //       `admin/resources/centers/view`
          //     );
          //   });
          }
        } else {
          this.dialog
            .open(DialogComponent, {
               data: {
                case: 'MESSAGE',
                title: this.errorMessages.technicalError.title,
                message: this.errorMessages.technicalError.message,
                btnTxt: this.errorMessages.technicalError.btnTxt
               } ,
              width: '700px'
            })
            .afterClosed()
            .subscribe(result => {
              console.log('dialog is closed from view component');
            });
        }
      });
  }

  ngOnDestroy() {
    this.subscribed.unsubscribe();
  }
}
