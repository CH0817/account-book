package com.rex.accountbook.service;

import com.rex.accountbook.dao.model.TradeDao;
import com.rex.accountbook.dao.repository.TradeDaoRepository;
import com.rex.accountbook.service.base.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * 只測試邏輯、 DAO 是否正常呼叫，不測試 data 是否真的進 DB
 */
public class TradeServiceTest extends BaseServiceTest {

    @Autowired
    private TradeService service;
    @MockBean
    private TradeDaoRepository repository;

    @Test
    public void insert() throws Exception {
        TradeDao dao = new TradeDao();
        TradeDao saveResult = new TradeDao();
        saveResult.setId(1L);
        when(repository.save(dao)).thenReturn(saveResult);
        service.insert(dao);
        verify(repository, times(1)).save(dao);
    }

    @Test
    public void deleteById() {
        service.deleteById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

}
