package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class Combina��o extends Comida{
	List<Comida> kombi = new ArrayList<Comida>();
	
	public Combina��o(String nome) {
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
