create table mvc_board(
    write_no number(10) primary key,
    title varchar2(100),
    content varchar2(300),
    savedate date default sysdate,
    hit number(10) default 0,
    image_file_name varchar(100),
    id varchar(20) not null,
    constraint fk_test foreign key(id) references membership(id) on delete cascade
);

create sequence mvc_board_seq;