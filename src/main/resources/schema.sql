drop table if exists todo;
create table todo (id bigint not null, description varchar(255), is_done boolean not null, target_date timestamp, username varchar(255), primary key (id));