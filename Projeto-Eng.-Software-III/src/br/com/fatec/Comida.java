package br.com.fatec;

public abstract class Comida {
		public String nome;
		public Tabela tabela = new Tabela();
		public String grupo;
		
		public abstract void print();
}
