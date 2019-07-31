package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.model.TradeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeDaoRepository extends JpaRepository<TradeDao, Long> {}
