/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.EmailObj;

/**
 *
 * @author jean
 */
public class FabricaEmail extends Fabrica{
    
    public EmailObj criaEmail(){
        return new EmailObj();
    }
}
