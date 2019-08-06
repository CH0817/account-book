package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.model.TradeTypeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeTypeDaoRepository extends JpaRepository<TradeTypeDao, Long> {
}
