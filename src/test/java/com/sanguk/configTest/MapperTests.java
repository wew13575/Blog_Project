package com.sanguk.configTest;

import com.sanguk.mapper.UserMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Test
    public void testMapper() {
        //System.out.println("dddddddd");
        log.info("wefwefwefew");
        userMapper.selectlist();
    }

    @Test
    public void testTransaction() {
        TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
             userMapper.selectlist();
             log.info("#########################commit#####################");
        } catch (Exception e) {
            transactionManager.rollback(txStatus);
            log.info("############################rollback###########################");
            throw e;
        }
        transactionManager.commit(txStatus);
    }
}