package io.mosip.testrig.adminui.kernel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import io.mosip.testrig.adminui.utility.TestRunner;
public class ConfigManager {

	private static final Logger logger = Logger.getLogger(ConfigManager.class);
	
//	private static String MOSIP_PMS_CLIENT_SECRET = "mosip_pms_client_secret";
//	private static String MOSIP_PMS_CLIENT_ID = "mosip_pms_client_id";
//	private static String MOSIP_PMS_APP_ID = "mosip_pms_app_id";
//
//	private static String MOSIP_RESIDENT_CLIENT_SECRET = "mosip_resident_client_secret";
//	private static String MOSIP_RESIDENT_CLIENT_ID = "mosip_resident_client_id";
//	private static String MOSIP_RESIDENT_APP_ID = "mosip_resident_app_id";
//
//	private static String MOSIP_MOBILE_CLIENT_ID = "mpartner_default_mobile_client_id";
//	private static String MOSIP_MOBILE_CLIENT_SECRET = "mpartner_default_mobile_secret";
//
	private static String MOSIP_IDREPO_CLIENT_SECRET = "mosip_idrepo_client_secret";
	private static String MOSIP_IDREPO_CLIENT_ID = "mosip_idrepo_client_id";
	private static String MOSIP_IDREPO_APP_ID = "mosip_idrepo_app_id";
//
	private static String MOSIP_ADMIN_CLIENT_SECRET = "mosip_admin_client_secret";
	private static String MOSIP_ADMIN_CLIENT_ID = "mosip_admin_client_id";
	private static String MOSIP_ADMIN_APP_ID = "mosip_admin_app_id";
//
//	private static String MOSIP_REG_CLIENT_SECRET = "mosip_reg_client_secret";
//	private static String MOSIP_REG_CLIENT_ID = "mosip_reg_client_id";
//	private static String MOSIP_REGCLIENT_APP_ID = "mosip_regclient_app_id";
//
//	private static String MOSIP_IDA_CLIENT_SECRET = "mosip_ida_client_secret";
//	private static String MOSIP_IDA_CLIENT_ID = "mosip_ida_client_id";
//	private static String MOSIP_IDA_APP_ID = "mosip_ida_app_id";
//
//	private static String MOSIP_HOTLIST_CLIENT_SECRET = "mosip_hotlist_client_secret";
//	private static String MOSIP_HOTLIST_CLIENT_ID = "mosip_hotlist_client_id";
//	private static String MOSIP_HOTLIST_APP_ID = "mosip_hotlist_app_id";
//
	private static String MOSIP_AUTOMATION_CLIENT_SECRET = "mosip_testrig_client_secret";
	private static String MOSIP_AUTOMATION_CLIENT_ID = "mosip_testrig_client_id";
//	private static String MOSIP_AUTOMATION_APP_ID = "mosip_automation_app_id";
//
	private static String S3_HOST = "s3-host";
	private static String S3_REGION = "s3-region";
	private static String S3_USER_KEY = "s3-user-key";
	private static String S3_SECRET_KEY = "s3-user-secret";
	private static String S3_ACCOUNT = "s3-account";
	private static String PUSH_TO_S3 = "push-reports-to-s3";
//	private static String ENABLE_DEBUG = "enableDebug";
//	private static String THREAD_COUNT = "threadCount";
//	private static String LANG_SELECT = "langselect";
//	
//
	private static String DB_PORT = "db-port";
	private static String DB_DOMAIN = "db-server";
	private static String HIBERNATE_CONNECTION_DRIVER_CLASS = "hibernate.connection.driver_class";
	private static String HIBERNATE_CONNECTION_POOL_SIZE = "hibernate.connection.pool_size";
	private static String HIBERNATE_DIALECT = "hibernate.dialect";
	private static String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static String HIBERNATE_CONTEXT_CLASS = "hibernate.current_session_context_class";
//
//	private static String AUDIT_DB_USER = "db-su-user";
//	private static String AUDIT_DB_PASS = "postgresql-password";
//	private static String AUDIT_DB_SCHEMA = "audit_db_schema";
//
//	private static String IDA_DB_USER = "db-su-user";
//	private static String IDA_DB_PASS = "postgresql-password";
//	private static String IDA_DB_SCHEMA = "ida_db_schema";
//
//	private static String PMS_DB_USER = "db-su-user";
//	private static String PMS_DB_PASS = "postgresql-password";
//	private static String PMS_DB_SCHEMA = "pms_db_schema";
//
//	private static String KM_DB_USER = "db-su-user";
//	private static String KM_DB_PASS = "postgresql-password";
//	private static String KM_DB_SCHEMA = "km_db_schema";
//
	private static String MASTER_DB_USER = "db-su-user";
	private static String MASTER_DB_PASS = "postgresql-password";
	private static String MASTER_DB_SCHEMA = "master_db_schema";
//
	private static String IAM_EXTERNAL_URL = "keycloak-external-url";
	private static String IAM_ADMINPORTAL_PATH = "adminPortalPath";
	private static String IAM_APIENVUSER = "apiEnvUser";
	private static String IAM_APIINTERNALENDPOINT = "apiInternalEndPoint";
	private static String IAM_REALM_ID = "keycloak-realm-id";
	private static String IAM_USERS_TO_CREATE = "iam-users-to-create";
	private static String IAM_USERS_PASSWORD = "iam-users-password";
//
//	private static String AUTH_DEMO_SERVICE_PORT = "authDemoServicePort";
//	private static String AUTH_DEMO_SERVICE_BASE_URL = "authDemoServiceBaseURL";
//	private static String MOUNT_PATH = "mountPath";
//	private static String AUTHCERTS_PATH = "authCertsPath";
//	private static String MOUNT_PATH_FOR_SCENARIO = "mountPathForScenario";
//	
//	private static String PACKET_UTILITY_BASE_URL = "packetUtilityBaseUrl";
	private static String ADMIN_USERNAME = "admin_userName";
	private static String REPORT_EXPIRATION_IN_DAYS = "reportExpirationInDays";
//	private static String pms_client_secret;
//	private static String pms_client_id;
//	private static String pms_app_id;
//
//	private static String resident_client_secret;
//	private static String resident_client_id;
//	private static String resident_app_id;
//
//	private static String mpartner_mobile_client_id;
//	private static String mpartner_mobile_client_secret;
//
	private static String idrepo_client_secret;
	private static String idrepo_client_id;
	private static String idrepo_app_id;
//
	private static String admin_client_secret;
	private static String admin_client_id;
	private static String admin_app_id;
//
//	private static String regproc_client_secret;
//	private static String regproc_client_id;
//	private static String regproc_app_id;
//
//	private static String ida_client_secret;
//	private static String ida_client_id;
//	private static String ida_app_id;
//
//	private static String hotlist_client_secret;
//	private static String hotlist_client_id;
//	private static String hotlist_app_id;
//
	private static String automation_client_secret;
	private static String automation_client_id;
//	private static String automation_app_id;
//
	private static String s3_region;
	private static String s3_host;
	private static String s3_user_key;
	private static String s3_account;
	private static String s3_secret_key;
	private static String push_reports_to_s3;
//	private static String enableDebug;
//	private static String threadCount;
//	private static String langselect;
//
	private static String db_port;
	private static String db_domain;
	private static String hibernate_connection_driver_class;
	private static String hibernate_connection_pool_size;
	private static String hibernate_dialect;
	private static String hibernate_show_sql;
	private static String hibernate_current_session_context_class;
//
//	private static String audit_db_user;
//	private static String audit_db_pass;
//	private static String audit_db_schema;
//
//	private static String ida_db_user;
//	private static String ida_db_pass;
//	private static String ida_db_schema;
//
//	private static String pms_db_user;
//	private static String pms_db_pass;
//	private static String pms_db_schema;
//
//	private static String km_db_user;
//	private static String km_db_pass;
//	private static String km_db_schema;
//
	private static String enableDebug;
	private static String master_db_user;
	private static String master_db_pass;
	private static String master_db_schema;
//
	private static String iam_external_url;
	private static String iam_adminportal_path;
	private static String iam_apienvuser;
	private static String iam_apiinternalendpoint;
	private static String iam_realm_id;
	private static String iam_users_to_create;
	private static String iam_users_password;
//	private static String authDemoServicePort;
//	private static String authDemoServiceBaseUrl;
//
//	private static String mountPath;
//	private static String authCertsPath;
//	private static String mountPathForScenario;
//	private static String packetUtilityBaseUrl;
	public static Properties propsKernel;
	private static String reportExpirationInDays;
	private static String admin_userName;

