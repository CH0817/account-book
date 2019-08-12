package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.model.ItemDao;
import com.rex.accountbook.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public ItemDao save(@RequestBody ItemDao input) {
        return service.save(input);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public ItemDao findById(@PathVariable Long id) throws Exception {
        return service.findById(id);
    }

    @PutMapping
    public ItemDao updateById(@RequestBody ItemDao input) throws Exception {
        return service.updateById(input);
    }

}
