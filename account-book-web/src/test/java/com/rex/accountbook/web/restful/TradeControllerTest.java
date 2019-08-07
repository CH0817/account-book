package com.rex.accountbook.web.restful;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.rex.accountbook.dao.model.AccountDao;
import com.rex.accountbook.dao.model.ItemDao;
import com.rex.accountbook.dao.model.TradeDao;
import com.rex.accountbook.dao.repository.TradeDaoRepository;
import com.rex.accountbook.web.base.BaseControllerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 測試資料
@Sql({"classpath:data/account_type.sql", "classpath:data/account.sql", "classpath:data/item.sql", "classpath:data/trade.sql"})
public class TradeControllerTest extends BaseControllerTest {

    @Autowired
    private TradeDaoRepository repository;

    @Test
    public void save() throws Exception {
        TradeDao entity = new TradeDao();
        entity.setNote("controller test");
        entity.setCost(new BigDecimal(100));
        entity.setTradeDate(LocalDate.now());
        AccountDao account = new AccountDao();
        account.setId(1L);
        entity.setAccount(account);
        ItemDao item = new ItemDao();
        item.setId(1L);
        entity.setItem(item);
        mvc.perform(post("/trade/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(object2Json(entity)))//
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void deleteById() throws Exception {
        mvc.perform(delete("/trade/delete/{id}", 1L))
           .andExpect(status().isOk());
        assertFalse(repository.findById(1L).isPresent());
    }

    private String object2Json(Object object) {
        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ParameterNamesModule())
              .registerModule(new Jdk8Module())
              .registerModule(new JavaTimeModule());
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
