
/**@author team 7
 * @version 0.2
 * 
 *  Esta classe é a classe principal, onde reside o metodo main, o teste
 * 
 * Apresenta um menu interativo para o utilizador administrador e aluno
 * 
 */

import java.util.Scanner;

public class Teste 
{
   public static void main(String[] args)
   {
	   Scanner scanner = new Scanner(System.in);
	   Gere gere = new Gere();
	   
	   int opcao;
	   
	   do
	   {
		   System.out.println(" ***** Plataforma E-Learning de Sustentabilidade SI/POO ***** ");
		   System.out.println("1. Registo");
		   System.out.println("2. Login");
		   System.out.println("0. Sair");
		   System.out.println("Escolha uma opcao: ");
		   
		   opcao = scanner.nextInt();
		   scanner.nextLine();
		   
		   switch (opcao)
		   {
		      case 1:
		    	  System.out.println("\n === Registo === ");
		    	  System.out.println("Nome: ");
		    	  String nome = scanner.nextLine();
		    	  
		    	  System.out.println("Email: ");
		    	  String email = scanner.nextLine();
		    	  
		    	  System.out.println("Password: ");
		    	  String password = scanner.nextLine();
		    	  
		    	  System.out.println("Tipo de Utilizador (aluno/administrador): ");
		    	  String tipo = scanner.nextLine().toLowerCase();
		    	  
		    	  try
		    	  {
		    		  if (tipo.equals("aluno"))
		    		  {
		    			  Aluno aluno = new Aluno(nome, email, password);
		    			  gere.adicionarUtilizador(aluno);
		    			  System.out.println("Aluno registado com sucesso!");
		    		  }
		    		  else if (tipo.equals("administrador"))
		    		  {
		    			  Administrador admin = new Administrador(nome, email, password, "administrador");
		    			  gere.adicionarUtilizador(admin);
		    			  System.out.println("Administrador registado com sucesso!");
		    		  }
		    		  else
		    		  {
		    			  System.out.println("Tipo invalido! Tente novamente.");
		    		  }
		    		  
		    	  } catch (DadosInvalidosException e)
		    	  {
		    		  System.out.println("Erro no registo: " + e.getMessage());
		    	  }
		    	  break;
		    	  
		      case 2:
		    	  System.out.println("\n === Login === ");
		    	  System.out.println("Email: ");
		    	  String loginEmail = scanner.nextLine();
		    	  
		    	  System.out.println("Password: ");
		    	  String loginPassword = scanner.nextLine();
		    	  
		    	  Utilizador autenticado = gere.autenticar(loginEmail, loginPassword);
		    	  
		    	  if (autenticado == null)
		    	  {
		    		  System.out.println("Credenciais invalidas ou Utilizador nao encontrado.");
		    	  }
		    	  else if (!autenticado.isAtivo())
		    	  {
		    		  System.out.println("Conta desativada. Contacte um administrador da Plataforma.");
		    	  }
		    	  else
		    	  {
		    		  System.out.println("Login efetuado com sucesso!\n");
		    		  
		    		  if (autenticado instanceof Aluno)
		    		  {
		    			 Aluno aluno = (Aluno) autenticado;
		    			 aluno.mostrarMenu(gere);
		    		  }
		    		  else if (autenticado instanceof Administrador)
		    		  {
		    			  Administrador admin = (Administrador) autenticado;
		    			  admin.mostrarMenu(gere);
		    		  } 
		    	  }
		    	  break;
		    	  
		      case 0:
		    	  System.out.println("\nA ENCERRAR A APLICACAO!");
		    	  System.out.println("\nGOSTASTE DA PLATAFORMA?");
		    	  System.out.println("\nCLARO QUE GOSTASTE!");
		    	  System.out.println("\nATE LOGO!");
		    	  break;
		    	  
		      default:
		    	  System.out.println("Opcao invalida. Tente novamente.");
		   }  
		   
	   } while (opcao != 0);
   }
}
