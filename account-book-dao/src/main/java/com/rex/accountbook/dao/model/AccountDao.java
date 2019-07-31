package com.rex.accountbook.dao.model;

import com.rex.accountbook.dao.model.base.BaseDao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "account", indexes = {@Index(name = "account_type_index", columnList = "name,type", unique = true)})
public class AccountDao extends BaseDao {

    @Column(length = 10, nullable = false)
    private String name;
    @Column(length = 1, nullable = false)
    private String type;
    @Column(nullable = false, scale = 2)
    private BigDecimal initAmount = BigDecimal.ZERO;

}
