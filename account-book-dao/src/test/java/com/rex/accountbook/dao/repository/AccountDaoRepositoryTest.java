package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.model.AccountDao;
import com.rex.accountbook.dao.model.AccountTypeDao;
import com.rex.accountbook.dao.repository.base.BaseRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

@Sql({"classpath:data/account_type.sql", "classpath:data/account.sql"})
public class AccountDaoRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private AccountDaoRepository repository;

    @Test
    public void save() {
        AccountDao entity = new AccountDao();
        entity.setInitAmount(new BigDecimal(0));
        entity.setName("地下錢莊");
        AccountTypeDao accountType = new AccountTypeDao();
        accountType.setId(1L);
        entity.setType(accountType);
        AccountDao dao = repository.save(entity);
        logger.info(dao.toString());
        assertNotNull(dao.getId());
    }

}
