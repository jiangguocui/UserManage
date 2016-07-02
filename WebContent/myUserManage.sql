
CREATE TABLE political (
id bigint(20) NOT NULL AUTO_INCREMENT,
name VARCHAR(50) UNIQUE,
spare1 int(11),
spare2 VARCHAR(50),
PRIMARY KEY(id)
);

CREATE TABLE degree (
id bigint(20) NOT NULL AUTO_INCREMENT,
name VARCHAR(50) UNIQUE,
spare1 int(11),
spare2 VARCHAR(50),
PRIMARY KEY(id)
);


CREATE TABLE t_user(
id bigint(20) NOT NULL AUTO_INCREMENT,
user_name VARCHAR(20) NOT NULL,
user_password VARCHAR(200) NOT NULL,
user_birthday  VARCHAR(50),
user_gender VARCHAR(10),
user_email VARCHAR(50),
user_phone VARCHAR(20),
user_school VARCHAR(50),
user_degreesId  bigint(20) ,
user_politicalId  bigint(20),
user_adress VARCHAR(200),
user_picture VARCHAR(200),
salary DOUBLE(12,4),
company VARCHAR(100),
job VARCHAR(100),
spare1 INT(11),
spare2 VARCHAR(50),
spare3 VARCHAR(200),
PRIMARY KEY(id)

);
alter table t_user add constraint fk_political FOREIGN KEY (user_politicalId) REFERENCES political(id)
 ON DELETE CASCADE;
alter table t_user add constraint fk_degree FOREIGN KEY (user_degreesId) REFERENCES degree(id)
     ON DELETE CASCADE;


CREATE TABLE t_manager(
manager_id bigint(20)  NOT NULL AUTO_INCREMENT,
manager_name VARCHAR(20) NOT NULL UNIQUE,
manager_password VARCHAR(255) NOT NULL,
manager_email VARCHAR(50),
manager_phone VARCHAR(20),
spare1 INT(11),
spare2 VARCHAR(50),
PRIMARY KEY(manager_id)
);

INSERT INTO `degree` (name) VALUES ('高中');
INSERT INTO `degree` (name) VALUES ('本科');
INSERT INTO `degree` (name) VALUES ('初中');
INSERT INTO `degree` (name) VALUES ('小学');
INSERT INTO `degree` (name) VALUES ('硕士');
INSERT INTO `degree` (name) VALUES ('专科');
INSERT INTO `degree` (name) VALUES ('博士后');

INSERT INTO `political` (name) VALUES ('团员');
INSERT INTO `political` (name) VALUES ('预备党员');
INSERT INTO `political` (name) VALUES ('党员');
INSERT INTO `political` (name) VALUES ('群众');

INSERT INTO `t_manager`(manager_email,manager_name,manager_password,manager_phone) VALUES ('2642556850@qq.com', '王凯', 'E10ADC3949BA59ABBE56E057F20F883E', '18202793832');

INSERT INTO `t_user`(company,job,salary,user_adress,user_birthday,user_email,user_gender,user_name,user_password,user_phone,user_school,user_degreesId,user_politicalId) VALUES ('武汉大学', '老师', '2343','湖北省武汉市', '1989-10-23', '2642556850@qq.com', '男', '胡涛', 'E10ADC3949BA59ABBE56E057F20F883E', '18202793832','武汉大学', '1', '1');
INSERT INTO `t_user`(company,job,salary,user_adress,user_birthday,user_email,user_gender,user_name,user_password,user_phone,user_school,user_degreesId,user_politicalId) VALUES ('广西大学', '老师', '2342','广西南宁', '1987-1-1', '1782386232@qq.com', '女', '丽丽', 'E10ADC3949BA59ABBE56E057F20F883E', '13435454545','广西大学', '3', '1');
INSERT INTO `t_user`(company,job,salary,user_adress,user_birthday,user_email,user_gender,user_name,user_password,user_phone,user_school,user_degreesId,user_politicalId) VALUES ('湖北大学', '学生', '123','湖北省武汉市', '1993-10-23', '1782386232@qq.com', '女', 'jgc', 'E10ADC3949BA59ABBE56E057F20F883E', '18202793832','湖北大学', '4', '3');
INSERT INTO `t_user`(company,job,salary,user_adress,user_birthday,user_email,user_gender,user_name,user_password,user_phone,user_school,user_degreesId,user_politicalId) VALUES ('武汉大学', '学生','2343', '重庆市', '1993-10-23', '1731805893@qq.com', '男', '王凯', 'E10ADC3949BA59ABBE56E057F20F883E', '18202793832','武汉大学', '1', '1');
INSERT INTO `t_user`(company,job,salary,user_adress,user_birthday,user_email,user_gender,user_name,user_password,user_phone,user_school,user_degreesId,user_politicalId) VALUES ('武汉大学', '学生','2343', '湖北省武汉市', '1993-10-23', '1782386232@qq.com', '男', '王丽', 'E10ADC3949BA59ABBE56E057F20F883E', '18202710043','武汉大学', '1', '1');
INSERT INTO `t_user`(company,job,salary,user_adress,user_birthday,user_email,user_gender,user_name,user_password,user_phone,user_school,user_degreesId,user_politicalId) VALUES ('武汉大学', '老师', '2343','湖北省武汉市', '2015-07-23', '1731805893@qq.com', '男', '彬彬', 'E10ADC3949BA59ABBE56E057F20F883E', '18202710043','武汉大学', '1', '1');


