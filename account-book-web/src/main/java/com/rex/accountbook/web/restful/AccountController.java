package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.model.AccountDao;
import com.rex.accountbook.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public AccountDao save(@RequestBody AccountDao input) {
        return service.save(input);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
