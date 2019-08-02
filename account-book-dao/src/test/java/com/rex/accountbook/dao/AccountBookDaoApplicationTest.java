package com.rex.accountbook.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Account Book DAO Spring application runner
// 不添加此 class 無法執行 @DataJpaTest 測試
@SpringBootApplication
public class AccountBookDaoApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(AccountBookDaoApplicationTest.class, args);
    }

}
