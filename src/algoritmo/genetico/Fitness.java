package algoritmo.genetico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leandro
 */
public class Fitness {
    public static int FitnessMelhor;
    
    public int[] CompararFitness(String FitnessAtual, String Populacao[], int TamanhoPopulacao, int TamanhoIndividuo){        
        
     int[] VetorPontuacao = new int[TamanhoPopulacao];
      
        for(int x = 0; x < TamanhoPopulacao; x++ ){
            
            for(int i = 0; i < TamanhoIndividuo; i++){
                
                if(Populacao[x].charAt(i) != FitnessAtual.charAt(i)){
                    VetorPontuacao[x] = VetorPontuacao[x] + 1;                    
                }
            }
          //System.out.println(VetorPontuacao[x]);
         }             
        return VetorPontuacao; 
    }
    
//---------------------------------
    public int SelecionarMaisApto(int VetorAptdao[]){
        
        int IndiceMelhor = 0;
        int Melhor = VetorAptdao[0];        
        for(int i = 0; i < VetorAptdao.length; i++){
            
            if(Melhor > VetorAptdao[i]){
                Melhor = VetorAptdao[i];
                IndiceMelhor = i;
            }         
        }
     //   System.out.println(Melhor); 
      //  System.out.println(IndiceMelhor);
        this.FitnessMelhor = Melhor;
        return IndiceMelhor;
    }
}
