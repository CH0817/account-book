package com.rex.accountbook.dao.model;

import com.rex.accountbook.dao.model.base.BaseDao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "account", indexes = {@Index(name = "account_type_index", columnList = "name,type_id", unique = true)})
public class AccountDao extends BaseDao {

    @Column(length = 10, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AccountTypeDao type;
    @Column(nullable = false, scale = 2)
    private BigDecimal initAmount = BigDecimal.ZERO;

}
