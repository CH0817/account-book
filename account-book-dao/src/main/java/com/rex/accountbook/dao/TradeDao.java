package com.rex.accountbook.dao;

import com.rex.accountbook.dao.base.BaseDao;
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
    private String costType;
    @Column(length = 1, nullable = false)
    private String tradeType;
    @Column(nullable = false)
    private LocalDate tradeDate;
    @Column(length = 30)
    private String note;

}
