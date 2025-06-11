
/**@author team 7
 * @version 0.1 - Já não é esta, a classe principal onde tem o main, Teste ficou a classe main(principal)
 * Esta classe é a classe principal, onde reside o metodo main, o teste
 * 
 * Apresenta um menu interativo para o utilizador com opcoes de administrador e aluno
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		//Instancias de objetos
		Scanner scanner = new Scanner(System.in);
		ArrayList<Utilizador> utilizadores = new ArrayList<>();
		ArrayList<Modulo> modulos = new ArrayList<>();
		Gere gestor = new Gere();
		
		//menu inicial
		while(true)
		{
			System.out.println("\n ***** Plataforma E_Learning de Sustentabilidade ***** ");
			System.out.println("1. Sou Administrador");
			System.out.println("2. Sou Aluno");
			System.out.println("0. Sair");
			System.out.println("Escolha uma das opcoes: ");
			//Para ler a escolha
			String opcao = scanner.nextLine();
			
			switch (opcao)
			{
			   //Menu do administrador
			   case "1": 
				   System.out.println(" --- Area do Administrador --- ");
				   System.out.println("1. Registar-me como Administrador");
				   System.out.println("2. Fazer o Login como Administrador");
				   System.out.println("Escolha uma das opcoes: ");
				   //Para ler a escolha
				   String escolhaAdm = scanner.nextLine();
				   
				   if (escolhaAdm.equals("1"))
				   {
					   try
					   {
						   System.out.println("Insira o nome do administrador: ");
						   String nomeAdm = scanner.nextLine();
						   
						   System.out.println("Insira o email do administrador: ");
						   String emailAdm = scanner.nextLine();
						   
						   System.out.println("Insira a password do administrador: ");
						   String passAdm = scanner.nextLine();
						   
						   //Objeto do Tipo Adm
						   Utilizador novoAdm = new Utilizador(nomeAdm, emailAdm, passAdm, "administrador");
						   utilizadores.add(novoAdm);
						   System.out.println("O Administrador foi registado com sucesso!");
					   }
					   catch (DadosInvalidosException e)
					   {
						   System.out.println("Erro no registo: " + e.getMessage());
					   }
				   }
				   else if (escolhaAdm.equals("2"))
				   {
					   System.out.println("Insira o nome do administrador: ");
					   String nome = scanner.nextLine();
					   
					   System.out.println("Insira o email do administrador: ");
					   String email = scanner.nextLine();
					   
					   System.out.println("Insira a password do administrador: ");
					   String password = scanner.nextLine();
					   
					   //Utl Adm preenche as informaçoes se tiver o adm certo com email e pass e nome
					   Utilizador admin = null;
					   for (Utilizador u : utilizadores)
					   {
						   if (u.getTipo().equalsIgnoreCase("administrador") && u.getEmail().equals(email) && u.getPassword().equals(password) && u.getNome().equals(nome))
						   {
							  admin = u;
							  break;
						   }
					   }
					   //Se as informacoes todas existem
					   if (admin != null)
					   {
						   System.out.println("Bem-vindo, administrador " + admin.getNome() + "!");
						   
						   boolean voltar = false;
						   
						   while (!voltar)
						   {
							   System.out.println(" --- Menu do Administrador --- ");
							   System.out.println("1. Criar um Modulo");
							   System.out.println("2. Editar um Modulo");
							   System.out.println("3. Remover um Modulo");
							   System.out.println("4. Consultar Modulos");
							   System.out.println("5. Criar um Quizz para um Modulo");
							   System.out.println("6. Editar um Quizz");
							   System.out.println("7. Remover um Quizz");
							   System.out.println("8. Adicionar Conteudo a um Modulo");
							   System.out.println("0. Voltar ao menu principal");
							   System.out.println("Escolha uma opcao: ");
							   //Para ler a escolha do administrador
							   String opcaoAdmMenu = scanner.nextLine();
							   
							   switch (opcaoAdmMenu)
							   {
							      case "1":
							    	  System.out.println(" --- Criar um Modulo --- ");

							    	  System.out.println("Qual o titulo do Modulo: ");
							    	  String titulo = scanner.nextLine();
							    	  
							    	  System.out.println("Qual a descricao do Modulo: ");
							    	  String descricao = scanner.nextLine();
							    	  
							    	  System.out.println("Qual a ordem do Modulo(insira um numero inteiro): ");
							    	  int ordem = Integer.parseInt(scanner.nextLine());
							    	  
							    	  System.out.println("Qual o objetivo do Modulo: ");
							    	  String objetivo = scanner.nextLine();
							    	  
							    	  // Para criar um modulo mesmo ser ter perguntas no quizz
							    	  //Usado quando queremos associar um quizz sempre que criarmos um modulo (new Quizz)
							    	  Modulo novo = new Modulo(titulo, descricao, ordem, objetivo, new Quizz());
							    	  gestor.criarModulo(modulos, novo);
							    	  
							    	  System.out.println("Modulo criado com sucesso!");
							    	  break;
							    	  
							       case "2":
							    	   System.out.println(" --- Editar um Modulo ---");
							    	   
							    	   if (modulos.isEmpty())
						               {
						            	   System.out.println("Nao ha modulos criados ainda.");
						               }
							    	   
							    	   //Apresentar os modulos criados
							    	   for (int i = 0; i < modulos.size(); i++)
							    	   {
							    		   System.out.println(i + ": " + modulos.get(i).getTitulo());
							    	   }
							    	   System.out.println("Escolha o Modulo que pretende editar: ");
							    	   int iEdit = Integer.parseInt(scanner.nextLine());
							    	   
							    	   if (iEdit >= 0 && iEdit < modulos.size())
							    	   {
							    		   //Capturar o modulo escolhido e guarda numa var
							    		   Modulo m = modulos.get(iEdit);
							    		   
							    		   System.out.println("Qual o novo titulo do Modulo: ");
							    		   String novotitulo = scanner.nextLine();
							    		   
							    		   System.out.println("Qual a nova descricao do Modulo: ");
							    		   String novaDescricao = scanner.nextLine();
							    		   
							    		   System.out.println("Qual a nova Ordem do Modulo(numero inteiro): ");
							    		   int novaOrdem = scanner.nextInt();
							    		   
							    		   System.out.println("Qual o novo objetivo do Modulo: ");
							    		   String novoObjetivo = scanner.nextLine();
							    		   
							    		   gestor.editarModulo(m, novotitulo, novaDescricao, novaOrdem, novoObjetivo);
							    		   
							    		   System.out.println("O Modulo foi atualizado com sucesso.");
							    	   }
							    	   else 
							    	   {
							    		   System.out.println("Indice invalido.");
							    	   }
							    	   break;
							    	   
							        case "3":
							        	System.out.println(" --- Remover um Modulo --- ");
							        	
							        	if (modulos.isEmpty())
						            	{
						            		System.out.println("Nao ha modulos criados ainda.");
						            	}
							        	
							        	for (int i = 0; i < modulos.size(); i++)
							        	{
							        		System.out.println(i + ": " + modulos.get(i).getTitulo());
							        	}
							        	
							        	System.out.println("Escolha o numero do modulo para remover: ");
							        	int indiceRemover = Integer.parseInt(scanner.nextLine());
							        	
							        	if (indiceRemover >= 0 && indiceRemover < modulos.size())
							        	{
							        		gestor.removerModulo(modulos, modulos.get(indiceRemover));
							        		
							        		System.out.println("O Modulo foi removido com sucesso.");
							        	}
							        	else
							        	{
							        		System.out.println("Indice invalido.");
							        	}
							        	break;
							        	
							         case "4":
							        	 System.out.println(" --- Consultar os Modulos criados --- ");
							        	 
							        	 if (modulos.isEmpty())
							             {
							                 System.out.println("Nao ha modulos criados ainda.");
							             }
							        	 
							        	 for (Modulo m : modulos)
							        	 {
							        		 System.out.println(m);
							        	 }
							        	 break;
							        	 
							          case "5":
							        	  System.out.println(" --- Criar um Quizz para um Modulo --- ");
							        	  
							        	  if (modulos.isEmpty())
							        	  {
							        		  System.out.println("Nao ha modulos criados ainda.");
							        		  break;
							        	  }
							        	  System.out.println("Escolha em qual modulo quer associar o quizz: ");
							        	  
							        	  for (int i = 0; i < modulos.size(); i++)
							        	  {
							        		  System.out.println(i + ": " + modulos.get(i).getTitulo());
							        	  }
							        	  int indiceModulo = Integer.parseInt(scanner.nextLine());
							        	  
							        	  if (indiceModulo >= 0 && indiceModulo < modulos.size())
							        	  {
							        		  Quizz q = new Quizz();
							        		  
							        		  System.out.println("Quantas perguntas terá o quizz: "); //pode ser alterado
							        		  int numPerguntas = Integer.parseInt(scanner.nextLine());
							        		  
							        		  for (int i = 0; i < numPerguntas; i++)
							        		  {
							        			  //numero da pergunta comecando do 1
							        			  System.out.println("Enunciado da pergunta " + (i + 1) + ": ");
							        			  String enunciado = scanner.nextLine();
							        			  
							        			  ArrayList<String> alternativas = new ArrayList<>();
							        			  
							        			  for (char opcaoAlt = 'A'; opcaoAlt <= 'D'; opcaoAlt++)
							        			  {
							        				  //o utilizador digitará as alterns e adiciona na lista de alterns
							        				  System.out.println("Alternativa " + opcaoAlt + ": ");
							        				  alternativas.add(scanner.nextLine());
							        			  }
							        			  
							        			  //Recebe a resposta correta e a justifc para mostrar no feedback do quizz
							        			  System.out.println("Resposta correta (ex: A): ");
							        			  String correta = scanner.nextLine();
							        			  
							        			  System.out.println("Justificativa: ");
							        			  String justificativa = scanner.nextLine();
							        			  
							        			  Pergunta p = new Pergunta(enunciado, alternativas, correta, justificativa);
							        			  q.adicionarPergunta(p);
							        		  }
							        		  gestor.criarQuizz(modulos.get(indiceModulo), q);
							        		  
							        		  System.out.println("Quizz associado ao modulo com sucesso!");
							        	  }
							        	  else
							        	  {
							        		  System.out.println("Indice do modulo invalido.");
							        	  }
							        	  break;
							        	  
							           case "6":
							        	   System.out.println(" --- Editar um Quizz --- ");
							        	   
							        	   if (modulos.isEmpty())
							               {
							            	   System.out.println("Nao ha modulos criados ainda.");
							               }
							        	   
							        	   for (int i = 0; i < modulos.size(); i++)
							        	   {
							        		   System.out.println(i + ": " + modulos.get(i).getTitulo());
							        	   }
							        	   System.out.println("Escolha um Modulo para editar um Quizz: ");
							        	   int idQuizz = Integer.parseInt(scanner.nextLine());
							        	   
							        	   if (idQuizz >= 0 && idQuizz < modulos.size())
							        	   {
							        		   Quizz quizz = modulos.get(idQuizz).getQuizz();
							        		   
							        		   if (quizz == null || quizz.getPerguntas().isEmpty())
							        		   {
							        			   System.out.println("Este modulo nao tem um quizz.");
							        		   }
							        		   else
							        		   {
							        			   //se houver perguntas no quizz, apresentamo-as
							        			   for (int i = 0; i < quizz.getPerguntas().size(); i++)
							        			   {
							        				   System.out.println(i + ": " + quizz.getPerguntas().get(i).getEnunciado());
							        			   }
							        			   
							        			   System.out.println("Escolha a pergunta que pretende editar: ");
							        			   int iPergunta = Integer.parseInt(scanner.nextLine());
							        			   
							        			   if (iPergunta >= 0 && iPergunta < quizz.getPerguntas().size())
							        			   {
							        				   System.out.println("Insira o novo enunciado da pergunta: ");
							        				   String en = scanner.nextLine();
							        				   
							        				   ArrayList<String> novasAlt = new ArrayList<>();
							        				   for (char alt = 'A'; alt <= 'D'; alt++)
							        				   {
							        					   System.out.println("Alternativa " + alt + ": ");
							        					   novasAlt.add(scanner.nextLine());
							        				   }
							        				   System.out.println("Insira a nova resposta correta: ");
							        				   String rc = scanner.nextLine();
							        				   
							        				   System.out.println("Insira a nova justificativa: ");
							        				   String j = scanner.nextLine();
							        				   
							        				   Pergunta novaPergunta = new Pergunta(en, novasAlt, rc, j);
							        				   gestor.editarQuizz(quizz, iPergunta, novaPergunta);
							        				   
							        				   System.out.println("A pergunta foi atualizada com sucesso.");
							        			   }
							        		   }
							        	   }
							        	   break;
							        	   
							            case "7":
							            	System.out.println(" --- Remover um Quizz de um modulo --- ");
							            	
							            	if (modulos.isEmpty())
							            	{
							            		System.out.println("Nao ha modulos criados ainda.");
							            	}
							            	
							            	for (int i = 0; i < modulos.size(); i++)
							            	{
							            		System.out.println(i + ": " + modulos.get(i).getTitulo());
							            	}
							            	System.out.println("Escolha um Modulo para remover um Quizz: ");
							            	int rQuizz = Integer.parseInt(scanner.nextLine());
							            	
							            	if (rQuizz >= 0 && rQuizz < modulos.size())
							            	{
							            		gestor.removerQuizz(modulos.get(rQuizz));
							            		System.out.println("O Quizz foi removido com sucesso.");
							            	}
							            	break;
							            	
							            case "8":
							            	System.out.println(" --- Adicionar conteudo a um Modulo");
							            	
							            	for (int i = 0; i < modulos.size(); i++)
							            	{
							            		System.out.println(i + ": " + modulos.get(i).getTitulo());
							            	}
							            	
							            	System.out.println("Escolha o Modulo que pretende adicionar um conteudo: ");
							            	int modIndex = Integer.parseInt(scanner.nextLine());
							            	
							            	if (modIndex >= 0 && modIndex < modulos.size())
							            	{
							            		System.out.println("Insira o texto do conteudo: ");
							            		String texto = scanner.nextLine();
							            		
							            		Conteudo conteudo = new Conteudo(texto);
							            		conteudo.formatarTexto();
							            		
							            		System.out.println("Deseja adicionar imagens? (sim/nao): ");
							            		String resp = scanner.nextLine();
							            		
							            		while (resp.equalsIgnoreCase("sim"))
							            		{
							            			System.out.println("Qual o caminho da imagem (pdf,etc): ");
							            			String img = scanner.nextLine();
							            			
							            			conteudo.adicionarImagem(img);
							            			
							            			System.out.println("Adicionar outra imagem? (sim/nao): ");
							            			resp = scanner.nextLine();
							            		}
							            		
							            		modulos.get(modIndex).adicionarConteudo(conteudo);
							            		System.out.println("O conteudo foi adicionado com sucesso!");
							            	}
							            	else
							            	{
							            		System.out.println("Indice invalido.");
							            	}
							            	break;
							            	
							            case "0":
							            	System.out.println(" --- Voltar ao Menu Principal --- ");
							            	
							            	voltar = true;
							            	break;
							            	
							            default:
							            	System.out.println("Opcao invalida");
							   }
							   
						   }
					   }
					   else
					   {
						   System.out.println("As credenciais do administrador sao invalidas.");
					   }
				   }
				   else
				   {
					   System.out.println("Opcao invalida.");
				   }
				   break;
			
			
		case "2":
			System.out.println("\n +++ Area do Aluno +++ ");
			System.out.println("1. Registar-me como Aluno");
			System.out.println("2. Fazer o Login como Aluno");
			System.out.println("Escolha uma opcao: ");
			//Ler a escolha do utilizador
			String escolhaAluno = scanner.nextLine();
			
			if (escolhaAluno.equals("1"))
			{
				//Para o aluno registar-se na plataforma
				try
				{
					System.out.println("Insira o nome do Aluno: ");
					String nomeAluno = scanner.nextLine();
					
					System.out.println("insira o email do Aluno: ");
					String emailAluno = scanner.nextLine();
					
					System.out.println("Insira a password do Aluno: ");
					String passAluno = scanner.nextLine();
					
					Aluno novoAluno = new Aluno(nomeAluno, emailAluno, passAluno);
					utilizadores.add(novoAluno);
					
					System.out.println("O Aluno foi registado com sucesso!");
				}
				catch (DadosInvalidosException e)
				{
					System.out.println("Erro no registo do Aluno: " + e.getMessage());
				}
			}
			else if (escolhaAluno.equals("2"))
			{
				//login do aluno na plataforma
				System.out.println("Insira o email do Aluno: ");
				String emailLogin = scanner.nextLine();
				
				System.out.println("Insira a password do Aluno: ");
				String passLogin = scanner.nextLine();
				
				//Utl alu, preenche as infor recebidas se tiver o aluno certo com email e pass
				Aluno alunoLogado = null; 
				for (Utilizador u : utilizadores)
				{
					//utl se alun, nao outro tipo 
					if (u instanceof Aluno && u.getEmail().equals(emailLogin) && u.getPassword().equals(passLogin))
					{
						//casting de objeto
						//trata-lo como aluno, para ter acesso aos metodos
						alunoLogado = (Aluno) u;
						break;
					}
				}
				
				//Quando existem ja as informacoes
				if (alunoLogado != null)
				{
					System.out.println("Bem-vindo, " + alunoLogado.getNome() + "!");
				}
				boolean voltarAluno = false;
				
				while (!voltarAluno)
				{
					System.out.println("\n +++ Menu do Aluno +++ ");
					System.out.println("1. Ver Modulos Disponiveis");
					System.out.println("2. Realizar um Quizz");
					//System.out.println("3. Concluir um Modulo");
					System.out.println("0. Voltar ao Menu Principal");
					System.out.println("Escolha uma opcao: ");
					//Ler opcao do utilizador
					String opAluno = scanner.nextLine();
					
					switch (opAluno)
					{
					   case "1":
						   System.out.println(" +++ Ver os Modulos Disponiveis +++ ");
						   for (Modulo m : modulos)
						   {
							   System.out.println(m);
						   }
						   break;
						   
					   case "2":
						   System.out.println(" +++ Realizar um Quizz +++ ");
						   if (modulos.isEmpty())
						   {
							   System.out.println("Nao ha modulos disponiveis.");
							   break;
						   }
						   
						   for (int i = 0; i < modulos.size(); i++)
						   {
							   System.out.println(i + ": " + modulos.get(i).getTitulo());
						   }
						   
						   System.out.println("Escolha o Modulo em pretende realizar o quizz: ");
						   int indiceQuizz = Integer.parseInt(scanner.nextLine());
						   
						   if (indiceQuizz >= 0 && indiceQuizz < modulos.size())
						   {
							   Modulo modSelecionado = modulos.get(indiceQuizz);
							   
							   Quizz q = modSelecionado.getQuizz();
							   
							   if (q == null || q.getPerguntas().isEmpty())
							   {
								   System.out.println("Este Modulo nao esta associado a um Quizz.");
								   break;
							   }
							   
							   //Criar uma resposta do quizz
							   RespostaQuizz rq = new RespostaQuizz("quizz" + indiceQuizz, "modulo" + indiceQuizz);
							   
							   for (Pergunta p : q.getPerguntas())
							   {
								   //enunciado da pergunta
								   System.out.println(p.getEnunciado());
								   
								   
								   ArrayList<String> alts = p.getAlternativas();
								   
								   //Mostra as alternativas, tranformando o indice em char (0 em 'A')
								   for (int i = 0; i < alts.size(); i++)
								   {
									   System.out.println((char) ('A' + i) + ": " + alts.get(i));
								   }
								   
								   //Guardar a resposta do utilizador
								   System.out.println("Qual e a tua resposta: ");
								   String resposta = scanner.nextLine();
								   
								   Resposta r = new Resposta(p, resposta);
								   rq.adicionarResposta(r);
							   }
							   
							   //O aluno recebera na lista de quizzes feitos o novo quizz com as respostas
							   alunoLogado.getRespostasQuizz().add(rq);
							   
							   float nota = q.calcularNota(rq.getRespostas());
							   System.out.println("A Nota obtida foi: " + nota + "valores");
						   }
						   else
						   {
							   System.out.println("O Modulo selecionado e invalido.");
						   }
						   break;
						   
					  /* case "3":
						   System.out.println(" +++ Concluir um Modulo +++ ");
						   for (int i = 0; i < modulos.size(); i++)
						   {
							   System.out.println(i + ": " + modulos.get(i).getTitulo());
						   }
						   
						   System.out.println("Escolha o Modulo que deseja marcar como Concluido: ");
						   int conclui = Integer.parseInt(scanner.nextLine());
						   
						   if (conclui >= 0 && conclui < modulos.size())
						   {
							   alunoLogado.concluirModulo(modulos.get(conclui));
						   }
						   else
						   {
							   System.out.println("O modulo e invalido.");
						   }
						   break; */
						   
					   case "0":
						   voltarAluno = true;
						   break;
						   
					   default:
						   System.out.println("A opcao e invalida.");
					}
				}
			}
			else
			{
				System.out.println("O Login falhou. Email ou password incorretas.");
			}
			break;
			
		case "0":
			System.out.println("Obrigado por utilizar a nossa Plataforma! ");
			System.out.println("Ate logo!");
			return;
			
		default:
			System.out.println("Opcao invalida. Tente novamente.");
		}
		
	   }
	}
}
