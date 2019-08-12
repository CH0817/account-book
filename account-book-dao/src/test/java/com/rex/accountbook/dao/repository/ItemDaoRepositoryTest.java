package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.define.TradeTypeEnum;
import com.rex.accountbook.dao.model.ItemDao;
import com.rex.accountbook.dao.repository.base.BaseRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.Assert.assertNotNull;

@Sql({"classpath:data/item.sql"})
public class ItemDaoRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private ItemDaoRepository repository;

    @Test
    public void save() {
        ItemDao entity = new ItemDao();
        entity.setTradeType(TradeTypeEnum.COST.getType());
        entity.setName("遊戲");
        ItemDao dao = repository.save(entity);
        logger.info(dao.toString());
        assertNotNull(dao.getId());
    }

}
