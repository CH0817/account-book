package com.rex.accountbook.service.base;

import com.rex.accountbook.service.TradeService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TradeService.class})
public class BaseServiceTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

}
