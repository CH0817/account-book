package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.model.AccountDao;
import com.rex.accountbook.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
