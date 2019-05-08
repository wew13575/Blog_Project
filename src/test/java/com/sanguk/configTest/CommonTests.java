package com.sanguk.configTest;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class CommonTests {

    @Autowired
    Path rootLocation;

    @Test
    public void commontests() {

        String sdd = "adawdwadawdwa.wadawdwa";
        String[] adr = sdd.split("\\.");

        log.info(adr[0]);
    }

    @Test
    public void stringTest() {
        String content = "<p>ewfwefewgew<img src=\"/upload/image/8a38023ee0f8484fa2bdb721f93a2eb9.png\" style=\"width: 222px;\"></p>";
        /*
         * Pattern p = Pattern.compile("\\#([0-9a-zA-Z가-힣]*)");
         */
        Pattern p = Pattern.compile("<img src=\"/upload/image/[0-9a-zA-Z]+.(jpg|gif|png|bmp)\"");
        Matcher m = p.matcher(content);
        String extractHashTag = null;

        while (m.find()) {
            log.info(m.group().replace("<img src=\"/upload/image/", "").replace("\"", ""));
        }
    }

    @Test
    public void injectTest() {
        log.info(rootLocation.toString());
    }
}