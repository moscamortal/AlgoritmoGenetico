
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
       
    System.out.println();
    
    //----- Gerar populacao
    
    String PopulacaoAleatoriaInicial[];
    PopulacaoAleatoriaInicial = pop.GerarPopulacaoAleatoria(populacao.length());
   
    //----- Inicio do Fitness
    
   Fitness fitness = new Fitness();
    
   IndiceMelhor = fitness.SelecionarMaisApto(fitness.CompararFitness(Fitness,PopulacaoAleatoriaInicial, 10, populacao.length()));
   System.out.println(PopulacaoAleatoriaInicial[IndiceMelhor]);
   
   //----- Inicio da reprodução 
   
   Reproducao repdorucao = new Reproducao();
   
  /*String a = "3";
  String b = "0";
   
   for(int i = 0; i < 50; i++){
       String resultado = repdorucao.Cruzador(a,b);  
       System.out.println(resultado);
   }
   */
   String NovaPopulacao[] = new String[PopulacaoAleatoriaInicial.length]; 
   NovaPopulacao = repdorucao.Reproduzir(PopulacaoAleatoriaInicial[IndiceMelhor], PopulacaoAleatoriaInicial, IndiceMelhor );
    //----- Inicio da Mutação
    
    Mutacao mutacao = new Mutacao();
    mutacao.Mutar(NovaPopulacao);
    
  }
}
    

