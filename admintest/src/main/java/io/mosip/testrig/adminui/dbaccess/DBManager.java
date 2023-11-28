package io.mosip.testrig.adminui.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Environment;
//import org.hibernate.jdbc.Work;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.jdbc.Work;

import io.mosip.testrig.adminui.kernel.util.ConfigManager;
import io.mosip.testrig.adminui.utility.BaseClass;

public class DBManager extends BaseClass {

	private static Logger logger = Logger.getLogger(DBManager.class);

//	public static void clearPMSDbData() {
//		Session session = null;
//		try {
//			session = getDataBaseConnection(ConfigManager.getPMSDbUrl(), ConfigManager.getPMSDbUser(),
//					ConfigManager.getPMSDbPass(), ConfigManager.getPMSDbSchema());
//			if (session != null) {
//				session.doWork(new Work() {
//					@Override
//					public void execute(Connection connection) throws SQLException {
//						Statement statement = connection.createStatement();
//						// To Do --- Read the delete queries from a file and iterate
//						try {
//							statement.addBatch("delete from pms.partner_contact where partner_id='Tech-123'");
//							statement.addBatch("delete from partner_policy where part_id='Tech-123'");
//							statement.addBatch("delete from partner_policy where cr_by='partner-111997'");
//							statement.addBatch(
//									"delete from partner_policy where policy_id in (select id from auth_policy where name in ('mosip policy','mosip data share policy'))");
//							statement.addBatch("delete from partner_policy_request where part_id='Tech-123'");
//							statement.addBatch("delete from partner_policy_request where cr_by='partner-111997'");
//							statement.addBatch("delete from pms.partner_policy where label='string'");
//							statement.addBatch(
//									"delete from partner_policy_request where policy_id in (select id from auth_policy where name in ('mosip policy','mosip data share policy'))");
//							statement.addBatch(
//									"delete from partner_policy_bioextract where policy_id in (select id from auth_policy where name in ('mosip policy','mosip data share policy'))");
//							statement.addBatch("delete from partner_policy_bioextract where cr_by='partner-111997'");
//							statement.addBatch("delete from partner_policy_credential_type where part_id='MOVP'");
//							statement.addBatch(
//									"delete from pms.partner_policy_request where cr_by = 'partner-111997'");
//							statement.addBatch(
//									"delete from pms.partner_contact where cr_by = 'partner-111997'");
//							statement.addBatch(
//									"delete from pms.partner where cr_by = 'partner-111997'");
//							statement.addBatch(
//									"delete from pms.partner where id in ('Tech-123','MOVP','DPP','MISP','MISP2','FTP','111997','mosipprint','partner-111997','updatepolicy')");
//							statement.addBatch("delete from auth_policy where cr_by='partner-111997'");
//							statement.addBatch(
//									"delete from pms.auth_policy where name in('mosip policy','mosip policy2','mosip policy3','mosip data share policy','mosip data share policy2')");
//							statement.addBatch("delete from policy_group where cr_by='partner-111997'");
//							statement.addBatch(
//									"delete from pms.policy_group where name in ('mosip policy group','mosip policy role testing groupp','mosip policy group2','update_policy_group')");
//							statement.addBatch("delete from pms.misp_license where cr_by='pm_testuser'");
//							statement.addBatch("delete from pms.misp_license where misp_id in ('MISP','MISP2')");
//							statement.addBatch("delete from pms.ftp_chip_detail where foundational_trust_provider_id='FTP'");
//							statement.addBatch("delete from pms.misp where name='mosip_misp'");
//							statement.addBatch("delete from pms.secure_biometric_interface where provider_id='Tech-123'");
//							statement.addBatch("delete from pms.device_detail where id='device-id-123'");
//							statement.addBatch("delete from pms.device_detail where make in ('abcde','abcdef')");
//							int[] result = statement.executeBatch();
//							logger.info("Success:: Executed PMS DB quiries successfully.");
//							for (int i : result) {
//								logger.info("deleted records: " + i);
//							}
//						} finally {
//							statement.close();
//						}
//	
//					}
//				});
//			}
//		} catch (Exception e) {
//			logger.error("Error:: While executing PMS DB Quiries." + e.getMessage());
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//
//	}
//
//	public static void clearKeyManagerDbData() {
//		Session session = null;
//		try {
//			session = getDataBaseConnection(ConfigManager.getKMDbUrl(), ConfigManager.getKMDbUser(),
//					ConfigManager.getKMDbPass(), ConfigManager.getKMDbSchema());
//			if (session != null) {
//				session.doWork(new Work() {
//	
//					@Override
//					public void execute(Connection connection) throws SQLException {
//						Statement statement = connection.createStatement();
//						// To Do --- Read the delete queries from a file and iterate
//						try {
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.ca_cert_store where cert_subject ='CN=mosiptest.org,O=MOSIPTEST,L=Bangalore,ST=Karantaka,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.partner_cert_store where cert_subject ='CN=Techno.com,O=Techno,L=Bangalore,ST=Karnataka,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.partner_cert_store where cert_subject ='CN=Techno,O=Techno,L=Bangalore,ST=Karnataka,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.ca_cert_store where cert_subject ='CN=apitest,OU=apitest,O=apitest,L=BLR,ST=KAR,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.ca_cert_store where cert_subject ='CN=apitest2,OU=apitest2,O=apitest2,L=BLR,ST=KAR,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.partner_cert_store where cert_subject ='CN=deviceprovider,OU=deviceprovider,O=deviceprovider,L=BLR,ST=KAR,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.partner_cert_store where cert_subject ='CN=movp,OU=movp,O=movp,L=BLR,ST=KAR,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.partner_cert_store where cert_subject ='CN=ftp,OU=ftp,O=ftp,L=BLR,ST=KAR,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.partner_cert_store where cert_subject ='CN=misp,OU=misp,O=misp,L=BLR,ST=KAR,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.partner_cert_store where cert_subject ='CN=misp2,OU=misp2,O=misp2,L=BLR,ST=KAR,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.partner_cert_store where cert_subject ='CN=mosipprint,O=mosipprint,L=Bangalore,ST=Karnataka,C=IN'");
//							statement.addBatch(
//									"delete from mosip_keymgr.keymgr.ca_cert_store where cert_subject ='CN=mosipprint,O=mosipprint,L=Bangalore,ST=Karnataka,C=IN'");
//							int[] result = statement.executeBatch();
//							logger.info("Success:: Executed KM DB quiries successfully.");
//							for (int i : result) {
//								logger.info("KM deleted records: " + i);
//							}
//						} finally {
//							statement.close();
//						}
//					}
//	
//				});
//			}
//		} catch (Exception e) {
//			logger.error("Error:: While executing KM Quiries." + e.getMessage());
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//
//	}

