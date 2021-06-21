package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class GrupoAlimentos {
	private static List<Comida> TodosAlimentos = new ArrayList<Comida>();
	List<String> grupos = new ArrayList<String>();
	
	public GrupoAlimentos() {};
	
	public void add(Comida a) {
		TodosAlimentos.add(a);
	}
	
	public static List<Comida> getLista() {
		return TodosAlimentos;
	}
	
	public void printList() {
		for(Comida a :TodosAlimentos) {
			a.print();
		}
	}
	
	public void printForChoose(List<Integer> f) {
		for(int i = 0;i<TodosAlimentos.size();i++) {
			if(!f.contains(i))
			System.out.println(i + " - " + TodosAlimentos.get(i).nome);
		}
	}
	
	public void printForChoose() {
		for(int i = 0;i<TodosAlimentos.size();i++) {
			System.out.println(i + " - " + TodosAlimentos.get(i).nome);
		}
	}
	
	public void printAll() {
		for(Comida a :TodosAlimentos) {
			System.out.println(a.nome + " - " + a.grupo);
		}
	}
	
	public void printGrupos() {
		for(int i = 0;i<TodosAlimentos.size();i++) {
				if(!grupos.contains(TodosAlimentos.get(i).grupo)&&!(TodosAlimentos.get(i).grupo.equals("Não Aplica")))
					grupos.add(TodosAlimentos.get(i).grupo);
		}
		for(int i =0;i<grupos.size();i++) {
			System.out.println(i + " - " + grupos.get(i));
		}
		
	}
	
	public void printFromGrupo(int i) {
		for(Comida a:TodosAlimentos) {
			if(a.grupo.equals(grupos.get(i))) {
				a.print();
			}
		}
	}
	
	public Comida get(int i) {
		return TodosAlimentos.get(i);
	}
	
	public void printAlim() {
		for(Comida a:TodosAlimentos)	
			if(a instanceof Alimento)
				a.print();
	}
	public void printRec() {
		for(Comida a:TodosAlimentos)	
			if(a instanceof Receitas)
				a.print();
	}
	public void printComb() {
		for(Comida a:TodosAlimentos)	
			if(a instanceof Combinação)
				a.print();
	}
}
