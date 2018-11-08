/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801.injecting;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author lyn0801
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=CDPlayerConfig.class)
@ContextConfiguration(classes=ExpressiveConfig.class)
public class CDPlayerTest {
    @Autowired
//    @Qualifier("sgtPeppers")
    private CompactDisc cd;
    
    @Autowired
    private CDPlayer player;
    
    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }
    
    @Test
    public void play(){
        player.play();
    }
}
