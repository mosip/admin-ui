import * as config from 'src/assets/config.json';
export const AUTH_ERROR_CODE = ['KER-ATH-007','KER-ATH-006'];
export const VERSION = '1.0';
export const BASE_URL = config.baseUrl;
export const IDS = 'dummy';
export const URL = {
  centers: `masterdata/registrationcenters/search`,
  devices: `masterdata/devices/search`,
  machines: `masterdata/machines/search`,
  'rid-status': `masterdata/packet/search`,
  users: `masterdata/users/search`,
  zoneuser: `masterdata/zoneuser/search`,
  documentCategories: `masterdata/documentcategories`,
  mappedDocUrl: `masterdata/documenttypes/`,
  unMappedDocUrl: `masterdata/documenttypes/`,
  'lost-rid-status': `admin/lostRid `,
};
export const navItems = [
  {
    displayName: 'menuItems.item1.title',
    icon: './assets/images/home.svg',
    route: '/admin/home',
    children: null,
    auditEventId: 'ADM-002',
    roles: []
  },
  {
    displayName: 'menuItems.item2.title',
    icon: 'assets/images/support.svg',
    route: 'admin/resources',
    children: [
      {
        displayName: 'menuItems.item2.subItem1',
        icon: null,
        route: '/admin/resources/centers',
        auditEventId: 'ADM-004',
        roles: ['ZONAL_ADMIN', 'GLOBAL_ADMIN']
      },
      {
        displayName: 'menuItems.item2.subItem2',
        icon: null,
        route: '/admin/resources/devices',
        auditEventId: 'ADM-005',
        roles: ['ZONAL_ADMIN']
      },
      {
        displayName: 'menuItems.item2.subItem3',
        icon: null,
        route: '/admin/resources/machines',
        auditEventId: 'ADM-007',
        roles: ['ZONAL_ADMIN']
      },
      {
        displayName: 'menuItems.item2.subItem4',
        icon: null,
        route: '/admin/resources/zoneuser',
        auditEventId: 'ADM-006',
        roles: ['ZONAL_ADMIN', 'GLOBAL_ADMIN']
      },
      {
        displayName: 'menuItems.item2.subItem5',
        icon: null,
        route: '/admin/resources/users',
        auditEventId: 'ADM-006',
        roles: ['ZONAL_ADMIN']
      }
    ],
    auditEventId: 'ADM-003',
    roles: ['ZONAL_ADMIN', 'GLOBAL_ADMIN']
  },
  {
    displayName: 'menuItems.item4.title',
    icon: './assets/images/packet-status.svg',
    route: '/admin/packet-status',
    children: null,
    auditEventId: 'ADM-008',
    roles: ['REGISTRATION_ADMIN']
  },
  {
    displayName: 'menuItems.item5.title',
    icon: './assets/images/id-card.svg',
    route: '/admin/rid-status',
    children: null,
    auditEventId: 'ADM-009',
    roles: ['REGISTRATION_ADMIN']
  },
  {
    displayName: 'menuItems.item8.title',
    icon: './assets/images/id-card.svg',
    route: '/admin/lost-rid-status',
    children: null,
    auditEventId: 'ADM-009',
    roles: ['REGISTRATION_ADMIN']
  },
  {
    displayName: 'menuItems.item3.title',
    icon: './assets/images/id-card.svg',
    route: '/admin/masterdata',
    children: null,
    auditEventId: 'ADM-009',
    roles: ['GLOBAL_ADMIN', 'ZONAL_ADMIN', 'MASTERDATA_ADMIN']
  },
  {
    displayName: 'menuItems.item6.title',
    icon: 'assets/images/support.svg',
    route: 'admin/bulkupload',
    children: [
      {
        displayName: 'menuItems.item6.subItem1',
        icon: null,
        route: '/admin/bulkupload/masterdataupload',
        auditEventId: 'ADM-004',
        roles: ['GLOBAL_ADMIN', 'ZONAL_ADMIN', 'MASTERDATA_ADMIN']
      },
      {
        displayName: 'menuItems.item6.subItem2',
        icon: null,
        route: '/admin/bulkupload/packetupload',
        auditEventId: 'ADM-005',
        roles: ['REGISTRATION_ADMIN']
      }
    ],
    auditEventId: 'ADM-003',
    roles: ['GLOBAL_ADMIN', 'ZONAL_ADMIN', 'MASTERDATA_ADMIN', 'REGISTRATION_ADMIN']
  },
  {
    displayName: 'menuItems.item7.title',
    icon: 'assets/images/support.svg',
    route: 'admin/keymanager',
    children: [
      {
        displayName: 'menuItems.item7.subItem2',
        icon: null,
        route: '/admin/keymanager/generatemasterkey',
        auditEventId: 'ADM-004',
        roles: ['KEY_MAKER']
      },
      {
        displayName: 'menuItems.item7.subItem1',
        icon: null,
        route: '/admin/keymanager/generatecsr',
        auditEventId: 'ADM-004',
        roles: ['GLOBAL_ADMIN', 'ZONAL_ADMIN', 'MASTERDATA_ADMIN']
      },      
      {
        displayName: 'menuItems.item7.subItem3',
        icon: null,
        route: '/admin/keymanager/getcertificate',
        auditEventId: 'ADM-004',
        roles: ['GLOBAL_ADMIN', 'ZONAL_ADMIN', 'MASTERDATA_ADMIN']
      },
      {
        displayName: 'menuItems.item7.subItem4',
        icon: null,
        route: '/admin/keymanager/uploadcertificate',
        auditEventId: 'ADM-004',
        roles: ['GLOBAL_ADMIN', 'ZONAL_ADMIN', 'MASTERDATA_ADMIN']
      },
      {
        displayName: 'menuItems.item7.subItem5',
        icon: null,
        route: '/admin/keymanager/uploadotherdomaincertificate',
        auditEventId: 'ADM-004',
        roles: ['GLOBAL_ADMIN', 'ZONAL_ADMIN', 'MASTERDATA_ADMIN']
      }
    ],
    auditEventId: 'ADM-003',
    roles: ['GLOBAL_ADMIN', 'ZONAL_ADMIN', 'MASTERDATA_ADMIN', 'KEY_MAKER']
  }
];

