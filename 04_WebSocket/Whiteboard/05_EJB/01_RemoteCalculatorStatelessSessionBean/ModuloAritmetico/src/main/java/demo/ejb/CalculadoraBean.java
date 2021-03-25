/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author fsern
 */
@Stateless
public class CalculadoraBean implements CalculadoraRemote {

    public int sumar (int s1, int s2){
        System.out.println("ModuloAritmetico.SumadorBean.sumar>>  Me han pedido sumar "+s1+" + "+s2);
        return s1+s2;
    }
}
