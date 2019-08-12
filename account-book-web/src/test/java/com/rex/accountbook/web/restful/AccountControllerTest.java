package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.model.AccountDao;
import com.rex.accountbook.dao.model.AccountTypeDao;
import com.rex.accountbook.web.base.BaseControllerTest;
import com.rex.accountbook.web.util.JsonUtils;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 測試資料
@Sql({"classpath:data/account_type.sql", "classpath:data/account.sql"})
public class AccountControllerTest extends BaseControllerTest {

    private final String DOMAIN = "/accounts";

    @Test
    public void save() throws Exception {
        AccountDao entity = new AccountDao();
        AccountTypeDao type = new AccountTypeDao();
        type.setId(1L);
        entity.setType(type);
        entity.setName("地下錢莊");
        entity.setInitAmount(new BigDecimal(100));

        mvc.perform(getPostJsonRequest("/accounts", entity))
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

    private MockHttpServletRequestBuilder getPostJsonRequest(String url, Object entity) {
        return post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtils.object2Json(entity));
    }

}
