package com.rex.accountbook.web.restful;

import com.rex.accountbook.dao.model.AccountTypeDao;
import com.rex.accountbook.web.base.BaseControllerTest;
import com.rex.accountbook.web.util.JsonUtils;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 測試資料
@Sql({"classpath:data/account_type.sql"})
public class AccountTypeControllerTest extends BaseControllerTest {

    @Test
    public void save() throws Exception {
        AccountTypeDao entity = new AccountTypeDao();
        entity.setName("測試五個字");
        mvc.perform(post("/account/types")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtils.object2Json(entity)))
                .andExpect(status().isOk())//
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    public void deleteById() throws Exception {
        mvc.perform(delete("/account/types/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateById() throws Exception {
        AccountTypeDao entity = new AccountTypeDao();
        entity.setId(1L);
        entity.setName("TMD");

        mvc.perform(put("/account/types")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtils.object2Json(entity)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("TMD"));
    }

}
