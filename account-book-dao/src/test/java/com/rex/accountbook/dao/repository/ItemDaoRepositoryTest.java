package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.repository.base.BaseRepositoryTest;
import org.springframework.test.context.jdbc.Sql;

@Sql({"classpath:data/item.sql"})
public class ItemDaoRepositoryTest extends BaseRepositoryTest {

    
}
