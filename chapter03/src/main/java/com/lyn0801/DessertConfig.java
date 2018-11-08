/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * @author lyn0801
 */
@Configuration
@ComponentScan
public class DessertConfig {
    @Bean
    public Dessert cake(){
        return new Cake();
    }
    
    @Bean
    public Dessert cookies(){
        return new Cookies();
    }
    
    @Bean
//    @Primary
//    @Qualifier("cold")
    public Dessert iceCream(){
        return new IceCream();
    }
}
