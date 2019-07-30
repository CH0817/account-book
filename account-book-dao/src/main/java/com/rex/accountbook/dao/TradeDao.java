package com.rex.accountbook.dao;

import com.rex.accountbook.dao.base.BaseDao;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name = "trade")
public class TradeDao extends BaseDao {

    // 帳戶
    @Transient
    private AccountDao account;
    // 費用
    @Column(nullable = false, scale = 2)
    private BigDecimal cost;
    // 費用種類
    @Column(length = 1)
    private String costType;
    // 交易種類
    @Column(length = 1)
    private String tradeType;
    // 交易日
    @Column(nullable = false)
    private LocalDate tradeDate;
    // 備註
    @Column(length = 30)
    private String note;

}
