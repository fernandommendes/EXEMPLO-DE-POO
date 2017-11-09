package principal;

import java.util.Scanner;

import dados.NotaAluno;

public class Principal {

	private static Scanner entrada = new Scanner(System.in);
	private static int n = 0;
	private static NotaAluno[] objNotas = new NotaAluno[50];
	
	public static void main(String[] args) {
		menu();
		System.out.println("\nFinal do programa.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nMENU EXEMPLO POO");
			System.out.println("1-Incluir conjunto de notas");
			System.out.println("2-Consultar nota pelo registro");
			System.out.println("3-Consultar notas pelo nome");
			System.out.println("4-Alterar nota via registro");
			System.out.println("0-Sair\n");
			
			System.out.print("Informe op��o: ");
			opcao = Integer.parseInt(entrada.nextLine());
			
			switch (opcao) {
				case 1:
					while (true) {
						System.out.print("Informe N� de notas: ");
						String nNotas = entrada.nextLine();
						if (!nNotas.matches("[0-9]{1,2}") || Integer.parseInt(nNotas) > 50) {
							System.out.println("N� de notas inv�lido.");
						} else {
							n = Integer.parseInt(nNotas);
							lerNotas();
							break;
						}
					}
					break;
				case 2:
					pesqNota();
					break;
				case 3:
					pesqNome();
					break;
				case 4:
					alterarNota();
					break;
				case 0:
					break;
				default:
					System.out.println("Op��o Inv�lida.");
					break;
			}
		} while (opcao!=0);
	}



	private static void lerNotas() {
		
		for (int i = 0; i < n; i++ ){
			System.out.println("\nEntrada de dados para " + (i+1) + "� nota\n");

			int registro = 0;
			while (true) {
				System.out.print("Registro: ");
				String reg = entrada.nextLine();
				if (!reg.matches("[0-9]{1,6}") || Integer.parseInt(reg) <= 0 ){
					System.out.println("Registro inv�lido.");
				} else {
					registro = Integer.parseInt(reg);
					break;
				}
			}
			
			
			String nome;
			while (true) {
				System.out.print("Nome: ");
				nome = entrada.nextLine();
				if (nome.trim().isEmpty()) {
					System.out.println("Nome inv�lido.");
				} else {
					break;
				}
			}
			
			int nota = 0;
			while (true) {
				System.out.print("Nota: ");
				String nt = entrada.nextLine();
				if (!nt.matches("[0-9]{1,3}") || Integer.parseInt(nt) > 100) {
					System.out.println("Nota inv�lido.");
				} else {
					nota = Integer.parseInt(nt);
					break;
				}
			}				
			
			objNotas[i] = new NotaAluno(registro, nome, nota);
			System.out.println("Nota inclu�da.");
			
		}
	}
	
	private static void pesqNota() {
		System.out.println("\nPesquisar nota pelo registro do aluno\n");
		int registro = 0;

		while (true) {
			System.out.print("Registro: ");
			String reg = entrada.nextLine();
			if (!reg.matches("[0-9]{1,6}") || Integer.parseInt(reg) <= 0) {
				System.out.println("Registro inv�lido.");
			} else {
				registro = Integer.parseInt(reg);
				break;
			}
		}	
		
		for (int i = 0 ; i < n; i++) {
			if (objNotas[i].getRegistro()==registro) {
				NotaAluno obj = objNotas[i];
				//System.out.println("Nome: "  + obj.getNome()+ "\n" + "Nota: " + obj.getNota());
				System.out.println(obj.toString());
				return;
			}
		}
		System.out.println("N�o existe nota para o registro informado.");
	}


	private static void pesqNome() {
		System.out.println("\nPsequisar notas pelo nome\n");
		
		System.out.print("Informa o nome: ");
		String nome = entrada.nextLine().trim().toUpperCase();
		
		int achados = 0;
		for (int i = 0; i < n; i++) {
			if (objNotas[i].getNome().toUpperCase().contains(nome)) {
				NotaAluno obj = objNotas[i];
				//System.out.println("Registro: " + obj.getRegistro());
				//System.out.println("Nome: " + obj.getNome());
				//System.out.println("Nota: " + obj.getNota() + "\n");
				System.out.println(obj.toString());
				achados++;
			}
		}
		if (achados==0) {
			System.out.println("N�o existe nota para o nome.");
		} else {
			System.out.println("Quantidade de alunos: " + achados);
		}
		
		
		
	}
	
	private static void alterarNota() {
		System.out.println("\nAlterar nota via registro\n");
		
		int registro = 0;
		
		NotaAluno obj;
		
		validacao:
		while (true) {
			System.out.print("Registro: ");
			String aux = entrada.nextLine();
			if ( !aux.matches("[0-9]{1,6}")) {
				System.out.println("Registro inv�lido.");
				continue;
			}
			registro = Integer.parseInt(aux);
			for (int i=0; i < n; i++) {
				if (objNotas[i].getRegistro()==registro) {
					obj = objNotas[i];
					break validacao;
				}
			}
			System.out.println("N�o existe nota para o registro.");
		}
		int nota=0;
		while (true) {
			System.out.print("Informe a nota: ");
			String aux = entrada.nextLine();
			if (!aux.matches("[0-9]{1,3}") || Integer.parseInt(aux) > 100) {
				System.out.println("Nota inv�lido.");
			} else {
				nota = Integer.parseInt(aux);
				break;
			}
		}
		obj.setNota(nota);
		System.out.println("Nota alterada.");
	}
}
