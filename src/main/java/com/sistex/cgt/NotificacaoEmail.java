/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.util.Tipo;
import static com.sistex.util.Tipo.EMAIL;

/**
 *
 * @author jean
 */
public class NotificacaoEmail extends NotificacaoChain{
    
    public NotificacaoEmail() {
        super(EMAIL);
    }
    
}
