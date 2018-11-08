/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801.xml;

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
@ContextConfiguration(locations = {"classpath:applicationContext_xml.xml"})
public class CDPlayerTest {
    
//    @Test
//    public void cdShouldNotBeNull(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_xml.xml");
//        CompactDisc cd = (CompactDisc)context.getBean("compactDisc");
//        assertNotNull(cd);
//    }
    
    @Test
    public void play(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_xml.xml");
        CDPlayer player = (CDPlayer)context.getBean("cdPlayer");
        player.play();
    }
}
