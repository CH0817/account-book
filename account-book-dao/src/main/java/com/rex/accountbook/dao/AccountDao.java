package com.rex.accountbook.dao;

import com.rex.accountbook.dao.base.BaseDao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO 未完
@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountDao extends BaseDao {

    // 名稱
    @Column(length = 10, nullable = false)
    private String name;

}
