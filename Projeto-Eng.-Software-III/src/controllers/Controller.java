package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import br.com.fatec.*;

/*
 * Cadastro de Alimentos
 * Cadastro de Receitas (comofas, ingredientes, tempo)
 * Cadastro de Combinações
 * Agrupar Alimentos
 * Banco com 10 elementos já Cadastrados
 * Adicionar e editar tabela nutriconal
 * 
 */

public class Controller {
    private Scanner scan;
    private boolean execute;
    GrupoAlimentos ga = new GrupoAlimentos();

    public void start() throws IOException {
    	
    	registroBase();
        scan = new Scanner(System.in);
        execute = true;
        System.out.println("\nBom Dia!!");

        while (execute) {
            String option = mainMenu();
/*
 * 
 *       System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Receita");
        System.out.println("2 - Alimento");
        System.out.println("3 - Tabela Nutricional");
        System.out.println("4 - Combinação");
        System.out.println("5 - Voltar");
 */
            if (option.equalsIgnoreCase("1")) {
            	String list = listMenuCadastro();
            	if (list.equalsIgnoreCase("1")) {
            			regReceita();
            		} else if (list.equalsIgnoreCase("2")) {
            			regAlimento();
            		} else if (list.equalsIgnoreCase("3")) {
            			regTabela();
            		} else if (list.equalsIgnoreCase("4")) {
                		regComb();
            		} else if (list.equalsIgnoreCase("5")) {
                    			// voltar para o inicio do programa
            		} else {
                         System.out.println("Favor digitar um número válido!!");
                    }
                
            } else if (option.equalsIgnoreCase("2")) {
                String list = listMenu();
                if (list.equalsIgnoreCase("1")) {
                	calcIMC();
                } else if (list.equalsIgnoreCase("2")) {
                	calcPGC();
                } else if (list.equalsIgnoreCase("3")) {
             
                } else {
                    System.out.println("Favor digitar um número válido!!");
                }

            } else if (option.equalsIgnoreCase("3")) {
            	String list = listCad();
                if (list.equalsIgnoreCase("1")) {
                	ga.printList();
                } else if (list.equalsIgnoreCase("2")) {
                	printCat();
                } else if (list.equalsIgnoreCase("3")) {
                	printGroup();
                } else if (list.equalsIgnoreCase("4")) {
             
                } else {
                    System.out.println("Favor digitar um número válido!!");
                }
            } else if (option.equalsIgnoreCase("4")) {
            	execute = false;
            } else {
                System.out.println("Favor digitar um número válido!!");
            }
        }
    }

