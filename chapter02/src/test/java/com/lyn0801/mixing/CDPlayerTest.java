/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801.mixing;

import com.lyn0801.autowired.*;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author lyn0801
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=CDPlayerConfig.class)
@ContextConfiguration(locations = {"classpath:applicationContext_mixing.xml"})
public class CDPlayerTest {
//    @Autowired
//    private CompactDisc cd;
//    
//    @Autowired
//    private CDPlayer player;
//    
//    @Test
//    public void cdShouldNotBeNull(){
//        assertNotNull(cd);
//    }
    
    @Test
    public void play(){
//        player.play();
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_mixing.xml");
        com.lyn0801.xml.CDPlayer player = (com.lyn0801.xml.CDPlayer)context.getBean("cdPlayer");
        player.play();
    }
}