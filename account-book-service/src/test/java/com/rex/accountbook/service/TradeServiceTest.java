package com.rex.accountbook.service;

import com.rex.accountbook.dao.model.TradeDao;
import com.rex.accountbook.dao.repository.TradeDaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * 只測試邏輯、 DAO 是否正常呼叫，不測試 data 是否真的進 DB
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TradeService.class})
public class TradeServiceTest {

    @Autowired
    private TradeService service;
    @MockBean
    private TradeDaoRepository repository;

    @Test
    public void insert() throws Exception {
        TradeDao dao = new TradeDao();
        TradeDao saveResult = new TradeDao();
        saveResult.setId(1L);
        when(repository.save(any(TradeDao.class))).thenReturn(saveResult);
        service.insert(dao);
        verify(repository, atLeastOnce()).save(dao);
    }

}
