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
public class Reproducao {
    
    public String Cruzador(String Melhor, String Populacao){
         
       // Melhor = "00000000000000000000";
        //Populacao = "11111111111111111111";
       Random gerador = new Random();
       int Tamanho = Populacao.length();
       String NovoIndividuo;   
           
       int separador = gerador.nextInt(Tamanho);
       
       NovoIndividuo = Melhor.substring(0,separador);
       NovoIndividuo = NovoIndividuo + Populacao.substring(separador,Tamanho);
       
    return NovoIndividuo;
    }
    
    public String[] Reproduzir(String Melhor, String Populacao[], int IndiceMelhor){
     
        String NovaPopulacao[] = new String[Populacao.length]; 
       
        NovaPopulacao[0] = Melhor;
      //  System.out.println(Populacao[0]);
        
            for(int i = 1; i < Populacao.length; i++){
               NovaPopulacao[i] = Cruzador(Melhor, Populacao[i]);  
              // System.out.println(Populacao[i]);
            }
        
          // System.out.println();
    return NovaPopulacao;
    
    }
}
