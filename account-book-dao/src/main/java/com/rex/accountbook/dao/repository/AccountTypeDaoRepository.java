package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.model.AccountTypeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeDaoRepository extends JpaRepository<AccountTypeDao, Long> {
}
