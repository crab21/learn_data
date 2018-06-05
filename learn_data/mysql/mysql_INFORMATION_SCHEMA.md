select * from information_schema.TABLES where TABLE_SCHEMA=(select database());

select * from information_schema.TABLES;

use information_schema;

select auto_increment from tables where table_name='seninfo';

show columns from seninfo;