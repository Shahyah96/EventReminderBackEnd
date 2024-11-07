-- PostgreSQL Script generated for database schema

-- Disable checks temporarily
SET session_replication_role = 'replica';

-- -----------------------------------------------------
-- Schema event_reminder
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS event_reminder CASCADE;
CREATE SCHEMA event_reminder;
SET search_path TO event_reminder;

-- -----------------------------------------------------
-- Table event_reminder.user_account
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_account;

CREATE TABLE user_account (
                              user_id SERIAL PRIMARY KEY,
                              user_name VARCHAR(45) NOT NULL UNIQUE,
                              password VARCHAR(250) NOT NULL,
                              email VARCHAR(45),
                              mobile_number VARCHAR(45),
                              created_date TIMESTAMP NOT NULL,
                              last_modified_date TIMESTAMP
);

-- -----------------------------------------------------
-- Table event_reminder.device_table
-- -----------------------------------------------------
DROP TABLE IF EXISTS device_table;

CREATE TABLE device_table (
                              device_id SERIAL PRIMARY KEY,
                              user_id INT NOT NULL,
                              device_uuid VARCHAR(200) NOT NULL,
                              push_token VARCHAR(100) NOT NULL UNIQUE,
                              status VARCHAR(15) NOT NULL,
                              created_date TIMESTAMP NOT NULL,
                              last_modified TIMESTAMP,
                              FOREIGN KEY (user_id) REFERENCES user_account(user_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table event_reminder.activity_type
-- -----------------------------------------------------
DROP TABLE IF EXISTS activity_type;

CREATE TABLE activity_type (
                               activity_type_id SERIAL PRIMARY KEY,
                               activity_type VARCHAR(45) NOT NULL,
                               created_date TIMESTAMP NOT NULL,
                               last_modified_date TIMESTAMP NOT NULL
);

-- -----------------------------------------------------
-- Table event_reminder.activity_table
-- -----------------------------------------------------
DROP TABLE IF EXISTS activity_table;

CREATE TABLE activity_table (
                                activity_id SERIAL PRIMARY KEY,
                                user_id INT NOT NULL,
                                activity_type_id INT NOT NULL,
                                title VARCHAR(45) NOT NULL,
                                description VARCHAR(256) NOT NULL,
                                dete TIMESTAMP NOT NULL,
                                time TIMESTAMP,
                                status VARCHAR(45) NOT NULL,
                                created_date TIMESTAMP NOT NULL,
                                last_modified_date TIMESTAMP NOT NULL,
                                deleted_date TIMESTAMP,
                                FOREIGN KEY (user_id) REFERENCES user_account(user_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                FOREIGN KEY (activity_type_id) REFERENCES activity_type(activity_type_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table event_reminder.notification_history
-- -----------------------------------------------------
DROP TABLE IF EXISTS notification_history;

CREATE TABLE notification_history (
                                      notification_id SERIAL PRIMARY KEY,
                                      user_id INT NOT NULL,
                                      activity_id INT NOT NULL,
                                      notification_type VARCHAR(45) NOT NULL,
                                      title VARCHAR(45) NOT NULL,
                                      descrption VARCHAR(256) NOT NULL,
                                      sent_date TIMESTAMP NOT NULL,
                                      created_date TIMESTAMP NOT NULL,
                                      last_updated_date TIMESTAMP,
                                      FOREIGN KEY (user_id) REFERENCES user_account(user_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                      FOREIGN KEY (activity_id) REFERENCES activity_table(activity_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Re-enable checks
SET session_replication_role = 'origin';
