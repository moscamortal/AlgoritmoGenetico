package algoritmo.genetico;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leandro
 */
public class ManiLista {
    	public String listaToString(ArrayList<String> stockList) {
		
		String[] stockArr = new String[stockList.size()];
		stockArr = stockList.toArray(stockArr);
		String aa = "";

		for(String comLetras : stockArr) {
		 //   System.out.println(comLetras);
		    aa = aa + comLetras;
		    
		}
		return(aa);
	};
		
	public String removerLetras(String s) {

		String aa = s.replaceAll("[^0-9]", "");
		//System.out.println(aa);
		
		return(aa);
	}
	
            public String inverterString(String aa) {
		
		String invertida = aa.replaceAll("[1]", "2");
		invertida = invertida.replaceAll("[0]", "1");
		invertida = invertida.replaceAll("[2]", "0");
		
		//System.out.println(invertida);
		return(invertida);
		//gerarVetor(invertida);
	};
}

