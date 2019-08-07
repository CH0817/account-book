package com.rex.accountbook.service;

import com.rex.accountbook.dao.model.TradeDao;
import com.rex.accountbook.dao.repository.TradeDaoRepository;
import org.springframework.beans.BeanUtils;
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

    public void deleteById(long id) {
        tradeDaoRepository.deleteById(id);
    }

    public TradeDao findById(long id) throws Exception {
        return tradeDaoRepository.findById(id).orElseThrow(() -> new Exception("can not found"));
    }

    public TradeDao updateById(TradeDao entity) throws Exception {
        TradeDao tradeDao = tradeDaoRepository.findById(entity.getId())
                                              .orElseThrow(() -> new Exception("can not found"));
        BeanUtils.copyProperties(entity, tradeDao, "id");
        return tradeDaoRepository.saveAndFlush(tradeDao);
    }
}
