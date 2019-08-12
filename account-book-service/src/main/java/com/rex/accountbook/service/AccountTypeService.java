package com.rex.accountbook.service;

import com.rex.accountbook.dao.model.AccountTypeDao;
import com.rex.accountbook.dao.repository.AccountTypeDaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
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

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public AccountTypeDao updateById(AccountTypeDao entity) throws Exception {
        AccountTypeDao dao = findById(entity.getId());
        BeanUtils.copyProperties(entity, dao, "id");
        return repository.save(dao);
    }

    public AccountTypeDao findById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("can not found id " + id));
    }

}
