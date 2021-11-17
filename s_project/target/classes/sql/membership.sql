create table membership(
    id varchar2(20) primary key,
    pw varchar2(100),
    addr varchar2(300),
    session_id varchar2(100) default 'nan' not null,
    limit_time date
);