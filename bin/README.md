### 스프링 파이널 테스트

# 의존성

- Spring Boot DevTools
- Lombok
- Mybatis Framework
- MySQL Driver
- Mustache
- Spring Web

# MYSQL 셋팅

```sql
create user 'final'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'final'@'%';
create database final;
use final;


DROP table stadium;
DROP table team;
DROP table player;
DROP table expulsion;

##야구장
CREATE TABLE stadium(
	id int auto_increment primary key,
    name varchar(100) unique not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;

##팀
CREATE TABLE team(
	id int auto_increment primary key,
    stadiumId int,
    name varchar(100) unique not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;

##선수
CREATE TABLE player(
	id int auto_increment primary key,
    name varchar(100) unique not null,
    teamId int,
    position varchar(100) not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;


#퇴출
CREATE TABLE expulsion(
	id int auto_increment primary key,
    reason varchar(100) unique not null,
    playerId int,
    createDate timestamp
) engine=InnoDB default charset=utf8;

##제약조건
alter table team add constraint foreign key
(stadiumId) references stadium (id)
on delete cascade;

alter table player add constraint foreign key
(teamId) references team (id)
on delete cascade;

alter table expulsion add constraint foreign key
(playerId) references player (id)
on delete cascade;


commit;


```
