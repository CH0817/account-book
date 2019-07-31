package com.rex.accountbook.service;

import com.rex.accountbook.dao.config.DaoConfig;
import com.rex.accountbook.dao.model.AccountDao;
import com.rex.accountbook.dao.model.CostTypeDao;
import com.rex.accountbook.dao.model.TradeDao;
import com.rex.accountbook.dao.model.TradeTypeDao;
import com.rex.accountbook.dao.repository.TradeDaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TradeService.class})
@EnableJpaRepositories("com.rex.accountbook.dao")
@Import(DaoConfig.class)
public class TradeServiceTest {

    @Autowired
    private TradeService service;
    @SpyBean
    private TradeDaoRepository repository;

    @Test
    public void insert() throws Exception {
        TradeDao tradeDao = new TradeDao();
        tradeDao.setId(1L);

        TradeDao tradeDao2 = new TradeDao();
        tradeDao2.setAccount(new AccountDao());
        tradeDao2.setCost(new BigDecimal(100));
        tradeDao2.setCostType(new CostTypeDao());
        tradeDao2.setTradeDate(LocalDate.now());
        tradeDao2.setTradeType(new TradeTypeDao());

        when(repository.save(tradeDao2)).thenReturn(tradeDao);
        assertNotNull("XDDDDDDDDDDDDDDD", service.insert(tradeDao2));
    }

}
