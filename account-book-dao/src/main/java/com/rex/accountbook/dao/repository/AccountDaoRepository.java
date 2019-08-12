package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.model.AccountDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDaoRepository extends JpaRepository<AccountDao, Long> {
}
