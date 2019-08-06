insert into item (trade_type_id, name) select id, '薪資' from trade_type where type = '收入';
insert into item (trade_type_id, name) select id, '早餐' from trade_type where type = '支出';