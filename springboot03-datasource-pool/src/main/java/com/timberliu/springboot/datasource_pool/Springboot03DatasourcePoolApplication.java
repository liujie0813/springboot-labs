package com.timberliu.springboot.datasource_pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication
public class Springboot03DatasourcePoolApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(Springboot03DatasourcePoolApplication.class);

    @Resource(name = "ordersDataSource")
    private DataSource ordersDataSource;

    @Resource(name = "usersDataSource")
    private DataSource usersDataSource;

//    @Autowired
//    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(Springboot03DatasourcePoolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        logger.info("[run][获得连接:{}]", dataSource.getClass());

        logger.info("[run][获得连接:{}]", ordersDataSource);

        logger.info("[run][获得连接:{}]", usersDataSource);
    }

}
