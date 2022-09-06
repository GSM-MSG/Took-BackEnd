package com.example.took_backend.global.security.auth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MyUserDetailServiceTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testDi() {
        MyUserDetailService bean = applicationContext.getBean(MyUserDetailService.class);
        assertThat(bean).isNotNull();
    }

}