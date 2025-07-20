package org.example;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogTest {

    @PostConstruct
    public void init() {
        log.info("Информационное сообщение");
    }
}
