package br.com.fatec;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Combina��o c = new Combina��o("Caf� da Tarde");
		
		Alimento queijo = new Alimento("Queijo", "derivados", "Grupo 1");
		Alimento feij�o = new Alimento("Feij�o", "gr�os", "Grupo 2");
		Alimento carne = new Alimento("Carne", "prote�na", "Grupo 3");
		Alimento frango = new Alimento("Frango", "prote�na", "Grupo 3");
		
		Map<Comida, String> m = new HashMap<Comida, String>();
		
		m.put(frango, "200 gramas");
		m.put(queijo, "2 fatias");
		
		Receitas pizza = new Receitas("Pizza", m, "Coloque o queijo sobre o frango e leve ao forno", "3 horas");
		
		c.add(pizza);
		c.add(frango);
		
		System.out.println("inicio do print");
		c.print();
		System.out.println("fim do print");
		
		pizza.tabela.add("Prote�na", "40 kilos");
		
		GrupoAlimentos grupo = new GrupoAlimentos();
		
		//grupo.Adiciona(queijo);
		
		Calculos calculo = new Calculos();
		calculo.Imc(67.9, 1.87);
		
		pizza.tabela.printAll();
	}

}
