/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author marstor
 */
@Component
public class People {
    private Dessert dessert;

//    @Autowired
//    public People(Dessert dessert) {
//        this.dessert = dessert;
//    }
    
    @Autowired
//    @Qualifier("iceCream")
//    @Qualifier("cold")
    @Cold
    @Creamy
    public void setDessert(Dessert dessert){
        this.dessert = dessert;
    }

    public void eat() {
        System.out.println("People eat Dessert of " + dessert);
    }
}
