package com.rex.accountbook.service;

import com.rex.accountbook.dao.model.ItemDao;
import com.rex.accountbook.dao.repository.ItemDaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ItemService {

    private ItemDaoRepository repository;

    @Autowired
    public ItemService(ItemDaoRepository repository) {
        this.repository = repository;
    }

    public ItemDao save(ItemDao entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ItemDao findById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("can not found id " + id));
    }

    public ItemDao updateById(ItemDao entity) throws Exception {
        ItemDao dao = findById(entity.getId());
        BeanUtils.copyProperties(entity, dao, "id");
        return repository.save(dao);
    }

}
