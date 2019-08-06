package com.rex.accountbook.dao.model;

import com.rex.accountbook.dao.model.base.BaseDao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "trade")
public class TradeDao extends BaseDao {

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountDao account;
    @Column(nullable = false, scale = 2)
    private BigDecimal cost;
    @Column(length = 1, nullable = false)
    private String tradeType;
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private ItemDao item;
    @Column(nullable = false)
    private LocalDate tradeDate;
    @Column(length = 30)
    private String note;

}
