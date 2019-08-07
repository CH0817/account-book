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
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
                .content(object2Json(entity)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void deleteById() throws Exception {
        mvc.perform(delete("/trade/delete/{id}", 1L))
                .andExpect(status().isOk());
        assertFalse(repository.findById(1L).isPresent());
    }

    @Test
    public void updateById() throws Exception {
        TradeDao entity = new TradeDao();
        entity.setId(2L);
        entity.setNote("controller test");
        entity.setCost(new BigDecimal(999));
        entity.setTradeDate(LocalDate.now().plusDays(3L));
        AccountDao account = new AccountDao();
        account.setId(3L);
        entity.setAccount(account);
        ItemDao item = new ItemDao();
        item.setId(2L);
        entity.setItem(item);

        mvc.perform(put("/trade").contentType(MediaType.APPLICATION_JSON_UTF8).content(object2Json(entity)))
                .andExpect(status().isOk());

        Optional<TradeDao> daoOptional = repository.findById(2L);
        assertTrue(daoOptional.isPresent());
        daoOptional.ifPresent(dao -> {
            assertEquals("note not equals", "controller test", dao.getNote());
            assertEquals("cost not equals", new BigDecimal(999).setScale(2, BigDecimal.ROUND_HALF_DOWN), dao.getCost());
            assertEquals("trade date not equals", LocalDate.now().plusDays(3), dao.getTradeDate());
            assertEquals("account not equals", 3L, dao.getAccount().getId().longValue());
            assertEquals("item not equals", 2L, dao.getItem().getId().longValue());
        });
    }

    @Test
    public void findById() throws Exception {
        mvc.perform(get("/trade/{id}", 2L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.note").value("test"))
                .andExpect(jsonPath("$.cost").value(new BigDecimal(200).setScale(2, BigDecimal.ROUND_HALF_UP)))
                .andExpect(jsonPath("$.tradeDate").value(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .andExpect(jsonPath("$.account.id").value(2L))
                .andExpect(jsonPath("$.item.id").value(2L));
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
