DROP DATABASE IF EXISTS mldn ;
CREATE DATABASE mldn CHARACTER SET UTF8 ;
USE mldn ;
CREATE TABLE member (
   mid                  varchar(50) not null,
   name					varchar(50),
   CONSTRAINT pk_mid PRIMARY KEY (mid)
) engine="innodb";
CREATE TABLE role (
   rid                bigint               auto_increment,
   title              varchar(50),
   flag               varchar(50),
   constraint pk_rid primary key (rid)
) engine="innodb";
CREATE TABLE member_role (
   mid                varchar(50),
   rid                bigint ,
   CONSTRAINT fk_mid FOREIGN KEY(mid) REFERENCES member(mid) ,
   CONSTRAINT fk_rid2 FOREIGN KEY(rid) REFERENCES role(rid) 
) engine="innodb";
INSERT INTO member(mid,name) VALUES ('vadmin','魔乐科技') ;
INSERT INTO member(mid,name) VALUES ('mldn','老李') ;
INSERT INTO role(title,flag) VALUES ('【管理员】用户管理','member') ;
INSERT INTO role(title,flag) VALUES ('【管理员】商品管理','goods') ;
INSERT INTO role(title,flag) VALUES ('【管理员】订单管理','orders') ;
INSERT INTO role(title,flag) VALUES ('【管理员】后台管理','admin') ;
INSERT INTO role(title,flag) VALUES ('【前台用户】个人中心','center') ;
INSERT INTO role(title,flag) VALUES ('【前台用户】购物车','shopcar') ;
INSERT INTO role(title,flag) VALUES ('【前台用户】个人资料','info') ;
INSERT INTO role(title,flag) VALUES ('【前台用户】地址管理','address') ;
INSERT INTO role(title,flag) VALUES ('【前台用户】订单中心','orders') ;
INSERT INTO member_role(mid,rid) VALUES ('vadmin',1) ;
INSERT INTO member_role(mid,rid) VALUES ('vadmin',2) ;
INSERT INTO member_role(mid,rid) VALUES ('vadmin',3) ;
INSERT INTO member_role(mid,rid) VALUES ('vadmin',4) ;
INSERT INTO member_role(mid,rid) VALUES ('vadmin',5) ;
INSERT INTO member_role(mid,rid) VALUES ('vadmin',6) ;
INSERT INTO member_role(mid,rid) VALUES ('vadmin',7) ;
INSERT INTO member_role(mid,rid) VALUES ('vadmin',8) ;
INSERT INTO member_role(mid,rid) VALUES ('vadmin',9) ;
INSERT INTO member_role(mid,rid) VALUES ('mldn',5) ;
INSERT INTO member_role(mid,rid) VALUES ('mldn',6) ;
INSERT INTO member_role(mid,rid) VALUES ('mldn',7) ;
INSERT INTO member_role(mid,rid) VALUES ('mldn',8) ;
INSERT INTO member_role(mid,rid) VALUES ('mldn',9) ;
