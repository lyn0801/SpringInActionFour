/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyn0801;

import org.springframework.stereotype.Component;

/**
 *
 * @author lyn0801
 */
@Component
@Cold
@Fruity
public class Popsicle implements Dessert{

    @Override
    public String toString() {
        return "Popsicle";
    }
    
}