	public static void setProperty(String key, String value) {
		// Overwrite the value with only if the key exists
		if (propsKernel.containsKey(key)) {
			propsKernel.setProperty(key, value);
		}
	}

	public static String getValueForKey(String key) {
		String value = System.getenv(key) == null ? propsKernel.getProperty(key) : System.getenv(key);
		setProperty(key, value);

		return value;
	}

	public static void init() {
		// Loading Kernel property
//		propsKernel = getproperty(TestRunner.getResourcePath() + "/" + "config/Kernel.properties");
		propsKernel = getproperty(TestRunner.getResourcePath() + "/" + "config/"+TestRunner.GetKernalFilename());

		idrepo_client_secret = getValueForKey(MOSIP_IDREPO_CLIENT_SECRET);
		idrepo_client_id = getValueForKey(MOSIP_IDREPO_CLIENT_ID);
		idrepo_app_id = getValueForKey(MOSIP_IDREPO_APP_ID);
		admin_client_secret = getValueForKey(MOSIP_ADMIN_CLIENT_SECRET);
		admin_client_id = getValueForKey(MOSIP_ADMIN_CLIENT_ID);
		admin_app_id = getValueForKey(MOSIP_ADMIN_APP_ID);
		automation_client_secret = getValueForKey(MOSIP_AUTOMATION_CLIENT_SECRET);
		automation_client_id = getValueForKey(MOSIP_AUTOMATION_CLIENT_ID);
		s3_host = getValueForKey(S3_HOST);
		s3_region = getValueForKey(S3_REGION);
		s3_user_key = getValueForKey(S3_USER_KEY);
		s3_secret_key = getValueForKey(S3_SECRET_KEY);
		s3_account = getValueForKey(S3_ACCOUNT);
		push_reports_to_s3 = getValueForKey(PUSH_TO_S3);
		db_port = getValueForKey(DB_PORT);
		db_domain = getValueForKey(DB_DOMAIN);
		hibernate_connection_driver_class = getValueForKey(HIBERNATE_CONNECTION_DRIVER_CLASS);
		hibernate_connection_pool_size = getValueForKey(HIBERNATE_CONNECTION_POOL_SIZE);
		hibernate_dialect = getValueForKey(HIBERNATE_DIALECT);
		hibernate_show_sql = getValueForKey(HIBERNATE_SHOW_SQL);
		hibernate_current_session_context_class = getValueForKey(HIBERNATE_CONTEXT_CLASS);
		master_db_user = getValueForKey(MASTER_DB_USER);
		master_db_pass = getValueForKey(MASTER_DB_PASS);
		master_db_schema = getValueForKey(MASTER_DB_SCHEMA);
		//admintest data
		iam_external_url = getValueForKey(IAM_EXTERNAL_URL);
		logger.info("keycloakendpoint from config manager::" + iam_external_url);
		iam_adminportal_path =System.getenv(IAM_ADMINPORTAL_PATH) == null
				? propsKernel.getProperty(IAM_ADMINPORTAL_PATH)
				: System.getenv(IAM_ADMINPORTAL_PATH);
		
		logger.info("adminportal_path from config manager::" + iam_adminportal_path);
		iam_apienvuser = System.getenv(IAM_APIENVUSER) == null
				? propsKernel.getProperty(IAM_APIENVUSER)
				: System.getenv(IAM_APIENVUSER);
		logger.info("apienvuser from config manager::" + iam_apienvuser);
		iam_apiinternalendpoint = System.getenv(IAM_APIINTERNALENDPOINT) == null
				? propsKernel.getProperty(IAM_APIINTERNALENDPOINT)
				: System.getenv(IAM_APIINTERNALENDPOINT);
		logger.info("apiinternalendpoint from config manager::" + iam_apiinternalendpoint);
		
		//admin testdata end
		iam_realm_id = getValueForKey(IAM_REALM_ID);
		iam_users_to_create = getValueForKey(IAM_USERS_TO_CREATE);
		iam_users_password = getValueForKey(IAM_USERS_PASSWORD);
		admin_client_secret = System.getenv(MOSIP_ADMIN_CLIENT_SECRET) == null
				? propsKernel.getProperty(MOSIP_ADMIN_CLIENT_SECRET)
				: System.getenv(MOSIP_ADMIN_CLIENT_SECRET);
		propsKernel.setProperty(MOSIP_ADMIN_CLIENT_SECRET, admin_client_secret);
		reportExpirationInDays = System.getenv(REPORT_EXPIRATION_IN_DAYS) == null
				? propsKernel.getProperty(REPORT_EXPIRATION_IN_DAYS)
				: System.getenv(REPORT_EXPIRATION_IN_DAYS);
		propsKernel.setProperty(REPORT_EXPIRATION_IN_DAYS, reportExpirationInDays);			
		
		push_reports_to_s3 =System.getenv(PUSH_TO_S3) == null ? propsKernel.getProperty(PUSH_TO_S3) : System.getenv(PUSH_TO_S3);
		propsKernel.setProperty(PUSH_TO_S3, push_reports_to_s3);

		admin_userName =System.getenv(ADMIN_USERNAME) == null ? propsKernel.getProperty(ADMIN_USERNAME) : System.getenv(ADMIN_USERNAME);
		propsKernel.setProperty(ADMIN_USERNAME, admin_userName);
	}

