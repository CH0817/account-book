package com.rex.accountbook.dao;

import com.rex.accountbook.dao.base.BaseDao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cost_type", indexes = {@Index(name = "trade_cost_type", columnList = "trade_type_id,name")})
public class CostTypeDao extends BaseDao {

    @ManyToOne
    @JoinColumn(name = "trade_type_id", nullable = false)
    private TradeTypeDao tradeType;
    @Column(length = 10, nullable = false)
    private String name;

}
