package com.rex.accountbook.service;

import com.rex.accountbook.dao.model.AccountDao;
import com.rex.accountbook.dao.repository.AccountDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccountService {

    private AccountDaoRepository repository;

    @Autowired
    public AccountService(AccountDaoRepository repository) {
        this.repository = repository;
    }

    public AccountDao save(AccountDao entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public AccountDao findById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("can not found id " + id));
    }

}
