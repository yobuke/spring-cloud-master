drop table item_table if exists;
create table item_table (id bigint generated by default as identity, itemsn varchar(20), item_name varchar(20), primary key (id));