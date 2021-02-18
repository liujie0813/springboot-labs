package com.timberliu.springboot.mapstruct;

import com.sun.corba.se.impl.orbutil.concurrent.CondVar;
import com.timberliu.springboot.mapstruct.bo.ConsumerBO;
import com.timberliu.springboot.mapstruct.bo.UserBO;
import com.timberliu.springboot.mapstruct.convert.ConsumerConvert;
import com.timberliu.springboot.mapstruct.convert.UserConvert;
import com.timberliu.springboot.mapstruct.dataobject.ConsumerDO;
import com.timberliu.springboot.mapstruct.dataobject.UserDO;
import jdk.internal.dynalink.linker.ConversionComparator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created by Timber in 2020/7/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot07MapstructApplication.class)
public class UserDOTest {

    @Test
    public void testUserDO() {
        UserDO userDO = new UserDO();
        userDO.setId(1);
        userDO.setUsername("liu");
        userDO.setPassword("haha");
        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBO);
    }

    @Test
    public void testConsume() {
        ConsumerDO consumerDO = new ConsumerDO();
        consumerDO.setId(1);
        consumerDO.setUsername("liu");
        consumerDO.setPassword("haha");
        ConsumerBO consumerBO = ConsumerConvert.INSTANCE.convert(consumerDO);
        System.out.println(consumerBO);
    }

}
