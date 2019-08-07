insert into account (id, init_amount, name, type_id) select 1,  0, '測試銀行', id from account_type where name = '銀行';
insert into account (id, init_amount, name, type_id) select 2,  0, '測試現金', id from account_type where name = '現金';
insert into account (id, init_amount, name, type_id) select 3,  0, '測試信用卡', id from account_type where name = '信用卡';