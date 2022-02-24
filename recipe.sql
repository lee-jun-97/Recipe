create table user
(
	seq int not null auto_increment primary key comment '시퀀스',
	name varchar(10) not null comment '이름',
	nickname varchar(10) not null comment '닉네임',
	id varchar(10) not null comment 'ID',
	pw varchar(40) not null comment '비밀번호',
	join_date date not null comment '가입일자',
	leave_date date comment '탈퇴일자'
);

insert into user(name,nickname,id,pw,join_date) values('test','test','test','test','2022-02-24');

select * from user;

commit;

alter table user comment ='유저 정보';

create table post
(
	seq int not null auto_increment primary key comment '시퀀스',
	id varchar(10) not null comment 'ID',
	menu varchar(10) not null comment '메뉴',
	title varchar(20) not null comment '제목',
	reg_date date not null comment '게시 일자'
);

alter table post comment = '게시물 목록';

create table food_ingredient
(
	seq int not null auto_increment primary key comment '시퀀스',
	id varchar(10) not null comment 'ID',
	menu varchar(10) not null comment '메뉴',
	ingredient varchar(20) not null comment '재료',
	amount varchar(20) not null comment '양'
);

alter table food_ingredient comment = '음식 재료 목록';

create table recipe
(
	seq int not null auto_increment primary key comment '시퀀스',
	id varchar(10) not null comment 'ID',
	menu varchar(10) not null comment '메뉴',
	recipe varchar(100) not null comment '조리법'
);

alter table recipe comment = '음식 조리법';

commit;