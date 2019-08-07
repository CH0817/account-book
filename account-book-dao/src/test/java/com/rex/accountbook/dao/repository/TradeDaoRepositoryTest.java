package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.repository.base.BaseRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

// 測試資料
@Sql({"classpath:data/account_type.sql", "classpath:data/account.sql", "classpath:data/item.sql", "classpath:data/trade.sql"})
public class TradeDaoRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private AccountDaoRepository accountDaoRepository;
    @Autowired
    private AccountTypeDaoRepository accountTypeDaoRepository;
    @Autowired
    private ItemDaoRepository itemDaoRepository;
    @Autowired
    private TradeDaoRepository tradeDaoRepository;

    @Test
    public void save() {
        // do test
        // repository.save(new TradeDao());
    }

}