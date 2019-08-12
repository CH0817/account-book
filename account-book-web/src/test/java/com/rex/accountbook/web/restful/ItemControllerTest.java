package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.define.TradeTypeEnum;
import com.rex.accountbook.dao.model.ItemDao;
import com.rex.accountbook.web.base.BaseControllerTest;
import com.rex.accountbook.web.util.JsonUtils;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 測試資料
@Sql({"classpath:data/item.sql"})
public class ItemControllerTest extends BaseControllerTest {

    private final String DOMAIN = "/items";

    @Test
    public void save() throws Exception {
        ItemDao entity = new ItemDao();
        entity.setTradeType(TradeTypeEnum.COST.getType());
        entity.setName("遊戲");

        mvc.perform(getPostJsonRequest(DOMAIN, entity))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    public void deleteById() throws Exception {
        mvc.perform(delete(DOMAIN + "/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mvc.perform(get(DOMAIN + "/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.tradeType").value(TradeTypeEnum.INCOME.getType()))
                .andExpect(jsonPath("$.name").value("薪資"));
    }

    @Test
    public void updateById() throws Exception {
        ItemDao entity = new ItemDao();
        entity.setId(1L);
        entity.setTradeType(TradeTypeEnum.COST.getType());
        entity.setName("賭博");

        mvc.perform(put(DOMAIN).contentType(MediaType.APPLICATION_JSON_UTF8).content(JsonUtils.object2Json(entity)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.tradeType").value(TradeTypeEnum.COST.getType()))
                .andExpect(jsonPath("$.name").value("賭博"));
    }

    private MockHttpServletRequestBuilder getPostJsonRequest(String url, Object entity) {
        return post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtils.object2Json(entity));
    }

}