export const MASTERDATA_BASE_URL = `masterdata/`;
export const processingTimeStart = 15;
export const processingTimeEnd = 45;
export const processingTimeInterval = 5;
export const timeSlotsInterval = 30;

export const registrationCenterCreateId = 'string';
export const registrationDeviceCreateId = 'string';
export const registrationMachineCreateId = 'string';

export const viewFields = [];

export const masterdataMapping = {
  users: {
    apiName: 'users',
    specFileName: 'users',
    name: {
      eng: 'Users',
      ara: '??????????',
      fra: 'Mod??les',
      tam: '????????????????????????',
      kan: '???????????????????????????',
      hin: '????????????????????????????????????'
    },
    nameKey: 'userName',
    idKey: 'userId',
    headerName: 'Users'
  },
  zoneuser: {
    apiName: 'zoneuser',
    specFileName: 'zoneuser',
    name: {
      eng: 'Users',
      ara: '??????????',
      fra: 'Mod??les',
      tam: '????????????????????????',
      kan: '???????????????????????????',
      hin: '????????????????????????????????????'
    },
    nameKey: 'name',
    idKey: 'id',
    headerName: 'Zone User'
  },
  'blocklisted-words': {
    apiName: 'blocklistedwords',
    specFileName: 'blocklisted-words',
    name: {
      "eng": "Blocklisted Words",
      "ara": "?????????????? ????????????????",
      "fra": "Mots bloqu??s",
      "tam": "????????????????????????????????????????????????????????? ???????????? ?????????????????????????????????",
      "kan": "??????????????????????????? ???????????????",
      "hin": "??????????????? ????????????????????? ????????????"
    },
    nameKey: 'word',
    idKey: 'word',
    headerName: 'Blacklisted Words'
  },
  holiday: {
    apiName: 'holidays',
    specFileName: 'holiday-data',
    name: {
      eng: 'Holiday',
      ara: '?????????? ????????',
      fra: 'Liste de vacances',
      tam: '????????????????????????',
      kan: '??????????????????',
      hin: '??????????????????'
    },
    nameKey: 'holidayName',
    idKey: 'holidayId',
    headerName: 'Holidays'
  },
  'document-type': {
    apiName: 'documenttypes',
    specFileName: 'document-types',
    name: {
      eng: 'Document Type',
      ara: '?????????? ??????????????????',
      fra: 'Types de documents',
      tam: '????????? ?????????',
      kan: '????????????????????????????????? ??????????????????',
      hin: '??????????????????????????? ?????? ??????????????????'
    },
    nameKey: 'name',
    idKey: 'code',
    headerName: 'Document Type'
  },
  location: {
    apiName: 'locations',
    specFileName: 'location-data',
    name: {
      eng: 'Location',
      ara: '???????????? ????????????',
      fra: 'Donn??es de localisation'
    },
    nameKey: 'postalCode',
    idKey: 'postalCode',
    headerName: 'Location'
  },
  templates: {
    apiName: 'templates',
    specFileName: 'templates',
    name: {
      eng: 'Templates',
      ara: '??????????',
      fra: 'Mod??les',
      tam: '?????????????????????????????????????????????',
      kan: '???????????????????????????????????????',
      hin: '??????????????????????????????'
    },
    nameKey: 'name',
    idKey: 'id',
    headerName: 'Templates'
  },
  'machine-type': {
    apiName: 'machinetypes',
    specFileName: 'machine-type',
    name: {
      eng: 'Machine Types',
      ara: '?????????? ????????????',
      fra: 'Types de machines',
      tam: '????????????????????? ??????????????????',
      kan: '??????????????? ???????????????????????????',
      hin: '???????????? ?????? ??????????????????'
    },
    nameKey: 'name',
    idKey: 'code',
    headerName: 'Machine Type'
  },
  'device-types': {
    apiName: 'devicetypes',
    specFileName: 'device-type',
    name: {
      eng: 'Device Types',
      ara: '?????????? ??????????????',
      fra: 'Types de p??riph??riques',
      tam: '???????????? ??????????????????',
      kan: '???????????? ???????????????????????????',
      hin: '?????????????????? ?????? ??????????????????'
    },
    nameKey: 'name',
    idKey: 'code',
    headerName: 'Device Type'
  },
  'document-categories': {
    apiName: 'documentcategories',
    specFileName: 'document-category',
    name: {
      eng: 'Document Categories',
      ara: '???????? ??????????????????',
      fra: 'Cat??gories de document',
      tam: '????????? ??????????????????',
      kan: '????????????????????????????????? ?????????????????????',
      hin: '??????????????????????????? ???????????????????????????'
    },
    nameKey: 'name',
    idKey: 'code',
    headerName: 'Document Category'
  },
  'machine-specs': {
    apiName: 'machinespecifications',
    specFileName: 'machine-specification',
    name: {
      eng: 'Machine Specification',
      ara: '?????????????????? ????????????',
      fra: 'Sp??cifications de la machin',
      tam: '????????????????????? ??????????????????????????????????????????',
      kan: '??????????????? ??????????????????',
      hin: '???????????? ???????????????????????????'
    },
    nameKey: 'name',
    idKey: 'id',
    headerName: 'Machine Specification'
  },
  'device-specs': {
    apiName: 'devicespecifications',
    specFileName: 'device-specification',
    name: {
      eng: 'Device Specification',
      ara: '?????????????? ????????????',
      fra: 'Sp??cifications de l\'appareil',
      tam: '???????????? ??????????????????????????????????????????',
      kan: '???????????? ??????????????????',
      hin: '?????????????????? ???????????????????????????'
    },
    nameKey: 'name',
    idKey: 'id',
    headerName: 'Device Specification'
  },
  'center-type': {
    apiName: 'registrationcentertypes',
    specFileName: 'center-type',
    name: {
      eng: 'Center Type',
      ara: '?????? ????????????',
      fra: 'Type de centre',
      tam: '????????? ?????????',
      kan: '?????????????????? ??????????????????',
      hin: '?????????????????? ??????????????????'
    },
    nameKey: 'name',
    idKey: 'code',
    headerName: 'Registration Center Type'
  },
  'individual-type': {
    apiName: 'individualtypes',
    specFileName: 'individual-types',
    name: {
      eng: 'Individual Type',
      ara: '?????? ??????????????',
      fra: 'Type individuel'
    },
    nameKey: 'name',
    idKey: 'code',
    headerName: 'Individual Type'
  },
  dynamicfields: {
    apiName: 'dynamicfields',
    specFileName: 'dynamicfields',
    name: {
      "eng": "Dynamic Field",
      "ara": "???????? ????????????????",
      "fra": "Champ dynamique",
      tam: '????????????????????? ???????????????',
      kan: '???????????????????????? ??????????????????',
      hin: '?????????????????? ?????????????????????'
    },
    nameKey: 'name',
    idKey: 'id',
    headerName: 'Dynamic Field'
  },
  documentCategoryMapping: {
    name: {
      eng: 'Document Category - Type Mapping',
      ara: '?????? ?????????????? - ?????? ??????????????',
      fra: 'Cat??gorie de document - Mappage de types'
    }
  }
};