	public String mainMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Calculos");
        System.out.println("3 - Cadastrados");
        System.out.println("4 - Sair");
        return scan.nextLine();
       
    }
	
	public String listCad() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Comidas");
        System.out.println("2 - Comidas por categoria");
        System.out.println("3 - Comidas por grupo");
        System.out.println("4 - Sair");
        return scan.nextLine();
	}

    public String listMenu() {
    	System.out.println("\nSelecione a opção: ");
        System.out.println("1 - IMC");
        System.out.println("2 - Porcentagem de Gordura Corporal");
        System.out.println("3 - Voltar");
        return scan.nextLine();
    }
    
    public String listMenuCadastro() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Receita");
        System.out.println("2 - Alimento");
        System.out.println("3 - Tabela Nutricional");
        System.out.println("4 - Combinação");
        System.out.println("5 - Voltar");
        return scan.nextLine();
    }    
    
    private void regAlimento() {
    	System.out.println("Digite o nome do Alimento:");
    	String nome = scan.nextLine();
    	System.out.println("Digite o grupo do Alimento:");
    	String grupo = scan.nextLine();
    	System.out.println("Digite o tipo do Alimento:");
    	String tipo = scan.nextLine();
    	ga.add(new Alimento(nome, tipo, grupo));
    }
    
    private void regReceita() {
    	List<Integer> f = new ArrayList<Integer>();
    	List<String> r = new ArrayList<String>();
    	Map<Comida, String> m = new HashMap<Comida, String>();
    	boolean check = true;
    	System.out.println("Digite o nome da Receita: ");
    	String nome = scan.nextLine();
    	System.out.println("Escolha o alimento: ");
    	ga.printForChoose(f);    	
    	f.add(Integer.parseInt(scan.nextLine()));
    	System.out.println("Digite a quantidade: ");
    	r.add(scan.nextLine());
    	while(check) {
    		System.out.println("Deseja adicionar outro alimento? \n1 - Sim\n 2 - Não");
    		if(scan.nextLine().equalsIgnoreCase("1")) {
    	    	System.out.println("Escolha o alimento: ");
    	    	ga.printForChoose(f);
    	    	f.add(Integer.parseInt(scan.nextLine()));
    	    	System.out.println("Digite a quantidade: ");
    	    	r.add(scan.nextLine());
    		} else 
    			check = false;
    	}
    	for(int i=0;i<f.size();i++) {
    		m.put(ga.get(f.get(i)), r.get(i));
    	}
    	System.out.println("Descreva o modo de preparo: ");
    	String prep = scan.nextLine();
    	System.out.println("Tempo de preparo: ");
    	String tempo = scan.nextLine();
    	ga.add(new Receitas(nome, m, prep, tempo));
    }
    
    private void regTabela() {
    	boolean check = true;
    	System.out.println("Escolha o alimento: ");
    	ga.printForChoose();
    	int f = Integer.parseInt(scan.nextLine());
    	System.out.println("Digite a categoria: ");
    	String cat = scan.nextLine();
    	System.out.println("Digite o valor: ");
    	String valor = scan.nextLine();
    	ga.get(f).tabela.add(cat, valor);
    	while(check) {
    		System.out.println("Deseja adicionar outro item à tabela? \n1 - Sim\n 2 - Não");
    		if(scan.nextLine().equalsIgnoreCase("1")) {
    	    	System.out.println("Digite a categoria: ");
    	    	cat = scan.nextLine();
    	    	System.out.println("Digite o valor: ");
    	    	valor = scan.nextLine();
    	    	ga.get(f).tabela.add(cat, valor);
    		} else 
    			check = false;
    	}
    }
    
    private void regComb() {
    	boolean check = true;
    	System.out.println("Digite o nome da função:");
    	Combinação c = new Combinação(scan.nextLine());
    	System.out.println("Escolha o alimento: ");
    	ga.printForChoose();
    	int f = Integer.parseInt(scan.nextLine());
    	c.add(ga.get(f));
    	while(check) {
    		System.out.println("Deseja adicionar outro item à tabela? \n1 - Sim\n 2 - Não");
    		if(scan.nextLine().equalsIgnoreCase("1")) {
    	    	System.out.println("Escolha o alimento: ");
    	    	ga.printForChoose();
    	    	f = Integer.parseInt(scan.nextLine());
    	    	c.add(ga.get(f));
    		} else 
    			check = false;
    	}
    	ga.add(c);
    }
    
    private void calcIMC() {
    	System.out.println("Digite seu peso: ");
    	double peso = Double.parseDouble(scan.nextLine());
    	System.out.println("Digite sua altura: ");
    	double alt = Double.parseDouble(scan.nextLine());
    	
    	Calculos.Imc(peso, alt);
    }
    
    private void calcPGC() {
    	System.out.println("Digite seu peso: ");
    	double peso = Double.parseDouble(scan.nextLine());
    	System.out.println("Digite sua altura: ");
    	double alt = Double.parseDouble(scan.nextLine());
    	System.out.println("Digite seu genero: \nM - Masculino\nF - Feminino");
    	String g = scan.nextLine();
    	System.out.println("Digite sua idade: ");
    	int age = Integer.parseInt(scan.nextLine());
    	
    	Calculos.PGC(peso, alt, g, age);
    }
    
    public void printGroup() {
    	System.out.println("Escolha o grupo: ");
    	ga.printGrupos();
    	ga.printFromGrupo(Integer.parseInt(scan.nextLine()));
    }
    
    public void printCat() {
    	System.out.println("Escolha a categoria: \n1 - Alimento\n2 - Receita\n3 - Combinação");
    	String line = scan.nextLine();
    	if(line.equalsIgnoreCase("1"))
    		ga.printAlim();
    	else if(line.equalsIgnoreCase("2"))
    		ga.printRec();
    	else if(line.equalsIgnoreCase("3"))
    		ga.printComb();
    	else
    		System.out.println("Input Inválido");
    }
    
    //Criação na de 12 alimentos
    public void registroBase() {
    	Alimento pao =new Alimento("Pão", "Aliemnto", "4");
    	ga.add(pao);
    	
    	Alimento queijo = new Alimento("Queijo", "Derivados", "1");
    	ga.add(queijo);
    	
    	Alimento arroz = new Alimento("Arroz", "Grãos", "4");
    	ga.add(arroz);
    	
    	Alimento tomate = new Alimento("Tomate", "Fruta", "3");
    	ga.add(tomate);
    	
    	Alimento feijao = new Alimento("Feijão", "Grãos", "4");
    	ga.add(feijao);
    	
    	Alimento maionese = new Alimento("Maionese", "Derivados", "1");
    	ga.add(maionese);
    	
    	Alimento leite = new Alimento("Leite", "Derivados", "1");
    	ga.add(leite);
    	
    	Alimento alface = new Alimento("Alface", "Vegetais", "5");
    	ga.add(alface);
    	
    	Alimento carne = new Alimento("Carne", "Carnes", "2");
    	ga.add(carne);
    	
    	Alimento acucar = new Alimento("Açucar", "Açucares", "5");
    	ga.add(acucar);
    	
    	
    	ga.add(new Alimento("Maçã", "Fruta", "3"));
    	ga.add(new Alimento("Frango", "Carnes", "2"));    	
    	ga.add(new Alimento("Café", "Grãos", "4"));
    	
    	Map<Comida, String> m = new HashMap<Comida, String>();
    	m.put(pao, "2");
    	m.put(alface, "1");
    	m.put(tomate, "2");
    	
    	Map<Comida, String> m1 = new HashMap<Comida, String>();
    	
    	m1.put(arroz, "100 kg");
    	m1.put(feijao, "80 kg");
    	
    	Map<Comida, String> m2 = new HashMap<Comida, String>();
    	
    	m2.put(carne, "300 kg");
    	m2.put(tomate, "100 kg");
    
    	ga.add(new Receitas("Carne Louca", m2, "Desfia a carne cozinha com tomates picados e colocar no pão", "2 horas"));
    	ga.add(new Receitas("Sanduiche", m, "Junta tudo a gosto", "15 min"));
    	ga.add(new Receitas("Arroz e Feijão", m1, "Coloca no prato", "20 min"));
    	
    	Combinação c = new Combinação("Arroz doce");
    	c.add(arroz);
    	c.add(acucar);
    	
    	ga.add(c);
    	
    	Combinação c1 = new Combinação("Tomate com Arroz");
    	c1.add(arroz);
    	c1.add(tomate);
    	
    	ga.add(c1);
    	
    	
    	Combinação c2 = new Combinação("Carne com feijão");
    	c2.add(carne);
    	c2.add(feijao);
    	
    	ga.add(c2);
    	
    }
}