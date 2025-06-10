/**@author team 7
 * @version 0.1
 * 
 * Esta classe é adicional ao projeto para podermos implementar bem o registo e logim dinamico
 * 
 * Classe administrador que contem um novo menu para o administrador
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Administrador extends Utilizador
{

	/*
	 * Constroi um administrador com parametros herdados da classe utilizador
	 * */
	public Administrador(String nome, String email, String password, String tipo) throws DadosInvalidosException 
	{
		super(nome, email, password, tipo);
		
	}
	
	
	public void mostrarMenu(Gere gere)
	{
		Scanner scanner = new Scanner(System.in);
		int opcao;
		
		do
		{
			System.out.println("\n --- Menu do Administrador --- ");
	        System.out.println("1. Criar um Modulo");
	        System.out.println("2. Editar um Modulo");
	        System.out.println("3. Remover um Modulo");
	        System.out.println("4. Consultar Modulos");
	        System.out.println("5. Criar um Quizz para um Modulo");
	        System.out.println("6. Editar um Quizz");
	        System.out.println("7. Remover um Quizz");
	        System.out.println("8. Adicionar Conteudo a um Modulo");
	        System.out.println("9. Criar um Exame Final");
	        System.out.println("10. Editar um Exame Final");
	        System.out.println("11. Remover um Exame Final");
	        System.out.println("12. Gerar um Certificado");
	        System.out.println("13. Ver Lista de Utilizadores");
	        System.out.println("14. Remover ou Desativar um Utilizador");
	        System.out.println("15. Editar um Certificado");
	        System.out.println("16. Ver Historico de Certificados Gerados");
			System.out.println("0. Logout");
			
			System.out.println("Escolha uma opcao: ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao)
			{
			   case 1:
				   System.out.println(" --- Criar um Modulo --- ");

			       System.out.println("Qual o titulo do Modulo: ");
			       String titulo = scanner.nextLine();
			    	  
			       System.out.println("Qual a descricao do Modulo: ");
			       String descricao = scanner.nextLine();
			    	  
			       System.out.println("Qual a ordem do Modulo(insira um numero inteiro): ");
			       int ordem = Integer.parseInt(scanner.nextLine());
			    	  
			       System.out.println("Qual o objetivo do Modulo: ");
			       String objetivo = scanner.nextLine();
			       
			       if (titulo.isBlank() || descricao.isBlank() || objetivo.isBlank())
			       {
			    	   System.out.println("Erro: Nenhum campo pode estar vazio!");
			       }
			       else
			       {
			    	   //alteracao do case 1 no main criar modulo
			    	   Modulo novoModulo = new Modulo(titulo, descricao, ordem, objetivo);
			    	   gere.adicionarModulo(novoModulo);
			    	   System.out.println("O Modulo foi adicionado com sucesso!");
			       }
			    	  
                   break;

               case 2:
            	   System.out.println(" --- Editar um Modulo ---");
            	   //alterado do main
            	   ArrayList<Modulo> listaModulos = gere.getModulos();
            	   if (listaModulos.isEmpty())
            	   {
            		   System.out.println("Nao ha modulos disponiveis para editar.");
            		   break;
            	   }
            	   
            	   for (int i = 0; i < listaModulos.size(); i++)
            	   {
            		   System.out.println((i + 1) + ". " + listaModulos.get(i).getTitulo());
            	   }
            	   
            	   System.out.println("Escolha o modulo que pretende editar: ");
            	   int indexEditar = scanner.nextInt();
            	   scanner.nextLine();
            	   
            	   if (indexEditar < 1 || indexEditar > listaModulos.size())
            	   {
            		   System.out.println("Opcao invalida.");
            		   break;
            	   }
            	   
            	   Modulo moduloEditar = listaModulos.get(indexEditar - 1);
            	   
            	   System.out.println("Qual o novo titulo do Modulo: ");
	    		   String novoTitulo = scanner.nextLine();
	    		   
	    		   System.out.println("Qual a nova descricao do Modulo: ");
	    		   String novaDescricao = scanner.nextLine();
	    		   
	    		   System.out.println("Qual a nova Ordem do Modulo(numero inteiro): ");
	    		   int novaOrdem = scanner.nextInt();
	    		   
	    		   System.out.println("Qual o novo objetivo do Modulo: ");
	    		   String novoObjetivo = scanner.nextLine();
	    		   
	    		   if (novoTitulo.isBlank() || novaDescricao.isBlank() || novoObjetivo.isBlank())
	    		   {
	    			   System.out.println("Erro: Nenhum campo pode estar vazio.");
	    		   }
	    		   else
	    		   {
	    			   gere.editarModulo(moduloEditar, novoTitulo, novaDescricao, novaOrdem, novoObjetivo);
	    			   System.out.println("O Modulo foi atualizado com sucesso!");
	    		   }
                   break;

               case 3:
            	   System.out.println("\n --- Remover um Modulo --- ");
            	   //alteracao do main
            	   ArrayList<Modulo> modulos = gere.getModulos();
            	   for(int i = 0; i < modulos.size(); i++)
            	   {
            		   System.out.println((i + 1) + ". " + modulos.get(i).getTitulo());
            	   }
            	   
            	   System.out.println("Escolha o numero do modulo para remover: ");
            	   int idx = scanner.nextInt();
            	   scanner.nextLine();
            	   
            	   if (idx >= 1 && idx <= modulos.size())
            	   {
            		   System.out.println("Tem a certeza que deseja eliminar este modulo? (sim/nao): ");
            		   String confirm = scanner.nextLine();
            		   
            		   if (confirm.equalsIgnoreCase("sim"))
            		   {
            			   Modulo mod = modulos.get(idx - 1);
            			   gere.removerModulo(modulos, mod);
            			   System.out.println("O Modulo foi removido com sucesso!");
            		   }
            		   else
            		   {
            			   System.out.println("Remocao cancelada.");
            		   }
            	   }
            	   else
            	   {
            		   System.out.println("Indice invalido.");
            	   } 	   
                   break;

               case 4:
                   System.out.println("\n --- Modulos Existentes --- ");
                   //alteracao do main
                   for (Modulo m : gere.getModulos())
                   {
                	   System.out.println("Titulo: " + m.getTitulo());
                	   System.out.println("Descricao: " + m.getDescricao());
                	   System.out.println("Ordem: " + m.getOrdem());
                	   System.out.println("Objetivo: " + m.getObjetivo());
                	   System.out.println("=============================");
                   }
                   break;

               case 5:
            	   System.out.println(" --- Criar um Quizz para um Modulo --- ");
            	   //alteracao do main
            	   ArrayList<Modulo> lista = gere.getModulos();
            	   for (int i = 0; i < lista.size(); i++)
            	   {
            		   System.out.println((i + 1) + ". " + lista.get(i).getTitulo());
            	   }
            	   
            	   System.out.println("Escolha em qual modulo quer associar o quizz: ");
            	   int escolha = scanner.nextInt();
            	   scanner.nextLine();
            	   
            	   if (escolha >= 1 && escolha <= lista.size())
            	   {
            		   Quizz novoQuizz = new Quizz();
            		   while (novoQuizz.getPerguntas().size() < 20)
            		   {
            			   System.out.println("\nInsira o enunciado da pergunta: ");
            			   String enunciado = scanner.nextLine();
            			   ArrayList<String> alternativas = new ArrayList<>();
            			   
            			   for (int i = 1; i <= 4; i++)
            			   {
            				   System.out.println("Alternativa " + i + ": ");
                               alternativas.add(scanner.nextLine());
            			   }
            			   
            			   System.out.print("Resposta correta: ");
            			   String correta = scanner.nextLine();
            			   System.out.println("Justificativa: ");
            			   String justificativa = scanner.nextLine();
            			   
            			   Pergunta p = new Pergunta(enunciado, alternativas, correta, justificativa);
            			   novoQuizz.adicionarPergunta(p);
            			   
            			   System.out.print("Deseja adicionar outra pergunta? (sim/nao): ");
            			   String continuar = scanner.nextLine();
            			   if (!continuar.equalsIgnoreCase("sim"))
            			   {
            				   break;
            			   }  
            		   }
            		   gere.criarQuizz(lista.get(escolha - 1), novoQuizz);
            		   System.out.println("Quizz criado com sucesso!");
            	   }
            	   else
            	   {
            		   System.out.println("Indice invalido.");
            	   }
            	   
                   break;

               case 6:
            	   System.out.println(" --- Editar um Quizz --- ");
            	   System.out.println("Selecione um modulo para editar o quizz: ");
            	   ArrayList<Modulo> todosModulos = gere.getModulos();
            	   for (int i = 0; i < todosModulos.size(); i++)
            	   {
            		   System.out.println((i + 1) + ". " + todosModulos.get(i).getTitulo());
            	   }
            	   
            	   int escolhaQuizz = scanner.nextInt();
            	   scanner.nextLine();
            	   if (escolhaQuizz < 1 || escolhaQuizz > todosModulos.size())
            	   {
            		   System.out.println("Indice invalido.");
            		   break;
            	   }
            	   
            	   Modulo moduloSelecionado = todosModulos.get(escolhaQuizz - 1);
            	   Quizz quizzSelecionado = moduloSelecionado.getQuizz();
            	   if (quizzSelecionado == null)
            	   {
            		   System.out.println("Este modulo ainda nao tem um quizz.");
            		   break;
            	   }
            	   
            	   ArrayList<Pergunta> perguntas = quizzSelecionado.getPerguntas();
            	   for (int i = 0; i < perguntas.size(); i++)
            	   {
            		   System.out.println((i + 1) + ". " + perguntas.get(i).getEnunciado());
            	   }
            	   
            	   System.out.print("Qual a pergunta que deseja editar: ");
            	   int indicePergunta = scanner.nextInt();
            	   scanner.nextLine();
            	   if (indicePergunta < 1 || indicePergunta > perguntas.size())
            	   {
            		   System.out.println("Indice invalido");
            		   break;
            	   }
            	   
            	   System.out.println("Novo enunciado da pergunta: ");
            	   String novoEnunciado = scanner.nextLine();
            	   
            	   System.out.println("Nova resposta correta: ");
            	   String novaResposta = scanner.nextLine();
            	   
            	   System.out.println("Nova justificativa: ");
            	   String novaJustificativa = scanner.nextLine();
            	   
            	   ArrayList<String> novasAlternativas = new ArrayList<>();
            	   for (int i = 1; i <= 4; i++)
            	   {
            		   System.out.print("Alternativa " + i + ": ");
            		   novasAlternativas.add(scanner.nextLine());
            	   }
            	   
            	   Pergunta novaPergunta = new Pergunta(novoEnunciado, novasAlternativas, novaResposta, novaJustificativa);
            	   gere.editarQuizz(quizzSelecionado, indicePergunta - 1, novaPergunta);
            	   System.out.println("A Pergunta foi atualizada com sucesso!");
                   break;

               case 7:
            	   System.out.println(" --- Remover um Quizz de um modulo --- ");
            	   //alteracao do main
            	   ArrayList<Modulo> modList = gere.getModulos();
            	   for (int i = 0; i < modList.size(); i++)
            	   {
            		   System.out.println((i + 1) + ". " + modList.get(i).getTitulo());
            	   }
            	   
            	   System.out.println("Escolha um modulo para remover um quizz: ");
            	   int n = scanner.nextInt();
            	   scanner.nextLine();
            	   
            	   if (n >= 1 && n <= modList.size())
            	   {
            		   System.out.println("Tem a certeza que deseja remover o quizz deste modulo? (sim/nao): ");
            		   String conf = scanner.nextLine();
            		   if (conf.equalsIgnoreCase("sim"))
            		   {
            			   gere.removerQuizz(modList.get(n - 1));
            			   System.out.println("O Quizz foi removido com sucesso.");
            		   }
            		   else
            		   {
            			   System.out.println("Operacao cancelada.");
            		   }
            	   }
            	   else
            	   {
            		   System.out.println("Indice invalido.");
            	   }
                   break;

               case 8:
            	   System.out.println(" --- Adicionar Conteudo a um Modulo --- ");
            	   ArrayList<Modulo> moduloLista = gere.getModulos();
            	   
            	   if (moduloLista.isEmpty())
            	   {
            		   System.out.println("Nao ha modulos disponiveis.");
            		   break;
            	   }
            	   
            	   for (int i = 0; i < moduloLista.size(); i++)
            	   {
            		   System.out.println((i + 1) + ". " + moduloLista.get(i).getTitulo());
            	   }
            	   
            	   System.out.print("Escolha um modulo para adicionar conteudo: ");
            	   int indiceModulo = scanner.nextInt();
            	   scanner.nextLine();
            	   
            	   if (indiceModulo < 1 || indiceModulo > moduloLista.size())
            	   {
            		   System.out.println("Indice invalido.");
            		   break;
            	   }
            	   
            	   Modulo modulo = moduloLista.get(indiceModulo - 1);
            	   boolean continuar = true;
            	   
            	   while(continuar)
            	   {
            		   System.out.println("\nQue tipo de conteudo deseja adicionar?");
            		   System.out.println("1. Texto");
            		   System.out.println("2. Imagem (Caminho da imagem)");
            		   System.out.println("0. Terminar");
            		   
            		   int tipo = scanner.nextInt();
            		   scanner.nextLine();
            		   
            		   if (tipo == 0)
            		   {
            			   continuar = false;
            			   break;
            		   }
            		   
            		   Conteudo conteudo = new Conteudo();
            		   
            		   switch (tipo)
            		   {
            		      case 1:
            		    	  System.out.println("Insira o texto a adicionar: ");
            		    	  String texto = scanner.nextLine();
            		    	  if (texto.isBlank())
            		    	  {
            		    		  System.out.println("O texto nao pode estar vazio!");
            		    		  break;
            		    	  }
            		    	  
            		    	  conteudo.setTexto(texto);
			            	  conteudo.formatarTexto();
            		    	  modulo.adicionarConteudo(conteudo);
            		    	  System.out.println("Texto adicionado com sucesso.");
            		    	  break;
            		    	  
            		      case 2:
            		    	  System.out.println("Insira o caminho da imagem: ");
            		    	  String imagem = scanner.nextLine();
            		    	  if (imagem.isBlank())
            		    	  {
            		    		  System.out.println("O caminho da imagem nao pode estar vazio!");
            		    		  break;
            		    	  }
            		    	  
            		    	  conteudo.adicionarImagem(imagem);
            		    	  modulo.adicionarConteudo(conteudo);
            		    	  System.out.println("A Imagem foi adicionada com sucesso.");
            		    	  break;
            		    	  
            		      default:
            		    	  System.out.println("Tipo invalido."); 
            		   }
            		   
            	   }
            	   
            	   System.out.println("Conteudo adicionado com sucesso.");
                   break;
			
			   case 9:
				   if (gere.getModulos().isEmpty()) {
					    Modulo teste = new Modulo("Teste", "Descricao de teste", 1, "Aprender o sistema");
					    Quizz quizz = new Quizz();

					    ArrayList<String> alternativas = new ArrayList<>();
					    alternativas.add("A");
					    alternativas.add("B");
					    alternativas.add("C");
					    alternativas.add("D");

					    Pergunta pergunta = new Pergunta("Qual é a letra correta?", alternativas, "A", "Porque sim.");
					    quizz.adicionarPergunta(pergunta);
					    teste.setQuizz(quizz);

					    gere.adicionarModulo(teste);
					    System.out.println("⚠️ Módulo de teste com quizz criado automaticamente.");
					}

				   gere.criarExameFinal();
				   break;
				   
			   case 10:
				   System.out.println("\n1. Adicionar perguntas ao Exame Final");
				   System.out.println("2. Ver perguntas do Exame Final");
				   System.out.println("3. Editar Nota Minima");
				   System.out.println("Escolha a sub-opcao: ");
				   int sub = scanner.nextInt();
				   scanner.nextLine();
				   
				   switch (sub)
				   {
				      case 1:
				    	  gere.adicionarPerguntaAoExame();
				    	  break;
				    	  
				      case 2:
				    	  gere.listarPerguntasDoExame();
				    	  break;
				    	  
				      case 3:
				    	  gere.editarNotaMinimaExame();
				    	  break;
				    	  
				      default:
				    	  System.out.println("Sub-opcao invalida.");
				   }
				   break;
				   
			   case 11:
				   gere.removerExameFinal();
				   break;
				   
			   case 12:
				   System.out.println("Insira o email do aluno: ");
				   String email = scanner.nextLine();
				   
				   Utilizador u = gere.procurarUtilizadorPorEmail(email);
				   if (u instanceof Aluno aluno)
				   {
					   gere.gerarCertificado(aluno);
				   }
				   else
				   {
					   System.out.println("O Utilizador nao foi encontrado ou nao e um aluno.");
				   }
				   break;
				   
			   case 13:
				   gere.verListaDeUtilizadores();
				   break;
				   
			   case 14:
				   System.out.println("\n --- Remover ou Desativar um Utilizador --- ");
				   gere.verListaDeUtilizadores();
				   
				   System.out.println("Insira o email do utilizador a ser alterado: ");
				   String emailAlvo = scanner.nextLine();
				   Utilizador alvo = gere.procurarUtilizadorPorEmail(emailAlvo);
				   
				   if (alvo == null)
				   {
					   System.out.println("Utilizador nao encontrado.");
				   }
				   else
				   {
					   System.out.println("1. Desativar \n2. Remover \n Escolha a opcao: ");
					   int acao = scanner.nextInt();
					   scanner.nextLine();
					   
					   if (acao == 1)
					   {
						   alvo.setAtivo(false);
						   System.out.println("Utilizador desativado com sucesso.");
					   }
					   else if (acao == 2)
					   {
						   System.out.println("Tem a certeza que deseja remover o Utilizador? (sim/nao): ");
						   String confirmacao = scanner.nextLine();
						   
						   if (confirmacao.equalsIgnoreCase("sim"))
						   {
							   gere.removerUtilizador(emailAlvo);
							   
							   System.out.println("O Utilizador foi removido com sucesso.");
						   }
						   else
						   {
							   System.out.println("Opcao cancelada.");
						   }
					   }
					   else 
					   {
						   System.out.println("Opcao invalida.");
					   }
				   }
				   break;
				   
			   case 15:
				   System.out.println("\n --- Editar um Certificado --- ");
				   gere.editarCertificado(scanner);
				   break;
				   
			   case 16:
				   System.out.println("\n --- Historico de Certificados Gerados --- ");
				   gere.verHistoricoCertificados();
				   break;
				   
			   case 0:
				   System.out.println("Logout efetuado com sucesso.");
				   break;
				   
			   default:
				   System.out.println("Opcao invalida. Tente novamente.");
			}
			
		} while (opcao != 0);
		
	}
   
}
