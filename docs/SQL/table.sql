DROP TABLE IF EXISTS `rc_district`;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;

-- ----------------------------
-- Table structure for t_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `t_dict_type`;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;

-- ----------------------------
-- Table structure for t_emp_rel_com
-- ----------------------------
DROP TABLE IF EXISTS `t_emp_rel_com`;

-- ----------------------------
-- Table structure for t_recruit
-- ----------------------------
DROP TABLE IF EXISTS `t_recruit`;


-- ----------------------------
-- Table structure for t_resume
-- ----------------------------
DROP TABLE IF EXISTS `t_resume`;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;




create table rc_district
(
  id       int(5) unsigned auto_increment
    primary key,
  pid      int(5) unsigned default 0  not null comment '父及地区关系',
  district varchar(120)    default '' not null comment '地区名称',
  level    int(1)                     not null comment '子属级别关系'
)
  comment '全国地区表';

create table t_company
(
  t_com_id      varchar(36)  not null
    primary key,
  t_com_name    varchar(255) null,
  t_com_type    varchar(50)  null,
  t_com_info    varchar(255) null,
  t_remark      varchar(255) null,
  t_com_address varchar(255) null,
  t_user_id     varchar(36)  null,
  t_com_tel     varchar(15)  null,
  t_create_time datetime     null,
  status        varchar(3)   null
);

create table t_dict
(
  t_dict_type_id varchar(15) null,
  t_dict_id      varchar(30) null,
  t_dict_name    varchar(30) null
);

create table t_dict_type
(
  t_dict_type_id   varchar(15) not null
    primary key,
  t_dict_type_name varchar(50) null
);

create table t_emp
(
  t_emp_id      varchar(36)  not null
    primary key,
  t_user_id     varchar(36)  null,
  t_emp_name    varchar(36)  null,
  t_emp_job     varchar(36)  null,
  t_emp_salary  int          null,
  t_emp_area    varchar(64)  null,
  t_remark      varchar(255) null,
  t_create_time datetime     null
);

create table t_emp_rel_com
(
  t_rel_id varchar(36) not null
    primary key,
  t_emp_id varchar(36) null,
  t_com_id varchar(36) null,
  status   varchar(36) null
);

create table t_recruit
(
  t_recruit_id        varchar(36)  not null
    primary key,
  t_com_id            varchar(36)  null,
  t_user_id           varchar(36)  null,
  t_job_name          varchar(64)  null,
  t_job_number        int          null,
  t_job_province      varchar(36)  null,
  t_job_city          varchar(36)  null,
  t_job_town          varchar(36)  null,
  t_job_area          varchar(64)  null,
  t_recruit_condition varchar(255) null,
  t_min_salary        int          null,
  t_max_salary        int          null,
  t_begin_time        date         null,
  t_end_time          date         null,
  t_create_time       datetime     null,
  status              varchar(3)   null,
  valid               varchar(3)   null
);

create table t_resume
(
  t_resume_id       varchar(36)  not null
    primary key,
  t_user_id         varchar(36)  null,
  t_file_id         varchar(255) null,
  t_name            varchar(36)  null,
  t_sex             varchar(2)   null,
  t_nation          varchar(16)  null,
  t_birth_date      date         null,
  t_birth_area      varchar(32)  null,
  t_local_area      varchar(32)  null,
  t_graduation      varchar(64)  null,
  t_education_level varchar(16)  null,
  t_major           varchar(32)  null,
  t_politics_status varchar(32)  null,
  t_phone           varchar(32)  null,
  t_email           varchar(255) null,
  t_job_name        varchar(36)  null,
  t_skill           varchar(255) null,
  t_experience      varchar(255) null
);

create table t_user
(
  t_user_id     varchar(36)  not null comment '与login关联'
    primary key,
  t_user_name   varchar(50)  null,
  t_real_name   varchar(50)  null,
  t_pwd         varchar(30)  not null,
  t_phone       varchar(12)  null,
  status        varchar(2)   null,
  t_sex         varchar(2)   null,
  t_email       varchar(36)  null,
  t_user_image  varchar(255) null,
  t_create_time datetime     null
);

commit;