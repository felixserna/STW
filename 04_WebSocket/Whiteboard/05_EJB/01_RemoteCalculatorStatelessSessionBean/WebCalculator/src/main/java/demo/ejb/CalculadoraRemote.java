/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ejb;

import javax.ejb.Remote;

/**
 *
 * @author Félix
 */
@Remote
public interface CalculadoraRemote {

    int sumar(int s1, int s2);
    
}
