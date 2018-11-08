/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801.annotation;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author lyn0801
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TrackCounterConfig.class)
public class TrackCounterTest {

    @Autowired
    private CompactDisc cd;
    @Autowired
    private TrackCounter counter;

    @Test
    public void testTrackCounter() {
        cd.playTrack(0);
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(4);
        System.out.println(counter.getPlayCount(0));
        System.out.println(counter.getPlayCount(1));
        System.out.println(counter.getPlayCount(2));
        System.out.println(counter.getPlayCount(3));
        System.out.println(counter.getPlayCount(4));
//        assertEquals(0, counter.getPlayCount(0));
//        assertEquals(1, counter.getPlayCount(1));
//        assertEquals(2, counter.getPlayCount(2));
//        assertEquals(3, counter.getPlayCount(3));
//        assertEquals(4, counter.getPlayCount(4));
    }
}
