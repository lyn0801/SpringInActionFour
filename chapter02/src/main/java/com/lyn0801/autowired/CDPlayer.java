package com.lyn0801.autowired;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.lyn0801.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lyn0801
 */
@Component
public class CDPlayer {
    private CompactDisc cd;

//    @Autowired
//    public CDPlayer(CompactDisc cd) {
//        this.cd = cd;
//    }
    
//    @Autowired
//    public void setCompactDisc(CompactDisc cd){
//        this.cd = cd;
//    }
    
    @Autowired
    public void insertDisc(CompactDisc cd){
        this.cd = cd;
    }
    
    public void play(){
        cd.play();
    }
}
