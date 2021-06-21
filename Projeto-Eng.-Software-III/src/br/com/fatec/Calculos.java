package br.com.fatec;

public class Calculos {
	
	public static void Imc(Double peso, Double altura) {
		double porcent= peso/(Math.pow(altura,2));
		System.out.println(porcent);
		
		if(porcent<18.5) {
			System.out.println("Vai comer seu magro!!");
		}
		else if(porcent<24.9) {
			System.out.println("Ta bom");
		}
		else if(porcent<29.9) {
			System.out.println("Ta na hora de uma dieta acha não?");
		}
		else if(porcent<39.9) {
			System.out.println("Caraca, Vamo pra academia meu amigo ");
		}
		else{
			System.out.println("Vc pode ir pro Kilos Mortais numa boa");
		}
	}
	
	public static void PGC(Double peso, Double altura,String genero,int idade) {
		double IMC = peso/(Math.pow(altura,2));
		double modgen=0;
		if(genero=="M") {
			modgen=1;
		}	
		double indice = (1.20 * IMC) + (0.23 * idade) - (10.8 * modgen)- 5.4;
		System.out.println("Percentual de Gordura Corporal: "+ indice + "%");
	}
	
}
