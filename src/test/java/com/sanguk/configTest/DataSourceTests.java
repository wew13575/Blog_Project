package com.sanguk.configTest;

import java.sql.Connection;
import static org.junit.Assert.fail;
import javax.sql.DataSource;

import com.sanguk.config.RootConfig;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests{

    @Setter(onMethod_ = { @Autowired })
    private DataSource dataSource;

    @Setter(onMethod_ = { @Autowired })
    private SqlSessionFactory sessionFactory;

    

    @Test
    public void testConnection(){
        
        System.out.println("Afafeqwfwefeqwfew");
        try(Connection con = dataSource.getConnection()){
            System.out.println(con);
        }catch (Exception e) {
            fail(e.getMessage());
        }
    } 
    @Test
    public void testMyBatis(){
        try(SqlSession session = sessionFactory.openSession(); Connection con = session.getConnection();){
            log.info(session);
            System.out.println("dddddddd");
        } catch (Exception e){
            System.out.println("dddddddd");
        }
    }

}