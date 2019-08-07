package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.model.TradeDao;
import com.rex.accountbook.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping
    public TradeDao updateById(@RequestBody TradeDao input) throws Exception {
        service.updateById(input);
        return service.updateById(input);
    }

    @GetMapping("/{id}")
    public TradeDao findById(@PathVariable Long id) throws Exception {
        return service.findById(id);
    }

}
