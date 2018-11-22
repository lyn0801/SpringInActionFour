/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801.injecting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author marstor
 */
@Configuration
//@PropertySource("classpath:/com/lyn0801/app.properties")
public class ExpressiveConfig {

    @Autowired
    Environment env;

//    @Bean
//    public BlankDisc disc() {
//        return new BlankDisc(
//                env.getProperty("disc.title", "Rattle and Hum"),
//                env.getProperty("disc.artist", "U2"));
//    }

    @Bean
    public BlankDisc disc(@Value("${disc.title}") String title, @Value("${disc.artist}") String artist) {
        return new BlankDisc(title, artist);
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        ClassPathResource classPathResource = new ClassPathResource("com/lyn0801/app.properties");
        propertySourcesPlaceholderConfigurer.setLocations(classPathResource);
        propertySourcesPlaceholderConfigurer.setLocalOverride(true);
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
