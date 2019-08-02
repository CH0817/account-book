package com.rex.accountbook.dao.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// 此註解只會掃描 @Entity 的 Bean 和 裝配 Spring Data JPA 存儲庫，
// 其他常規 @Service @Component @Repository 註解的 Bean 不會加載到 Spring context
@DataJpaTest
// 載入測試 properties
// @TestPropertySource("classpath:db-info.properties")
// 不使用內嵌資料庫
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TradeDaoRepositoryTest {

    @Autowired
    private TradeDaoRepository repository;

    @Test
    public void save() {
        // do test
    }

}