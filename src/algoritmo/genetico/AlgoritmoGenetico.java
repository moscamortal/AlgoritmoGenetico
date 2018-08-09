
/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.genetico;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author leandro
 */
public class AlgoritmoGenetico {

    /**
     * @param args the command line arguments
     */      
        // TODO code application logic here
        static ArrayList<String> leitura = new ArrayList();
	static String comLetras;
	static String semNumeros;
	static int IndiceMelhor;
        static int FitnessMelhor = -1;
        static String[] PopulacaoPosInicializada;
        
//========================
	public static void gerarVetor(String invertida) {
		int n = invertida.length();
		int x = 0;
		int i;
		int temp;
		
		int v[] = new int[n];		
		
		for(i=0;i<n;i++) {
			x = i + 1;
		temp = Integer.parseInt(invertida.substring(i,x));
		x++;
		v[i] = temp;
		}
	}
	
//========================

  public static void main(String[] args) {
	  
	    Scanner ler = new Scanner("a.txt");
	    String nome = ler.nextLine();
	    String ListaString;
	    String populacao;
            String Fitness;

    try {
    	int i = 0;
      FileReader arq = new FileReader(nome);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine();
      leitura.add(linha);
      
      while (linha != null) {
 
        linha = lerArq.readLine(); 
        leitura.add(linha);
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    //----- Manipula o Text Lido 
    ManiLista listas = new ManiLista();
    InicializaPopulacao pop = new InicializaPopulacao(); // Inicializa a populacao
      
    ListaString = listas.listaToString(leitura); //Converte para String a Lista de numeros lidos do arquiv ode texto
    populacao = listas.removerLetras(ListaString); //Retirar tudo q nao for numero do arquivo de texto lido
    Fitness = listas.inverterString(populacao); //Inverte os 0 por 1, para temos a Fitness
    
   System.out.println(populacao);
   System.out.println(Fitness);
       
   // System.out.println();
    int i = 0;
       while ((FitnessMelhor != 0) || (i < 1000)){ // Validação por 10000 populações
        i++;
            while((FitnessMelhor != 0)){
                
                 if(FitnessMelhor == -1){

                    //----- Gerar populacao
                   String PopulacaoAleatoriaInicial[];
                   PopulacaoAleatoriaInicial = pop.GerarPopulacaoAleatoria(populacao.length());

                    //----- Inicio do Fitness

                   Fitness fitness = new Fitness();

                   IndiceMelhor = fitness.SelecionarMaisApto(fitness.CompararFitness(Fitness,PopulacaoAleatoriaInicial, PopulacaoAleatoriaInicial.length, populacao.length()));
                  //String MaisAptoAtual = PopulacaoAleatoriaInicial[IndiceMelhor];
                  // System.out.println(PopulacaoAleatoriaInicial[IndiceMelhor]);

                   //----- Inicio da reprodução 

                   Reproducao repdorucao = new Reproducao();

                   PopulacaoPosInicializada = repdorucao.Reproduzir(PopulacaoAleatoriaInicial[IndiceMelhor], PopulacaoAleatoriaInicial, IndiceMelhor );

                   //----- Inicio Mutacao
                   
                   Mutacao mutacao = new Mutacao();
                   mutacao.Mutar(PopulacaoPosInicializada);
                    
                   FitnessMelhor = fitness.FitnessMelhor;
                } 
                 else if(FitnessMelhor != 0){

                    //----- Inicio do Fitness

                    Fitness fitness = new Fitness();

                    IndiceMelhor = fitness.SelecionarMaisApto(fitness.CompararFitness(Fitness,PopulacaoPosInicializada, PopulacaoPosInicializada.length, populacao.length())); 
                    //System.out.println(PopulacaoPosInicializada[IndiceMelhor]);

                    //---- Inicio da Reprodução
                    Reproducao repdorucao = new Reproducao();
                    PopulacaoPosInicializada = repdorucao.Reproduzir(PopulacaoPosInicializada[IndiceMelhor], PopulacaoPosInicializada, IndiceMelhor );
                    
                    //----- Inicio da Mutação
                    
                    Mutacao mutacao = new Mutacao();
                   mutacao.Mutar(PopulacaoPosInicializada);
                    
                    
                    //----- Validação da Fitness
                    FitnessMelhor = fitness.FitnessMelhor;
                }              
            }          
       } 
               
       if(FitnessMelhor == 0){
                 System.out.println("VocÊ chjegou a resultado ideal");
                 System.out.println(PopulacaoPosInicializada[IndiceMelhor]);
            }
            else{
                System.out.println("Não existe solução possivel");
            }
    }
}
    /*
    
    //----- Gerar populacao
    
    String PopulacaoAleatoriaInicial[];
    PopulacaoAleatoriaInicial = pop.GerarPopulacaoAleatoria(populacao.length());
   
    //----- Inicio do Fitness
    
   Fitness fitness = new Fitness();
    
   IndiceMelhor = fitness.SelecionarMaisApto(fitness.CompararFitness(Fitness,PopulacaoAleatoriaInicial, 10, populacao.length()));
   System.out.println(PopulacaoAleatoriaInicial[IndiceMelhor]);
   
   //----- Inicio da reprodução 
   
   Reproducao repdorucao = new Reproducao();
   
  
   String NovaPopulacao[] = new String[PopulacaoAleatoriaInicial.length]; 
   NovaPopulacao = repdorucao.Reproduzir(PopulacaoAleatoriaInicial[IndiceMelhor], PopulacaoAleatoriaInicial, IndiceMelhor );
   
    //----- Inicio da Mutação
    
    Mutacao mutacao = new Mutacao();
    mutacao.Mutar(NovaPopulacao);
    
    */
    

    

