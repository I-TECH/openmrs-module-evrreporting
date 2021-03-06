DROP PROCEDURE IF EXISTS create_etl_tables$$
CREATE PROCEDURE create_etl_tables()
BEGIN
DECLARE script_id INT(11);
-- create/recreate database openmrs_etl
SELECT "Recreating openmrs_etl database";
drop database if exists openmrs_etl;
create database openmrs_etl;

-- ------------------- create table to hold etl script progress ------------------

DROP TABLE IF EXISTS openmrs_etl.etl_script_status;
CREATE TABLE openmrs_etl.etl_script_status(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
script_name VARCHAR(50) DEFAULT null,
start_time DATETIME DEFAULT NULL,
stop_time DATETIME DEFAULT NULL,
proc_time DATETIME DEFAULT 0,
error VARCHAR(255) DEFAULT NULL,
INDEX(stop_time),
INDEX(start_time)
);

-- Log start time
INSERT INTO openmrs_etl.etl_script_status(script_name, start_time) VALUES('initial_creation_of_tables', NOW());
SET script_id = LAST_INSERT_ID();

SELECT "Droping existing etl tables";

DROP TABLE if exists openmrs_etl.etl_patient_demographics;
DROP TABLE if exists openmrs_etl.etl_immunisations;

SELECT "Recreating etl tables";
-- create table etl_patient_demographics
create table openmrs_etl.etl_patient_demographics (
patient_id INT(11) not null primary key,
given_name VARCHAR(50),
middle_name VARCHAR(50),
family_name VARCHAR(50),
gender VARCHAR(10),
dob DATE,
national_id_no VARCHAR(50),
kip_id VARCHAR(50),
permanent_register_number VARCHAR(50) DEFAULT NULL,
nupi VARCHAR(50) DEFAULT NULL,
cwc_number VARCHAR(50) DEFAULT NULL,
hdss_number VARCHAR(50) DEFAULT NULL,
child_birth_notification_number VARCHAR(50) DEFAULT NULL,
first_health_facility_contact DATE,
mother_first_name VARCHAR(100) DEFAULT NULL,
mother_last_name VARCHAR(100) DEFAULT NULL,
mother_gender VARCHAR(7),
mother_dob DATE,
mother_relationship VARCHAR(50) DEFAULT NULL,
mother_national_id VARCHAR(20) DEFAULT NULL,
mother_phone_numer VARCHAR(20) DEFAULT NULL,
guardian_first_name VARCHAR(100) DEFAULT NULL,
guardian_last_name VARCHAR(100) DEFAULT NULL,
guardian_gender VARCHAR(7),
guardian_dob DATE,
guardian_relationship VARCHAR(50) DEFAULT NULL,
guardian_national_id VARCHAR(20) DEFAULT NULL,
county_id INT(11),
county VARCHAR(50),
sub_county_id INT(11),
sub_county VARCHAR(50),
ward_id INT(11),
ward VARCHAR(50),
health_facility_id INT(11),
health_facility VARCHAR(100),
sub_location VARCHAR(50),
village VARCHAR(50),
address VARCHAR(50),
landmark VARCHAR(50),
hei VARCHAR(20),
date_created DATETIME,
index(patient_id),
index(Gender),
index(permanent_register_number),
index(nupi),
index(cwc_number),
index(hdss_number),
index(child_birth_notification_number),
index(DOB)
);

SELECT "Successfully created etl_patient_demographics table";


-- create table etl_immunisations
create table openmrs_etl.etl_immunisations (
patient_id INT(11) NOT NULL PRIMARY KEY,
bcg_vx_date DATE,
opv_0_vx_date DATE,
opv_1_vx_date DATE,
pcv_1_vx_date DATE,
penta_1_vx_date DATE,
rota_1_vx_date DATE,
opv_2_vx_date DATE,
pcv_2_vx_date DATE,
penta_2_vx_date DATE,
rota_2_vx_date DATE,
opv_3_vx_date DATE,
pcv_3_vx_date DATE,
penta_3_vx_date DATE,
ipv_vx_date DATE,
mr_1_vx_date DATE,
mr_2_vx_date DATE,
mr_at_6_vx_date DATE,
yf_vx_date DATE,
vit_at_6_vx_date DATE,
CONSTRAINT FOREIGN KEY (patient_id) REFERENCES openmrs_etl.etl_patient_demographics(patient_id),
INDEX(patient_id)
);
SELECT "Successfully created etl_immunisations table";


-- create table etl_moh_710
create table openmrs_etl.etl_moh_710 (
id INT(11) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
county_id INT(11),
sub_county_id INT(11),
ward_id INT(11),
health_facility_id int(11),
year year(4),
month tinyint(2),
bcg_lt_1 int,
bcg_gt_1 int,
opv_0 int,
opv_1_lt_1 int,
opv_1_gt_1 int,
opv_2_lt_1 int,
opv_2_gt_1 int,
opv_3_lt_1 int,
opv_3_gt_1 int,
ipv_lt_1 int,
ipv_gt_1 int,
penta_1_lt_1 int,
penta_1_gt_1 int,
penta_2_lt_1 int,
penta_2_gt_1 int,
penta_3_lt_1 int,
penta_3_gt_1 int,
pcv_1_lt_1 int,
pcv_1_gt_1 int,
pcv_2_lt_1 int,
pcv_2_gt_1 int,
pcv_3_lt_1 int,
pcv_3_gt_1 int,
rota_1_lt_1 int,
rota_2_lt_1 int,
vit_at_6 int,
yf_lt_1 int,
yf_gt_1 int,
mr_1_lt_1 int,
mr_1_gt_1 int,
fic int,
vit_1 int,
vit_1_half int,
mr_2_1_half_2 int,
mr_2_gt_2 int,
vit_2_to_5 int,
unique(health_facility_id, year, month),
INDEX(health_facility_id)
);
SELECT "Successfully created etl_moh_710 table";


-- Update stop time for script

UPDATE openmrs_etl.etl_script_status SET proc_time="1000-01-01 00:00:00", stop_time=NOW() where id= script_id;


END$$