	public static String getAdminUserName() {
		return admin_userName;
	}
	
	public static String getAdminClientSecret() {
		return admin_client_secret;
	}
	
	public static String getAdminClientId() {
		return admin_client_id;
	}
//
	public static String getAdminAppId() {
		return admin_app_id;
	}
//
	public static String getIdRepoClientSecret() {
		return idrepo_client_secret;
	}
//
	public static String getidRepoClientId() {
		return idrepo_client_id;
	}
//
	public static String getidRepoAppId() {
		return idrepo_app_id;
	}
//
//	public static String getRegprocClientSecret() {
//		return regproc_client_secret;
//	}
//
//	public static String getRegprocClientId() {
//		return regproc_client_id;
//	}
//
//	public static String getRegprocAppId() {
//		return regproc_app_id;
//	}
//
//	public static String getIdaClientSecret() {
//		return ida_client_secret;
//	}
//
//	public static String getIdaClientId() {
//		return ida_client_id;
//	}
//
//	public static String getIdaAppId() {
//		return ida_app_id;
//	}
//
//	public static String getHotListClientSecret() {
//		return hotlist_client_secret;
//	}
//
//	public static String getHotListClientId() {
//		return hotlist_client_id;
//	}
//
//	public static String getHotListAppId() {
//		return hotlist_app_id;
//	}
//
	public static String getAutomationClientSecret() {
		return automation_client_secret;
	}
//
	public static String getAutomationClientId() {
		return automation_client_id;
	}
	public static String getS3Host() {
		return s3_host;
	}
	public static String getReportExpirationInDays() {
		return reportExpirationInDays;
	}
//
	public static String getS3Region() {
		return s3_region;
	}
//
	public static String getS3UserKey() {
		return s3_user_key;
	}
//
	public static String getS3SecretKey() {
		return s3_secret_key;
	}
//
	public static String getS3Account() {
		return s3_account;
	}
//
	public static String getPushReportsToS3() {
		return push_reports_to_s3;
	}
//
	public static String getIdaDbUrl() {
		return "jdbc:postgresql://" + db_domain + ":" + db_port + "/mosip_ida";
	}
//
//	public static String getAuditDbUrl() {
//		return "jdbc:postgresql://" + db_domain + ":" + db_port + "/mosip_audit";
//	}
//
	public static String getDbDriverClass() {
		return hibernate_connection_driver_class;
	}
//
	public static String getDbConnectionPoolSize() {
		return hibernate_connection_pool_size;
	}
//
	public static String getDbDialect() {
		return hibernate_dialect;
	}
//
	public static String getShowSql() {
		return hibernate_show_sql;
	}
//
	public static String getDbSessionContext() {
		return hibernate_current_session_context_class;
	}
	public static Boolean IsDebugEnabled() {
		return enableDebug.equalsIgnoreCase("yes");
	}
//
//	public static String getAuditDbUser() {
//		return audit_db_user;
//	}
//
//	public static String getAuditDbPass() {
//		logger.info("DB Password from ENV::: " + System.getenv(AUDIT_DB_PASS));
//		return audit_db_pass;
//	}
//
//	public static String getAuditDbSchema() {
//		return audit_db_schema;
//	}
//
//	public static String getIdaDbUser() {
//		return ida_db_user;
//	}
//
//	public static String getIdaDbPass() {
//		return ida_db_pass;
//	}
//
//	public static String getIdaDbSchema() {
//		return ida_db_schema;
//	}
//
//	public static String getPMSDbUrl() {
//		return "jdbc:postgresql://" + db_domain + ":" + db_port + "/mosip_pms";
//	}
//
//	public static String getKMDbUrl() {
//		return "jdbc:postgresql://" + db_domain + ":" + db_port + "/mosip_keymgr";
//	}
//
	public static String getMASTERDbUrl() {
		return "jdbc:postgresql://" + db_domain + ":" + db_port + "/mosip_master";
	}
//
//	public static String getPMSDbUser() {
//		return pms_db_user;
//	}
//
//	public static String getPMSDbPass() {
//		return pms_db_pass;
//	}
//
//	public static String getPMSDbSchema() {
//		return pms_db_schema;
//	}
//
//	public static String getKMDbUser() {
//		return km_db_user;
//	}
//
//	public static String getKMDbPass() {
//		return km_db_pass;
//	}
//
//	public static String getKMDbSchema() {
//		return km_db_schema;
//	}
//
	public static String getMasterDbUser() {
		return master_db_user;
	}
//
	public static String getMasterDbPass() {
		return master_db_pass;
	}
//
	public static String getMasterDbSchema() {
		return master_db_schema;
	}
//
//	// from docker env getting only host url
	public static String getIAMUrl() {
		logger.info("keycloak url from ENV::: " + System.getenv(IAM_EXTERNAL_URL) + "/auth");
		logger.info("keycloak url from Property::: " + System.getProperty(IAM_EXTERNAL_URL) + "/auth");
		logger.info("keycloak url from Config::: " + propsKernel.getProperty(IAM_EXTERNAL_URL) + "/auth");
		logger.info("keycloak url is:::" + iam_external_url + "/auth");
		return iam_external_url + "/auth";
	}
//
	public static String getIAMRealmId() {
		return iam_realm_id;
	}
//
	public static String getIAMUsersToCreate() {
		return iam_users_to_create;
	}
//
	public static String getIAMUsersPassword() {
		return iam_users_password;
	}

	public static String getRolesForUser(String userId) {
	//	propsKernel = getproperty(TestRunner.getResourcePath() + "/" + "config/Kernel.properties");
		propsKernel = getproperty(TestRunner.getResourcePath() + "/" + "config/"+TestRunner.GetKernalFilename());
		
		return propsKernel.getProperty("roles." + userId);
	}

	private static Properties getproperty(String path) {
		Properties prop = new Properties();
		try {
			File file = new File(path);
			prop.load(new FileInputStream(file));
		} catch (IOException e) {
			logger.error("Exception " + e.getMessage());
		}
		return prop;
	}

	public static String getiam_adminportal_path() {
		return iam_adminportal_path;
	}
	public static String getiam_apienvuser() {
		return iam_apienvuser;
	}
	public static String getiam_apiinternalendpoint() {
		return iam_apiinternalendpoint;
	}
//	public static String getAuthDemoServiceUrl() {
//		return ConfigManager.getAuthDemoServiceBaseUrl() + ":" + ConfigManager.getAuthDemoServicePort();
//	}

	
	
}