package com.lyn0801.mixing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.lyn0801.CompactDisc;

/**
 *
 * @author lyn0801
 */
public class SgtPeppers implements CompactDisc {
    private String title = "%==Sgt. Pepper's Lonely Hearts Club Band==%";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
    
}