export const ListViewIdKeyMapping = {
  centers: {
    idKey: 'id',
    imagePath: 'assets/images/center-name-icon.png',
    auditEventId: 'ADM-064'
  },
  devices: {
    idKey: 'id',
    imagePath: 'assets/images/Device.png',
    auditEventId: 'ADM-065'
  },
  machines: {
    idKey: 'id',
    imagePath: 'assets/images/Machine.png',
    auditEventId: 'ADM-066'
  },
  users: { idKey: 'userId', auditEventId: 'ADM-084' },
  zoneuser: { idKey: 'userId', auditEventId: 'ADM-084' },
  'machine-type': { idKey: 'code', auditEventId: 'ADM-067' },
  templates: { idKey: 'id', auditEventId: 'ADM-068' },
  title: { idKey: 'code', auditEventId: 'ADM-069' },
  'blocklisted-words': { idKey: 'word', auditEventId: 'ADM-070'},
  'document-type': { idKey: 'code', auditEventId: 'ADM-071' },
  location: { idKey: 'postalCode', auditEventId: 'ADM-072' },
  'device-specs': { idKey: 'id', auditEventId: 'ADM-073' },
  'machine-specs': { idKey: 'id', auditEventId: 'ADM-074' },
  'device-types': { idKey: 'code', auditEventId: 'ADM-075' },
  'document-categories': { idKey: 'code', auditEventId: 'ADM-076' },
  'individual-type': { idKey: 'code', auditEventId: 'ADM-077' },
  'gender-type': { idKey: 'code', auditEventId: 'ADM-078' },
  'center-type': { idKey: 'code', auditEventId: 'ADM-079' },
  holiday: { idKey: 'holidayId', auditEventId: 'ADM-080' },
  masterdataupload : { idKey: 'transcationId', auditEventId: 'ADM-081' },
  packetupload : { idKey: 'transcationId', auditEventId: 'ADM-082' },
  getcertificate : { idKey: 'applicationId', auditEventId: 'ADM-083' },
  dynamicfields : { idKey: 'id', auditEventId: 'ADM-084' },
  'rid-status' : { idKey: 'workflowId', auditEventId: 'ADM-085' }
  
};

