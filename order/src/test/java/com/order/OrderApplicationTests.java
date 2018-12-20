package com.order;

import com.order.util.DateGenerate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

    @Test
    public void contextLoads() {
//        Timestamp stringDate = (Timestamp) DateGenerate.getStringDate();
        Timestamp stringDate = Timestamp.valueOf(DateGenerate.getStringDate());
        System.out.println("创建时间:" + stringDate);
    }

}

