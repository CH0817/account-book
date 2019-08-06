package com.rex.accountbook.dao.model;

import com.rex.accountbook.dao.model.base.BaseDao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "item", indexes = {@Index(name = "trade_cost_type", columnList = "trade_type,name")})
public class ItemDao extends BaseDao {

    @Column(name = "trade_type", length = 1, nullable = false)
    private String tradeType;
    @Column(length = 10, nullable = false)
    private String name;

}
