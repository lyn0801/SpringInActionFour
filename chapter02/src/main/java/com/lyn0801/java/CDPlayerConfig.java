package com.lyn0801.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.lyn0801.autowired.CompactDisc;
import com.lyn0801.autowired.SgtPeppers;
import com.lyn0801.autowired.CDPlayer;
import com.lyn0801.autowired.SgtPeppersClone;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lyn0801
 */
@Configuration
public class CDPlayerConfig {
    
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
    
    @Bean
    public CompactDisc sgtPeppersClone(){
        return new SgtPeppersClone();
    }
    
    @Bean 
    public CDPlayer cdPlayer(@Qualifier("sgtPeppersClone") CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
