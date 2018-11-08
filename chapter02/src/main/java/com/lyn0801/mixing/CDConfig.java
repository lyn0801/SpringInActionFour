/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801.mixing;

import com.lyn0801.autowired.CompactDisc;
import com.lyn0801.autowired.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lyn0801
 */
@Configuration
public class CDConfig {
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    } 
}
