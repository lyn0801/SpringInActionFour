package com.lyn0801.xml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lyn0801.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lyn0801
 */
public class CDPlayer {
    private CompactDisc compactDisc;

//    @Autowired
//    public CDPlayer(CompactDisc cd) {
//        this.cd = cd;
//    }
    
    @Autowired
    public void setCompactDisc(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }
    
//    @Autowired
//    public void insertDisc(CompactDisc cd){
//        this.cd = cd;
//    }
    
    public void play(){
        compactDisc.play();
    }
}
