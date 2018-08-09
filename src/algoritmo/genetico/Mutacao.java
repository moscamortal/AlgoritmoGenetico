/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.genetico;

import java.util.Random;

/**
 *
 * @author leandro
 */
public class Mutacao {
Random gerador = new Random();
    
    public String[] Mutar(String Populacao[]){
        
        for(int i = 0; i < Populacao.length; i++){
         String IndividuoTemp = null;
         
            for(int x = 0; x < Populacao[i].length();x++){                
                int randomNum = gerador.nextInt(100);     
                
                if(randomNum == 1){
                    ManiLista manilista = new ManiLista();
                        if(IndividuoTemp == null){
                           IndividuoTemp =  manilista.inverterString(String.valueOf(Populacao[i].charAt(x)));
                           
                        }else{
                            IndividuoTemp = IndividuoTemp + manilista.inverterString(String.valueOf(Populacao[i].charAt(x)));
                        }
                    
                }else if(IndividuoTemp == null){
                    IndividuoTemp = String.valueOf(Populacao[i].charAt(x));
                }else{
                    IndividuoTemp = IndividuoTemp + String.valueOf(Populacao[i].charAt(x));
                }
            }
            Populacao[i] = IndividuoTemp;
            System.out.println(Populacao[i]);        
        }
       return Populacao;
       
    }      
}
