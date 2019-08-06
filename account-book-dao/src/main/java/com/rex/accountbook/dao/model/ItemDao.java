package com.rex.accountbook.dao.model;

import com.rex.accountbook.dao.model.base.BaseDao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "item", indexes = {@Index(name = "trade_cost_type", columnList = "trade_type_id,name")})
public class ItemDao extends BaseDao {

    @ManyToOne
    @JoinColumn(name = "trade_type_id", nullable = false)
    private TradeTypeDao tradeType;
    @Column(length = 10, nullable = false)
    private String name;

}
