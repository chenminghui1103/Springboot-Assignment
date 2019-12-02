package com.ibm.fsd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkSpringBootApplication {

    private static Logger log = LoggerFactory.getLogger(HomeworkSpringBootApplication.class);

    public static void main(String[] args) {
        log.debug("--- begin....");
        SpringApplication.run(HomeworkSpringBootApplication.class, args);
        log.debug("--- has been startup...");
    }

}
