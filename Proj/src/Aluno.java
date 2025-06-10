

/**@author team 7
 * @version 0.1
 * Esta classe representa um aluno registado na plataforma
 * 
 * Apresenta herança com a classe Utilizador, e alguns metodos em
 * relação aos modulos inscritos
 */

import java.util.ArrayList;

import java.util.Scanner;

//Classe aluno (um utili)

public class Aluno extends Utilizador 
{
   private ArrayList<ModuloFrequentado> modulosFrequentados;
   private ArrayList<RespostaQuizz> respostasQuizz;
   //add
   private double notaFinalExame = -1; // -1 porque aindao nao foi feito
   
   /*
    * Constrói um aluno com parametros e cria tambem um utlizador usando o construtor da superclasse 
    */
   public Aluno(String nome, String email, String password) throws DadosInvalidosException 
   {
	   //indicar o valor do tipo diretamente como "aluno"
	   super(nome, email, password, "aluno");
	   this.modulosFrequentados = new ArrayList<>();
	   this.respostasQuizz = new ArrayList<>();
   }
   
   public double getNotaFinalExame() 
   {
	   return notaFinalExame;
   }

   public void setNotaFinalExame(double notaFinalExame) 
   {
	   this.notaFinalExame = notaFinalExame;
   }


//add
   public void adicionarModuloFrequentado(ModuloFrequentado mf)
   {
	   modulosFrequentados.add(mf);
   }
   
   //add
   public void adicionarResposaQuizz(RespostaQuizz resposta)
   {
	   respostasQuizz.add(resposta);
   }
   
   //add
   public void listarModulosComEstado()
   {
	   System.out.println("\n +++ Modulos Disponiveis --- ");
	   for (ModuloFrequentado mf : modulosFrequentados)
	   {
           System.out.println("Modulo: " + mf.getModulo().getTitulo() + " | Estado: " + mf.getEstado());
	   }
   }
   
   //add
   public void atualizarEstadoDoModulo(Modulo modulo, double notaQuizz, double notaExame)
   {
	   for (ModuloFrequentado mf : modulosFrequentados)
	   {
		   if (mf.getIdModulo().equals(modulo))
		   {
			   mf.setNotaQuizz(notaQuizz);
			   mf.setNotaExame(notaExame);
			   mf.atualizarEstado();
			   break;
		   }
	   }
   }
   
   //add
   public void verNotaDoQuizz()
   {
	   if (respostasQuizz.isEmpty())
	   {
		   System.out.println("Ainda nao realizou nenhum quizz.");
		   return;
	   }
	   
	   System.out.println("\n +++ Notas dos Quizzes +++ ");
	   for (RespostaQuizz rq : respostasQuizz)
	   {
		   String nomeModulo = rq.getQuizz().getModulo().getTitulo();
		   System.out.printf("Modulo: %s | %.2f valores\n", nomeModulo, rq.getNota());
	   }
   }
   
   //add
   public void consultarHistoricoNotas()
   {
	   System.out.println("\n +++ Historico de Notas +++ ");
	   for (ModuloFrequentado mf : modulosFrequentados)
	   {
		   String nome = mf.getModulo().getTitulo();
		   String estado = mf.getEstado().toString();
		   double notaQuizz = mf.getNotaQuizz();
		   double notaExame = mf.getNotaExame();
		   
		   System.out.printf("Modulo: %s | Estado: %s | Nota Quizz: %.2f | Nota Exame: %.2f\n", 
				              nome, estado, notaQuizz, notaExame);
	   }
   }
   
   //add
   public void realizarExameFinal(Gere gere)
   {
	   ExameFinal exame = gere.getExameFinal();
	   if (!exame.isAtivo())
	   {
		   System.out.println("O Exame final nao esta disponivel neste momento.");
		   return; 
	   }
	   
	   //funcao para verificar se todos os modulos estao concluidos
	   boolean todosConcluidos = true;
	   for (ModuloFrequentado mf : modulosFrequentados)
	   {
		   if (!mf.getEstado().equals(EstadoModulo.CONCLUIDO))
		   {
			   todosConcluidos = false;
			   break;
		   }
	   }
	   
	   if (!todosConcluidos)
	   {
		   System.out.println("So e possivel realizar o exame final apos concluir todos os modulos.");
		   return;
	   }
	   
	   Scanner scanner = new Scanner(System.in);
	   float nota = 0;
	   int total = exame.getPerguntas().size();
	   
	   for (Pergunta p : exame.getPerguntas())
	   {
		   System.out.println("\n" + p.getEnunciado());
		   ArrayList<String> alternativas = p.getAlternativas();
		   
		   for (int i = 0; i < alternativas.size(); i++)
		   {
			   System.out.println((i + 1) + ". " + alternativas.get(i));
		   }
		   
		   System.out.println("Qual a tua resposta: ");
		   int resposta = scanner.nextInt();
		   scanner.nextLine();
		   String respostaDada = alternativas.get(resposta - 1);
		   if (respostaDada.equalsIgnoreCase(p.getRespostaCorreta()))
		   {
			   nota++;
		   }
	   }
	   
	   float notaFinal = (nota / total) * 20;
	   setNotaFinalExame(notaFinal);
	   System.out.printf("\nNota Final do exame: %.2f valores\n", notaFinal);
	   
	   //funcao para atualizar o estado dos modulos se aprovado
	   if (notaFinal >= exame.getNotaMinima())
	   {
		   for (ModuloFrequentado mf : modulosFrequentados)
		   {
			   mf.setNotaExame(notaFinal);
			   mf.atualizarEstado();
		   }
		   
		   System.out.println("Parabens! Os Modulos foram marcados como Concluidos.");
	   }
	   else
	   {
		   System.out.println("Infelizmente a Nota e insuficiente para a aprovacao final.");
	   }
   }

