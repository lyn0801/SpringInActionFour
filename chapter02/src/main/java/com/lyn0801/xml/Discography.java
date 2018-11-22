/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801.xml;

import com.lyn0801.CompactDisc;
import java.util.List;

/**
 *
 * @author lyn0801
 */
public class Discography implements CompactDisc{
    private String artist;
    private List<CompactDisc> cds;

    public Discography(String artist, List<CompactDisc> cds) {
        this.artist = artist;
        this.cds = cds;
    }

    @Override
    public void play() {
        for(CompactDisc cd : cds){
            cd.play();
        }
    }
    
}
