package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.model.TradeDao;
import com.rex.accountbook.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
public class TradeController {

    private TradeService service;

    @Autowired
    public TradeController(TradeService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public TradeDao save(@RequestBody TradeDao input) throws Exception {
        return service.insert(input);
    }

}
