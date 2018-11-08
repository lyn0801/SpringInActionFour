/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801.xml;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lyn0801
 */
public class TrackCounter {

    private Map<Integer, Integer> trackCounts
            = new HashMap<Integer, Integer>();

    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber)
                ? trackCounts.get(trackNumber) : 0;
    }
}
