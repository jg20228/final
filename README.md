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
```

# 더미 데이터

```sql
INSERT into stadium(name,createDate)
VALUES("사직야구장",now());
INSERT into stadium(name,createDate)
VALUES("구덕야구장",now());
INSERT into stadium(name,createDate)
VALUES("잠실야구장",now());

INSERT into team(stadiumId,name,createDate)
VALUES("1","두산",now());
INSERT into team(stadiumId,name,createDate)
VALUES("2","NC",now());
INSERT into team(stadiumId,name,createDate)
VALUES("3","롯데",now());

INSERT into player(name,teamId,position,createDate)
VALUES("김민재",1,"타자",now());
INSERT into player(name,teamId,position,createDate)
VALUES("채지선",1,"투수",now());
INSERT into player(name,teamId,position,createDate)
VALUES("알칸타라",1,"외야수",now());


INSERT into player(name,teamId,position,createDate)
VALUES("손민한",2,"타자",now());
INSERT into player(name,teamId,position,createDate)
VALUES("루친스키",2,"투수",now());
INSERT into player(name,teamId,position,createDate)
VALUES("박석민",2,"내야수",now());


INSERT into player(name,teamId,position,createDate)
VALUES("오윤석",3,"타자",now());
INSERT into player(name,teamId,position,createDate)
VALUES("박세웅",3,"투수",now());
INSERT into player(name,teamId,position,createDate)
VALUES("오태근",3,"내야수",now());
```

# pivot
```sql
SELECT POSITION,
MAX(if(teamId=1,name,""))"두산",
MAX(if(teamId=2,name,""))"NC",
MAX(if(teamId=3,name,""))"롯데"
FROM player
GROUP BY position;
```

# rank
```sql
SELECT p.id, t.name "teamName", p.position, p.name "playerName", p.createDate
, ( SELECT COUNT(*) + 1 FROM player WHERE name <![CDATA[<]]> p.name ) AS no
FROM player p INNER JOIN team t
ON p.teamId = t.id
order by no;
```