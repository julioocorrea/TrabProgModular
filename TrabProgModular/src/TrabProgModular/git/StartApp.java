package TrabProgModular.git;
import java.util.Scanner;

public class StartApp {
		public static void main(String[] args) {
			String[] listaBr = new String[100];
			String[] listaIngles = new String[100];
			
			while (true) {			
				
				int operacao = Menu();
				
				if(operacao == 9) {
					System.out.println("Até a proxima. :)");
					break;
				}
				
				else if (operacao == 1) {				
					Cadastrar(listaBr, listaIngles);					
				}
				else if(operacao == 2) {					
					Editar(listaBr, listaIngles);
				}
				else if (operacao == 3) {
					Excluir(listaBr, listaIngles);	
				}
				else if (operacao == 4) {
					BuscarSignificado(listaBr, listaIngles);
				}
				else {
					System.out.println("\nOpção invalida, tente novamente.\n");
				}
			}
		}					

		public static int Menu () {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("O que você deseja fazer?\n"
					 + "1: Cadastrar uma palavra.\n"
					 + "2: Editar uma palavra.\n"
					 + "3: Excluir uma palavra.\n"
					 + "4: Buscar o significado de uma palavra.\n"
					 + "9: sair.");
	
			int op = input.nextInt();
			
			return op;
			
		}
		
