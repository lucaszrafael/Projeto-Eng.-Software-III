package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class Combinação extends Comida{
	List<Comida> kombi = new ArrayList<Comida>();
	
	public Combinação(String nome) {
		this.nome = nome;
	}
	
	public void add(Comida c) {
		kombi.add(c);
	}
	
	public void print() {
		System.out.println("--------~--------");
		System.out.println("Nome:  " + nome);
		System.out.println("Componentes: ");
		for(Comida c:kombi) {
			System.out.println(" "+c.nome);
		}
	}
}
