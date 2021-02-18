package com.timberliu.springboot.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timberliu.springboot.springmvc.message.converter.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * created by Timber in 2020/7/7
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest
public class JacksonTest {

    @Test
    public void test() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person();
        person.setName("jack");
        person.setAge(20);

        String jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        Person person1 = objectMapper.readValue(jsonStr, Person.class);
    }

    @Test
    public void test1() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setUsername("liu");
        user.setPassword("123");
        user.setBirthday(LocalDateTime.now());
        user.setPrice(0.4983);
        user.setAddress("China");

        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(value);
    }

}