   public ArrayList<ModuloFrequentado> getModulosFrequentados() 
   {
	   return modulosFrequentados;
   }

   public ArrayList<RespostaQuizz> getRespostasQuizz() 
   {
	   return respostasQuizz;
   }

   public void setModulosFrequentados(ArrayList<ModuloFrequentado> modulosFrequentados) 
   {
	   this.modulosFrequentados = modulosFrequentados;
   }

   public void setRespostasQuizz(ArrayList<RespostaQuizz> respostasQuizz) 
   {
	   this.respostasQuizz = respostasQuizz;
   }
   
   
   
   /*
    * Criação do metodo que o aluno conclui o modulo
    */
   public void concluirModulo(Modulo modulo)
   {
	   System.out.println("Modulo '" + modulo.getTitulo() + "' concluido por " + getNome());
   }
   
   /*
    * Criação do metodo que o aluno realiza um quizz
    */
   public float realizarQuizz(Quizz quizz)
   {
	   //add
	   Scanner scanner = new Scanner(System.in);
	   float nota = 0;
	   
	   for (Pergunta p : quizz.getPerguntas())
	   {
		   System.out.println("\n" + p.getEnunciado());
		   for (int i = 0; i < p.getAlternativas().size(); i++)
		   {
			   System.out.println((i + 1) + ". " + p.getAlternativas().get(i));
		   }
		   
		   System.out.print("Qual a tua resposta: ");
		   int resposta = scanner.nextInt();
		   String respostaDada = p.getAlternativas().get(resposta - 1); 
		   
		   if (respostaDada.equalsIgnoreCase(p.getRespostaCorreta()))
		   {
			   nota = nota + 1;
		   }
	   }
	   return (nota / quizz.getPerguntas().size()) * 20;
	   /*System.out.println(getNome() + " esta a realizar o quizz: " + quizz.toString());
	   //Apenas a simulação da realização de um quizz.
	   //Ainda não se calcula a nota.
	   //A nota calcular-se-ha quando tivermos ligação das classes Resposta, RespostaQuizz com esta.
	   //Teremos quizz.calcularNota(respostasDadas);
	   return 20;*/
   }
   
   //add
   public void realizarQuizz(Gere gere)
   {
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("\n +++ Realizar Quizz +++ ");
	   
	   for (int i = 0; i < modulosFrequentados.size(); i++)
	   {
		   System.out.println((i + 1) + ". " + modulosFrequentados.get(i).getModulo().getTitulo());
	   }
	   
	   System.out.println("Escolha um Modulo: ");
	   int escolha = scanner.nextInt();
	   scanner.nextLine();
	   
	   if (escolha < 1 || escolha > modulosFrequentados.size())
	   {
		   System.out.println("Opcao invalida.");
		   return;
	   }
	   
	   ModuloFrequentado mf = modulosFrequentados.get(escolha - 1);
	   Quizz quizz = mf.getModulo().getQuizz();
	   
	   if (quizz == null || quizz.getPerguntas().isEmpty())
	   {
		   System.out.println("Este modulo nao tem um quizz disponivel.");
		   return;
	   }
	   
	   float notaFinal = realizarQuizz(quizz);
	   System.out.printf("\nModulo: %s | Nota Final: %.2f valores\n", mf.getModulo().getTitulo(), notaFinal);
	   
	   RespostaQuizz rq = new RespostaQuizz(quizz, notaFinal);
	   respostasQuizz.add(rq);
	   mf.setNotaQuizz(notaFinal);
	   mf.atualizarEstado();
   }
   
   //add
   public void mostrarMenu(Gere gere)
   {
	   Scanner scanner = new Scanner(System.in);
	   int opcao;
	   
	   do
	   {
		   System.out.println(" +++ Menu do Aluno +++ ");
		   System.out.println("1. Listar os Modulos Disponiveis");
		   System.out.println("2. Realizar um Quizz");
		   System.out.println("3. Ver Nota de um Quizz");
		   System.out.println("4. Fazer um Exame Final");
		   System.out.println("5. Consultar o Historico de Notas");
		   System.out.println("0. Logout");
		   System.out.println("Escolha uma opcao: ");
		   opcao = scanner.nextInt();
		   scanner.nextLine();
		   
		   switch (opcao)
		   {
		      case 1: 
		    	  listarModulosComEstado();
		    	  break;
		    	  
		      case 2:
		    	  realizarQuizz(gere);
		    	  break;
		    	  
		      case 3:
		    	  verNotaDoQuizz();
		    	  break;
		    	  
		      case 4:
		    	  realizarExameFinal(gere);
		    	  break;
		    	  
		      case 5:
		    	  consultarHistoricoNotas();
		    	  break;
		    	  
		      case 0:
		    	  System.out.println("Logout efetuado com sucesso.");
		    	  break;
		    	  
		      default:
		    	  System.out.println("Opcao invalida. Tente novamente.");
		   }
		   
	   } while (opcao != 0);
	   
   }

   @Override
   public String toString() 
   {
	   return "Aluno [toString() = " + super.toString() + "]";
   }
   
   
}
