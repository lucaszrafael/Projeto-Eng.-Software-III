package br.com.fatec;

public class Alimento extends Comida{
	public String tipo;
	
	public Alimento(String nome, String tipo, String grupo) {
		this.nome = nome;
		this.tipo = tipo;
		this.grupo = grupo;
	}
	
	public Alimento(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
        return this.tipo + this.grupo + "\n"; 
    }

	@Override
	public void print() {
		System.out.println("--------~--------");
		System.out.println("Nome:  " + nome);
		System.out.println("Tipo:  " + tipo);
		System.out.println("Grupo: " + grupo);
	}
}
