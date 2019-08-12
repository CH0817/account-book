package com.rex.accountbook.dao.repository;

import com.rex.accountbook.dao.model.ItemDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDaoRepository extends JpaRepository<ItemDao, Long> {
}
