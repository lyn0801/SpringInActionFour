package com.lyn0801.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TrackCounterTest {
    @Autowired
    private CompactDisc cd;
    @Test
    public void play(){
        cd.playTrack(0);
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(4);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TrackCounter counter = (TrackCounter)context.getBean("trackCounter");
        System.out.println(counter.getPlayCount(0));
        System.out.println(counter.getPlayCount(1));
        System.out.println(counter.getPlayCount(2));
        System.out.println(counter.getPlayCount(3));
        System.out.println(counter.getPlayCount(4));
    }
}
