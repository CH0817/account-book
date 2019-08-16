package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.model.AccountDao;
import com.rex.accountbook.dao.model.ItemDao;
import com.rex.accountbook.dao.model.TradeDao;
import com.rex.accountbook.dao.repository.TradeDaoRepository;
import com.rex.accountbook.web.base.BaseControllerTest;
import com.rex.accountbook.web.util.JsonUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 測試資料
@Sql({"classpath:data/account_type.sql", "classpath:data/account.sql", "classpath:data/item.sql", "classpath:data/trade.sql"})
@WithMockUser
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
        mvc.perform(post("/trades")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtils.object2Json(entity)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void deleteById() throws Exception {
        mvc.perform(delete("/trades/{id}", 1L))
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

        mvc.perform(put("/trades").contentType(MediaType.APPLICATION_JSON_UTF8).content(JsonUtils.object2Json(entity)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.note").value("controller test"))
                .andExpect(jsonPath("$.cost").value("999.00"))
                .andExpect(jsonPath("$.tradeDate").value(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .andExpect(jsonPath("$.account.id").value(3L))
                .andExpect(jsonPath("$.item.id").value(2L));
    }

    @Test
    public void findById() throws Exception {
        mvc.perform(get("/trades/{id}", 2L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.note").value("test"))
                .andExpect(jsonPath("$.cost").value(new BigDecimal(200).setScale(2, BigDecimal.ROUND_HALF_UP)))
                .andExpect(jsonPath("$.tradeDate").value(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .andExpect(jsonPath("$.account.id").value(2L))
                .andExpect(jsonPath("$.item.id").value(2L));
    }

}
