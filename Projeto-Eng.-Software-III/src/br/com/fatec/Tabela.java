package br.com.fatec;

import java.util.HashMap;
import java.util.Map;

public class Tabela {
	Map<String, String> tabela = new HashMap<String, String>();
	
	public Tabela() {
		
	}
	
	public void add(String categoria, String valor) {
		tabela.put(categoria, valor);
	}
	
	public void printAll() {
		for(String s: tabela.keySet()) {
			System.out.println(s+":  "+tabela.get(s));
		}
	}
}
