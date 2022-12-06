package com.nightsky.cryptonate.spring.boot.example.db;

import com.github.javafaker.Faker;
import com.nightsky.cryptonate.spring.boot.example.model.SampleEntity;
import com.nightsky.cryptonate.spring.boot.example.service.SampleEntityService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 *
 * @author Chris
 */
@Component
@DependsOn({"cryptoEventListener"})
public class Seed implements InitializingBean {

    private final Faker faker;

    @Autowired
    private SampleEntityService service;

    public Seed() {
        faker = new Faker();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (int i = 0; i < 5; i++) {
            SampleEntity se = new SampleEntity();
            se.setEmailAddress(faker.internet().emailAddress());
            service.create(se);
        }
    }

}
