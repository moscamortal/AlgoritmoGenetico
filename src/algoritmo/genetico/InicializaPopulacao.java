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
public class InicializaPopulacao {
    
     public String[] GerarPopulacaoAleatoria(int QntNumeros) {
		 
		 int TamanhoVetor = QntNumeros;
		 String populacao[] = new String[TamanhoVetor];
                 String vetor[] = new String[TamanhoVetor];
                                  		 
                 //for(int i = 0; i < ){
                     
                      for (int a = 0; a < QntNumeros; a++) {	
			 
			 for (int i = 0; i < TamanhoVetor; i++) {
                             
                             if(populacao[a] == null){
                                 
                                 Random gerador = new Random();
                                 populacao[a] = Integer.toString(gerador.nextInt(2)); 
                             }	
                             else{
                                Random gerador = new Random();
                                populacao[a] = populacao[a] += Integer.toString(gerador.nextInt(2)); 
                             }                          
                         }
                     }
               //  }
                 
                 return populacao;
	 }
}
