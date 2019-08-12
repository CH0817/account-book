package com.rex.accountbook.service;

import com.rex.accountbook.dao.model.AccountTypeDao;
import com.rex.accountbook.dao.repository.AccountTypeDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeService {

    private AccountTypeDaoRepository repository;

    @Autowired
    public AccountTypeService(AccountTypeDaoRepository repository) {
        this.repository = repository;
    }

    public AccountTypeDao save(AccountTypeDao entity) {
        return repository.save(entity);
    }

}
