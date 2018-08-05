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
    
    public void Mutar(String Populacao[]){
        
    String tempoInicio;
    String tempoFinal;
        
        for(int i = 0; i < Populacao.length; i++){
            
            for(int x = 0; x < Populacao[i].length();x++){                
                int randomNum = gerador.nextInt((1 - 0) + 1) + 0;               
                if(randomNum == 1){
                     
                     if(Populacao[i].charAt(x) == '1'){
                         tempoInicio = "";
                         tempoFinal = "";
                         
                         tempoInicio = Populacao[i].substring(0, x);
                         tempoFinal = Populacao[i].substring(x,Populacao[i].length());
                         
                         Populacao[i] = tempoInicio + "0" + tempoFinal;
                     }else{
                         tempoInicio = "";
                         tempoFinal = "";
                         
                         tempoInicio = Populacao[i].substring(0, x -1);
                         tempoFinal = Populacao[i].substring(x +1,Populacao[i].length());
                         
                         Populacao[i] = tempoInicio + "1" + tempoFinal;                        
                     }              
                }
            }          
        }
    }
       
}
