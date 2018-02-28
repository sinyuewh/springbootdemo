package com.exsun.girl;

import com.exsun.girl.Entity.Girl;
import com.exsun.girl.Service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: jin shouji
 * @CREATE: 2018/2/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void FindOne() {
        Girl g1 = girlService.FindOne(14);
        Assert.assertEquals(new Integer(55),g1.getAge());
    }
}
