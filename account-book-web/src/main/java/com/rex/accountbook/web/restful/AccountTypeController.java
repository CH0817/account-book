package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.model.AccountTypeDao;
import com.rex.accountbook.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/types")
public class AccountTypeController {

    private AccountTypeService service;

    @Autowired
    public AccountTypeController(AccountTypeService service) {
        this.service = service;
    }

    @PostMapping
    public AccountTypeDao save(@RequestBody AccountTypeDao input) {
        return service.save(input);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

}
