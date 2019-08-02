package com.rex.accountbook.service;

import com.rex.accountbook.dao.model.TradeDao;
import com.rex.accountbook.dao.repository.TradeDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TradeService {

    private TradeDaoRepository tradeDaoRepository;

    @Autowired
    public TradeService(TradeDaoRepository tradeDaoRepository) {
        this.tradeDaoRepository = tradeDaoRepository;
    }

    public TradeDao insert(TradeDao tradeDao) throws Exception {
        return tradeDaoRepository.save(tradeDao);
    }

}