		public static void Cadastrar (String[] listaBr, String[] listaIngles) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			
			for (int i = 0; i < 100; i++) {	
				boolean validacao = true;
				if (listaIngles[i] == null) {
					System.out.println("Digite a palavra em Inglês: ");
					String palavraIngles = input.next();										
					System.out.println("Digite a palavra em Português: ");
					String palavraBr = input.next();
					
					for (int j = 0; j < 100; j ++) {
						if (palavraIngles.equalsIgnoreCase(listaIngles[j]) || palavraBr.equalsIgnoreCase(listaBr[j])) {
							validacao = false;
							break;
						}
					}
					
					if (validacao == true) {
						listaIngles[i] = palavraIngles.toLowerCase();
						listaBr[i] = palavraBr.toLowerCase();
					    
						System.out.println("Cadastrar mais uma palavra? \n"
						         + "1: sim. \n"
						         + "2: não.");
						
						int continuar = input.nextInt();
						
						if (continuar == 1) {
							continue;
						}
						else if (continuar == 2) {
							break;
						}
					}
					else if (validacao == false ) {
						System.out.println("\nEsta palavra já está cadastrada, tente novamente.\n");
						i--;
						continue;
					}
				}			
			}
		}
		
		public static void Editar (String[] listaBr, String[] listaIngles) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			
			for (int i = 0; i < 100; i ++) {	
					
				boolean arrayVazia = true;				
				for (int a = 0; a < 100; a ++) {
					if (listaIngles[a] != null) {
						arrayVazia = false;
						break;
					}
				}
				
				if (arrayVazia == false) {
					String novaPalavraBr;
					String novaPalavraIngles;
					
					System.out.println("Qual palavra você deseja editar?");
					String palavraEditada = input.next();
					
					boolean validacao = false;
					for (int j = 0; j < 100; j ++) {
						if (palavraEditada.equalsIgnoreCase(listaIngles[j]) || palavraEditada.equalsIgnoreCase(listaBr[j])) {
							i = j;
							validacao = true;
							break;
						}
					}
				
					if(validacao == true) {
						boolean palavraRepetida = false;
						System.out.println("Digite a nova palavra em Inglês:");
						novaPalavraIngles = input.next();
						
						System.out.println("Digite a nova palavra em Português: ");
						novaPalavraBr = input.next();
						
						
						for (int a = 0; a < 100; a ++) {
							if (novaPalavraIngles.equalsIgnoreCase(listaIngles[a]) || novaPalavraBr.equalsIgnoreCase(listaBr[a])) {
								palavraRepetida = true;
								break;
							}
						}
						
						if (palavraRepetida == false ){
							listaIngles[i] = novaPalavraIngles;
							listaBr[i] = novaPalavraBr;
							
							i = 0;
							
							System.out.println("Editar mais uma palavra? \n"
							         + "1: sim. \n"
							         + "2: não.");
							
							int continuar = input.nextInt();
							
							if (continuar == 1) {
								continue;
							}
							else if (continuar == 2) {
								break;
							}
						}
						else if (palavraRepetida == true) {
							System.out.println("\nEsta palavra ja está cadastrada, tente novamente. \n");
							continue;
						}
					}
					else if (validacao == false) {
						System.out.println("\nEsta palavra não está cadastrada, tente novamente. \n");
						i = 0;
						continue;
					}
				}
				else if (arrayVazia == true) {
					System.out.println("\nNenhuma palavra cadastrada.\n");
					break;
				}
			}
		}
		
		public static void Excluir (String[] listaBr, String[] listaIngles) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);			
			
			for (int i = 0; i < 100; i ++) {
				
				boolean arrayVazia = true;				
				for (int a = 0; a < 100; a ++) {
					if (listaIngles[a] != null) {
						arrayVazia = false;
						break;
					}
				}
				
				if (arrayVazia == false) {
					System.out.println("Qual palavra você deseja excluir?");
					String palavraExcluida = input.next();
					
					boolean palavraCadastrada = false;
					for (int j = 0; j < 100; j ++) {
						if (palavraExcluida.equalsIgnoreCase(listaBr[j]) || palavraExcluida.equalsIgnoreCase(listaIngles[j])) {
							i = j;
							palavraCadastrada = true;
							break;
						}
					}
					
					if(palavraCadastrada == true) {
						listaIngles[i] = null;
						listaBr[i] = null;
						
						i = 0;
						
						System.out.println("Excluir mais uma palavra? \n"
							         + "1: sim. \n"
							         + "2: não.");
							
						int continuar = input.nextInt();
							
						if (continuar == 1) {
								continue;
						}
						else if (continuar == 2) {
								break;
						}
																
					}	
					else if (palavraCadastrada == false) {
						System.out.println("\nEsta palavra não está cadastrada, tente novamente.\n");
						i = 0;
						continue;
					}
				}
				else if (arrayVazia == true) {
					System.out.println("\nNenhuma palavra cadastrada.\n");
					break;
				}
			}
		}
		
		public static void BuscarSignificado (String[] listaBr, String[] listaIngles) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
				
				boolean arrayVazia = true;				
				for (int a = 0; a < 100; a ++) {
					if (listaIngles[a] != null) {
						arrayVazia = false;
						break;
					}
				}
				
				if (arrayVazia == false ) {	
					for (int i =0; i < 100; i ++) {
						boolean palavraCadastrada = false;
						System.out.println("Qual palavra você deseja saber o significado?");
						String palavra = input.next();										
						
						for (int j = 0; j < 100; j ++) {
							if (palavra.equalsIgnoreCase(listaBr[j]) || palavra.equalsIgnoreCase(listaIngles[j])) {
								i = j;
								palavraCadastrada = true;
								break;
							}
						}
						
						if (palavraCadastrada == true) {
							if (palavra.equalsIgnoreCase(listaBr[i])) {
								System.out.println("\nO significado de " + listaBr[i] + " é " + listaIngles[i] + ".\n");
							}
							else if (palavra.equalsIgnoreCase(listaIngles[i])) {
								System.out.println("\nO significado de " + listaIngles[i] + " é " + listaBr[i] + ".\n");
							}
							
							i = 0;
							
							System.out.println("Procurar o significado de mais uma palavra? \n"
							         + "1: sim. \n"
							         + "2: não.");
							
							int continuar = input.nextInt();
								
							if (continuar == 1) {
									continue;
							}
							else if (continuar == 2) {
									break;
							}
							
						}
						
						else if (palavraCadastrada == false) {
							System.out.println("\nPalavra nao cadastrada, tente novamente\n");
							i = 0;
							continue;
						}
						
					}
				}
			
				else if (arrayVazia == true) {
					System.out.println("\nNenhuma palavra cadastrada.\n");	
				}
		}
}
		
				

	
		