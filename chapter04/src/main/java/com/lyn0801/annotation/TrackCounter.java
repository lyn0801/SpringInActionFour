/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801.annotation;

import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author lyn0801
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts
            = new HashMap<Integer, Integer>();

    @Pointcut(
            "execution(* com.lyn0801.annotation.CompactDisc.playTrack(int)) "
            + "&& args(trackNumber)")
    public void trackPlayed(int trackNumber) {
    }

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        System.out.println("Track"+trackNumber);
        int currentCount = getPlayCount(trackNumber);
        System.out.println("currentCount"+(currentCount+1));
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber)
                ? trackCounts.get(trackNumber) : 0;
    }
}
