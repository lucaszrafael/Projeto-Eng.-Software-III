package br.com.fatec;

import java.util.HashMap;
import java.util.Map;

public class Receitas extends Comida{
	public Map<Comida, String> ingredientes = new HashMap<Comida, String>();
	public String modoPreparo;
	public String tempoPreparo;
	
	public Receitas(String nome, Map<Comida, String> ingredientes, String modoPreparo, String tempoPreparo) {
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.modoPreparo = modoPreparo;
		this.tempoPreparo = tempoPreparo;
	}
	
	@Override
	public void print() {
		System.out.println("--------~--------");
		System.out.println("Nome: " + nome);
		System.out.println("Ingredientes: ");
		for(Comida c:ingredientes.keySet()) {
			System.out.println("  " + ingredientes.get(c)+" de " + c.nome);
		}
		System.out.println("Modo de preparo: ");
		System.out.println(modoPreparo);
		System.out.println("Tempo:    " + tempoPreparo);
	}
}
