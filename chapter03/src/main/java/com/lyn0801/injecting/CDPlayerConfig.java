package com.lyn0801.injecting;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lyn0801
 */
@Configuration
public class CDPlayerConfig {    
    
    @Bean
    public CompactDisc sgtPeppers() {
//        return new SgtPeppers();
        return new BlankDisc(
                "***Sgt. Pepper's Lonely Hearts Club Band***",
                "The Beatles");
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
