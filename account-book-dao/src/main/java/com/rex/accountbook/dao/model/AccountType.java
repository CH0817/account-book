package com.rex.accountbook.dao.model;

import com.rex.accountbook.dao.model.base.BaseDao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "account_type")
public class AccountType extends BaseDao {

    @Column(length = 5, nullable = false, unique = true)
    private String name;

}