export const FilterMapping = {
  centers: {
    specFileName: 'center',
    apiName: 'registrationcenters'
  },
  devices: {
    specFileName: 'devices',
    apiName: 'devices'
  },
  machines: {
    specFileName: 'machines',
    apiName: 'machines'
  },
  'blocklisted-words': {
    apiName: 'blocklistedwords',
    specFileName: 'blocklisted-words'
  },
  holiday: {
    apiName: 'holidays',
    specFileName: 'holiday-data'
  },
  'document-type': {
    apiName: 'documenttypes',
    specFileName: 'document-types'
  },
  location: {
    apiName: 'locations',
    specFileName: 'location-data'
  },
  'gender-type': {
    apiName: 'gendertypes',
    specFileName: 'gender-types'
  },
  title: {
    apiName: 'title',
    specFileName: 'titles'
  },
  templates: {
    apiName: 'templates',
    specFileName: 'templates'
  },
  'machine-type': {
    apiName: 'machinetypes',
    specFileName: 'machine-type'
  },
  'device-types': {
    apiName: 'devicetypes',
    specFileName: 'device-type'
  },
  'document-categories': {
    apiName: 'documentcategories',
    specFileName: 'document-category'
  },
  'machine-specs': {
    apiName: 'machinespecifications',
    specFileName: 'machine-specification'
  },
  'device-specs': {
    apiName: 'devicespecifications',
    specFileName: 'device-specification'
  },
  'center-type': {
    apiName: 'registrationcentertypes',
    specFileName: 'center-type'
  },
  'individual-type': {
    apiName: 'individualtypes',
    specFileName: 'individual-types'
  },
  dynamicfields: {
    apiName: 'dynamicfields',
    specFileName: 'dynamicfields'
  },
  users: {
    apiName: 'users',
    specFileName: 'user'
  },
  zoneuser: {
    apiName: 'zoneuser',
    specFileName: 'zoneuser'
  },
  'rid-status': {
    apiName: 'packet',
    specFileName: 'rid-status'
  },
  'lost-rid-status': {
    apiName: 'lostRid ',
    specFileName: 'lost-rid-status'
  }
};

export const keyboardMapping = {
  eng: 'en',
  fra: 'fr',
  ara: 'ar',
  hin: 'hi',
  tam: 'ta',
  kan: 'ka'
};

export const days = {
  eng: [
    { name: 'Monday', code: 'mon' },
    { name: 'Tuesday', code: 'tue' },
    { name: 'Wednesday', code: 'wed' },
    { name: 'Thursday', code: 'thu' },
    { name: 'Friday', code: 'fri' },
    { name: 'Saturday', code: 'sat' },
    { name: 'Sunday', code: 'sun' }
  ],
  fra: [
    { name: 'Lundi', code: 'mon' },
    { name: 'Mardi', code: 'tue' },
    { name: 'Mercredi', code: 'wed' },
    { name: 'Jeudi', code: 'thu' },
    { name: 'Vendredi', code: 'fri' },
    { name: 'samedi', code: 'sat' },
    { name: 'dimanche', code: 'sun' }
  ],
  ara: [
    { name: '??????????????', code: 'mon' },
    { name: '????????????????', code: 'tue' },
    { name: '????????????????', code: 'wed' },
    { name: '????????????', code: 'thu' },
    { name: '?????? ????????????', code: 'fri' },
    { name: '?????? ??????????', code: 'sat' },
    { name: '??????????', code: 'sun' }
  ]
};