	public static void clearMasterDbData() {
		Session session = null;
		try {

			logger.info("DB URL:: " + ConfigManager.getMASTERDbUrl());
			logger.info("DbUser:: " + ConfigManager.getMasterDbUser());
			logger.info("DbPass:: " + ConfigManager.getMasterDbPass());
			logger.info("DbSchema:: " + ConfigManager.getMasterDbSchema());
			session = getDataBaseConnection(ConfigManager.getMASTERDbUrl(), ConfigManager.getMasterDbUser(),
					ConfigManager.getMasterDbPass(), ConfigManager.getMasterDbSchema());
			if (session != null) {
				session.doWork((Work) new Work() {

					@Override
					public void execute(Connection connection) throws SQLException {
						Statement statement = connection.createStatement();
						// To Do --- Read the delete queries from a file and iterate
						try {
							;
							statement.addBatch("delete from applicant_valid_document where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from appl_form_type  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from biometric_attribute  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from biometric_type  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from blocklisted_words  where cr_by ='"+BaseClass.userid+"'");
//							statement.addBatch("delete from daysofweek_list  where cr_by ='"+BaseClass.userid+"'");
//							statement.addBatch(
//									"delete from device_master  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch(
									"delete from device_master_h  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch(
									"delete from device_spec  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from device_type  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from doc_category  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from doc_type  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from dynamic_field  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from gender  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from id_type  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from individual_type  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from language  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from location  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from loc_hierarchy_list  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from loc_holiday  where cr_by ='"+BaseClass.userid+"'");
							statement
									.addBatch("delete from machine_master  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from machine_master_h  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from machine_spec  where cr_by ='"+BaseClass.userid+"'");
							statement
									.addBatch("delete from machine_type  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from module_detail  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from reason_category  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from reason_list  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from registration_center  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from registration_center_h  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from reg_center_type  where cr_by ='"+BaseClass.userid+"'");
							//statement.addBatch("delete from reg_device_type  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from reg_exceptional_holiday  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from reg_working_nonworking  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from template  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from template_file_format  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from template_type  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from title  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from user_detail  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from user_detail_h  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from valid_document  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from zone  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from zone_user  where cr_by ='"+BaseClass.userid+"'");
							statement
									.addBatch("delete from zone_user_h  where cr_by ='"+BaseClass.userid+"'");
							statement.addBatch("delete from blocklisted_words where cr_by ='"+BaseClass.userid+"'");
							
							
							
							
//							statement.addBatch("delete from master.appl_form_type where cr_by='masterdata-220005'");
//							statement.addBatch("delete from master.id_type where cr_by='masterdata-220005'");
//							statement.addBatch("delete from master.dynamic_field where cr_by='masterdata-220005'");
//							statement.addBatch("delete from master.zone_user where usr_id='masterdata-220005'");
//							statement.addBatch("delete from master.blocklisted_words where word='dumbo6'");
//							statement.addBatch("delete from master.blocklisted_words where word='dumbo7'");
//							statement.addBatch(
//									"delete from master.machine_master where name in ('Mach-Test','Mach-Test2','Mach-Test updated')");
//							statement.addBatch(
//									"delete from master.machine_master where mac_address = '61-D3-FD-12-C9-ED'");
//							statement.addBatch("delete from master.machine_spec where name='HP'");
//							statement.addBatch("delete from master.machine_master where cr_by='masterdata-220005'");
//							statement.addBatch("delete from master.machine_type where code='Laptop2'");
//							statement.addBatch("delete from master.gender where code='Genderdummy'");
//							statement.addBatch(
//									"delete from master.device_master where name in ('testDevicedummy','testDevicedummy updated')");
//							statement.addBatch("delete from master.device_master where dspec_id='743'");
//							statement.addBatch("delete from master.device_spec where id='743'");
//							statement.addBatch("delete from master.device_type where code='GST3'");
//							statement.addBatch("delete from master.loc_holiday where holiday_name='AutoTest user Eng'");
//							statement.addBatch("delete from master.loc_holiday where upd_by='masterdata-220005'");
//							statement.addBatch("delete from master.reg_center_type where code='ALT-3'");
//							statement.addBatch(
//									"delete FROM master.registration_center where name in ('Test123','HSR Center updated')");
//							statement.addBatch(
//									"delete from master.loc_holiday where holiday_name in ('AutoTest user Eng','AutoTest user')");
//							statement.addBatch("delete from master.reg_center_type where code in('ALT-3','ALT-5')");
//							statement.addBatch("delete from master.registration_center where id='10000'");
//							statement.addBatch("delete from master.device_type where code in ('GST3','GST4')");
//							statement.addBatch(
//									"delete from master.doc_type where code in ('TestDocType0010','TestDocType0020')");
//							statement.addBatch(
//									"delete from master.doc_category where code in ('DocTestCode123','DocTestCode321')");
//							statement.addBatch("delete from master.location where code='TST12'");
//							statement.addBatch("delete from master.template where id='445566777'");
//							statement.addBatch(
//									"delete from master.template where template_typ_code IN(select code from master.template_type where code='Test-info-Template-auto')");
//							statement.addBatch(
//									"update master.template set is_active='true', is_deleted='false' where id='1101'");
//							statement.addBatch("delete from master.template_type where code='Test-info-Template-auto'");
//							statement.addBatch(
//									"update master.location set is_active='true', is_deleted='false' where code='10114'");
//							statement.addBatch("delete from master.location where code in('TST123','IND')");
//							statement.addBatch("delete from master.valid_document where doctyp_Code='doc_auto_test'");
//							statement.addBatch("delete from master.user_detail where cr_by='110005'");
//							statement.addBatch("delete from master.template_type where code='Test-info-Template-auto'");
//							statement.addBatch("delete from master.template_file_format where code='Doc'");
//							statement.addBatch("delete from master.reason_list where code='TEST_LIST_CODE'");
//							statement.addBatch("delete from master.reason_category where code='TEST_CAT_CODE'");
//							statement.addBatch("delete from master.language where code='automationLang'");
//							statement.addBatch("delete from master.identity_schema where title='test-schema'");
//							statement.addBatch("delete from master.biometric_attribute where code='TST'");
//							statement.addBatch("delete from master.biometric_type where code='dumbo6'");
//							statement.addBatch("delete from master.appl_form_type where code='dumbo'");
//							statement.addBatch("delete from master.id_type where code='NEW'");
//							statement.addBatch(
//									"delete from master.dynamic_field where name in ('TestAutomationField','TestAPL')");
							int[] result = statement.executeBatch();
							logger.info("Success:: Executed MASTER DB quiries successfully.");
							for (int i : result) {
								logger.info("master db deleted records: " + i);
							}
						} finally {
							statement.close();
						}

					}

				});
			}
		} catch (Exception e) {
			logger.error("Error:: While executing MASTER DB Quiries." + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	private static Session getDataBaseConnection(String dburl, String userName, String password, String schema) {
		SessionFactory factory = null;
		Session session = null;
		
		logger.info("dburl is" + dburl);
		logger.info("userName is" + userName);
		logger.info("password is" + password);
		

		try {
			Configuration config = new Configuration();
			config.setProperty(Environment.DRIVER, ConfigManager.getDbDriverClass());
			config.setProperty(Environment.URL, dburl);
			logger.info("dburl is" + dburl);
			config.setProperty(Environment.USER, userName);
			logger.info("userName is" + userName);
			config.setProperty(Environment.PASS, password);
			logger.info("password is" + password);
			config.setProperty(Environment.DEFAULT_SCHEMA, schema);
			config.setProperty(Environment.POOL_SIZE, ConfigManager.getDbConnectionPoolSize());
			config.setProperty(Environment.DIALECT, ConfigManager.getDbDialect());
			config.setProperty(Environment.SHOW_SQL, ConfigManager.getShowSql());
			config.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, ConfigManager.getDbSessionContext());

			factory = config.buildSessionFactory();
			session = factory.getCurrentSession();
			session.beginTransaction();
		} catch (HibernateException | NullPointerException e) {
			logger.error("Error while getting the db connection for ::" + dburl);
		}
		return session;
	}

}

