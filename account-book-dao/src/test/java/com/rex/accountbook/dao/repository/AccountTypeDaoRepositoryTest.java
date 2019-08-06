package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.model.AccountTypeDao;
import com.rex.accountbook.dao.repository.base.BaseRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.Assert.assertNotNull;

@Sql({"classpath:data/account_type.sql"})
public class AccountTypeDaoRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private AccountTypeDaoRepository repository;

    @Test
    public void save() {
        AccountTypeDao entity = new AccountTypeDao();
        entity.setName("地下錢莊");
        AccountTypeDao dao = repository.save(entity);
        logger.info(dao.toString());
        assertNotNull(dao.getId());
    }

}
