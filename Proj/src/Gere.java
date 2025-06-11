

/**@author team 7
 * @version final
 * Esta classe é a que gere a plataforma
 * 
 * Ela pode criar, editar e remover modulos e quizzes.
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Classe atualizada, adicionada o costrutor, o atributo, e dois metodos
public class Gere 
{
	//add
	private ArrayList<Modulo> modulos;
	private ExameFinal exameFinal;
	private ArrayList<Utilizador> utilizadores;
	
	//constroi um gere vazio add
	public Gere()
	{
		modulos = new ArrayList<>();
		exameFinal = new ExameFinal();
		utilizadores = new ArrayList<>();
	}
	
	//add
	public ExameFinal getExameFinal() 
	{
		return exameFinal;
	}
	
	//add
	public void criarExameFinal()
	{
		Scanner sc = new Scanner(System.in);
		exameFinal = new ExameFinal();
		
        System.out.print("Defina a nota minima para aprovacao (0 a 20): ");
        int nota = sc.nextInt();
        sc.nextLine();
        
        exameFinal.setNotaMinima(nota);
        exameFinal.ativar();
        System.out.println("Nota minima definida: " + nota + " valores");
        
        System.out.println();
        System.out.println("\nDeseja adicionar perguntas dos quizzer existentes? (sim/nao): ");
        String resposta = sc.nextLine().trim();
        
        if (resposta.equalsIgnoreCase("sim"))
        {
        	for (Modulo m : modulos)
        	{
        		Quizz q = m.getQuizz();
        		if (q != null && !q.getPerguntas().isEmpty())
        		{
        			System.out.println("\n --- Perguntas do modulo: " + m.getTitulo());
        			ArrayList<Pergunta> perguntas = q.getPerguntas();
        			
        			while (true)
        			{
        				for (int i = 0; i < perguntas.size(); i++)
            			{
            				System.out.println((i + 1) + ". " + perguntas.get(i).getEnunciado());
            			}
            			
        				 System.out.print("Escolha o numero da pergunta para adicionar (ou 0 para parar este modulo): ");
            			int indice = sc.nextInt();
            			sc.nextLine();
            			
            			if (indice == 0)
            			{
            				break;
            			}
            			
            			if (indice > 0 && indice <= perguntas.size())
            			{
            				exameFinal.adicionarPergunta(perguntas.get(indice - 1));
            				System.out.println("Pergunta adicionada ao exame final.");
            			}
            			else
            			{
            				System.out.println("Indice invalido. Tente novamente.");
            			}
        			}
        			
        		}
        	}
        }
        
        System.out.println("\n O Exame Final foi criado com sucesso!");
        System.out.println("Total de perguntas no exame: " + exameFinal.getPerguntas().size());
	}
	
	//add
	public void adicionarPerguntaAoExame()
	{
		Scanner sc = new Scanner(System.in);
		
		if (modulos.isEmpty())
		{
			System.out.println("Nao existem modulos para selecionar perguntas.");
			return;
		}
		
		System.out.println("Selecione um modulo para escolher perguntas:  ");
		for (int i = 0; i < modulos.size(); i++)
		{
			System.out.println((i + 1) + ". " + modulos.get(i).getTitulo());
		}
		
		int escolha = sc.nextInt();
		sc.nextLine();
		
		if (escolha < 1 || escolha > modulos.size())
		{
			System.out.println("Escolha invalida.");
			return;
		}
		
		Modulo escolhido = modulos.get(escolha - 1);
		ArrayList<Pergunta> perguntas = escolhido.getQuizz().getPerguntas();
		
		if (perguntas.isEmpty())
		{
			System.out.println("Este modulo nao tem perguntas disponiveis.");
			return;
		}
		
		System.out.println("Escolha a pergunta a adicionar: ");
		for (int i = 0; i < perguntas.size(); i++)
		{
			System.out.println((i + 1) + ". " + perguntas.get(i).getEnunciado());
		}
		
		int pIndex = sc.nextInt();
		sc.nextLine();
		
		if (pIndex < 1 || pIndex > perguntas.size())
		{
			System.out.println("Indice invalido.");
			return;
		}
		
		exameFinal.adicionarPergunta(perguntas.get(pIndex - 1));
		System.out.println("Pergunta adicionada ao exame final.");
	}
	
	//add
	public void listarPerguntasDoExame()
	{
		exameFinal.listarPerguntas();
	}
	
	//add
	public void editarNotaMinimaExame()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nova nota minima (0 a 20): ");
		
		int novaNota = sc.nextInt();
		exameFinal.setNotaMinima(novaNota);
		
		System.out.println("Nota minima atualizada com scesso.");
	}
	
	//add
	public void removerExameFinal()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Tem a certeza que deseja remover o exame final? (sim/nao): ");
		String confirmacao = sc.nextLine();
		
		if (confirmacao.equals("sim"))
		{
			exameFinal = new ExameFinal();
			exameFinal.desativar();
			System.out.println("Exame final removido com sucesso.");
		}
		else
		{
			System.out.println("Operacao cancelada.");
		}
	}
	
	//add
	public void verListaDeUtilizadores()
	{
		System.out.println("\n +++ Lista de Utilizadores +++ ");
		for (Utilizador u : utilizadores)
		{
			String tipo = u instanceof Aluno ? "Aluno" : "Administrador";
			System.out.println("Nome: " + u.getNome());
			System.out.println("Email: " + u.getEmail());
			System.out.println("Tipo: " + tipo);
			
			if (u instanceof Aluno aluno)
			{
				int concluidos = 0;
				int total = aluno.getModulosFrequentados().size();
				for(ModuloFrequentado mf : aluno.getModulosFrequentados())
				{
					if (mf.getEstado().equals(EstadoModulo.CONCLUIDO))
					{
						concluidos++;
					}
				}
				
				System.out.println("Progresso: " + concluidos + "/" + total + " modulos concluidos");
			}
			
			System.out.println("--------------------------------------------------");
		}
	}
	
	//add
	public void gerarCertificado(Aluno aluno)
	{
		int concluidos = 0;
		for (ModuloFrequentado mf : aluno.getModulosFrequentados())
		{
			if (mf.getEstado().equals(EstadoModulo.CONCLUIDO))
			{
				concluidos++;
			}
		}
		
		if (aluno.getModulosFrequentados().isEmpty())
		{
			System.out.println("O aluno ainda nao possui modulos associados.");
			return;
		}
		
		if (concluidos != aluno.getModulosFrequentados().size())
		{
			System.out.println("O aluno ainda nao concluiu todos os modulos.");
			return;
		}
		
		if (aluno.getNotaFinalExame() < 10)
		{
			System.out.println("O aluno nao obteve o aproveitamento minimo no exame final.");
			return;
		}
		
		//Simulacao do certificado 
		System.out.println("\n================================================");
		System.out.println("            CERTIFICADO DE PARTICIPACAO");
		System.out.println("================================================ ");
		System.out.println("Nome do participante: " + aluno.getNome());
		System.out.println("Curso: Curso de Sustentabilidade sobre os ODS");
		String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Data de emissao: " + data);
		System.out.println("Assinatura digital: [Sistema E-Learning SI/POO]");
		System.out.println("\n================================================");
	}
	
	//add
	public void editarCertificado(Scanner scanner)
	{
		System.out.print("Insira o email do aluno: ");
		String email = scanner.nextLine();
		Utilizador u = procurarUtilizadorPorEmail(email);
		
		if (u == null || !(u instanceof Aluno aluno))
		{
			System.out.println("Aluno nao encontrado.");
			return;
		}
		
		System.out.print("Insira o novo nome do aluno (enter para manter): ");
		String novoNome = scanner.nextLine();
		if (!novoNome.isBlank()) aluno.setNome(novoNome);
		
		System.out.print("Insira a nova data de emissao (dd/MM/yyyy) (enter para manter hoje): ");
		String novaData = scanner.nextLine();
		String data = novaData.isBlank() ? LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : novaData;
		
		System.out.println("Insira uma nova mensagem ou curso (enter para manter): ");
		String novaMsg = scanner.nextLine();
		String curso = novaMsg.isBlank() ? "Curso de Sustentabilidade sobre os ODS" : novaMsg;
		
		System.out.println("\n============ CERTIFICADO ATUALIZADO =============");
		System.out.println("Nome do participante: " + aluno.getNome());
		System.out.println("Curso: " + curso);
		System.out.println("Data da emissao: " + data);
		System.out.println("Assinatura digital: [Sistema E-Learning SI/POO]");
		System.out.println("===================================================");
		
	}
	
	//add
	public void verHistoricoCertificados()
	{
		System.out.println("\n ==== Historico de Certificados Gerados === ");
		
		// Simulacao de historico - no futuro poder ligar a um arraylist<certificado> se quiseremos guardar todos
		
		boolean encontrouCertificado = false;
		
		for (Utilizador u : utilizadores)
		{
			if (u instanceof Aluno aluno)
			{
				int concluidos = 0;
				for (ModuloFrequentado mf : aluno.getModulosFrequentados())
				{
					if (mf.getEstado().equals(EstadoModulo.CONCLUIDO))
					{
						concluidos++;
					}
				}
				
				if (!aluno.getModulosFrequentados().isEmpty() && concluidos == aluno.getModulosFrequentados().size() && aluno.getNotaFinalExame() >= 10)
				{
					String  data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					System.out.println("Aluno: " + aluno.getNome());
					System.out.println("Email: " + aluno.getEmail());
					System.out.println("Data de Emissao: " + data);
					System.out.println("Nota Final: " + aluno.getNotaFinalExame() + " valores");
					System.out.println("=======================================");
					
					encontrouCertificado = true;
				}
			}
		}
		
		if (!encontrouCertificado)
		{
			System.out.println("Nenhum certificado foi gerado ate o momento.");
		}
	}
	
	
	//add
	public void adicionarModulo(Modulo m)
	{
		modulos.add(m);
	}
	
	//add
	public ArrayList<Modulo> getModulos()
	{
		return modulos;
	}
	
	//add
	public void adicionarUtilizador(Utilizador u)
	{
		utilizadores.add(u);
	}
	
	//add
	 public ArrayList<Utilizador> getUtilizadores() 
	 {
	    return utilizadores;
	 }

	//registo de utilizador add
	public Utilizador autenticar(String email, String password)
	{
		for(Utilizador u : utilizadores)
		{
			if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password))
			{
				return u;
			}
		}
		return null;
	}
	
	//add
	public Utilizador procurarUtilizadorPorEmail(String email)
	{
		for (Utilizador u : utilizadores)
		{
			if (u.getEmail().equalsIgnoreCase(email))
			{
				return u;
			}
		}
		return null;
	}
	
	//add
	public void removerUtilizador(String email)
	{
		utilizadores.removeIf(u -> u.getEmail().equalsIgnoreCase(email));
	}
	

   /*
    * Metodo para criar um modulo
    */
   public void criarModulo(ArrayList<Modulo> lista, Modulo m)
   {
	   lista.add(m);
   }
   
   /*
    * Metodo para editar um modulo
    */
   public void editarModulo(Modulo m, String titulo, String descricao, int ordem, String objetivo)
   {
	   m.setTitulo(titulo);
	   m.setDescricao(descricao);
	   m.setOrdem(ordem);
	   m.setObjetivo(objetivo);
   }
   
   /*
    * Metodo para remover um modulo
    */
   public void removerModulo(ArrayList<Modulo> lista, Modulo m)
   {
	   lista.remove(m);
   }
   
   /*
    * Metodo para criar um quizz
    */
   public void criarQuizz(Modulo modulo, Quizz q)
   {
	   modulo.setQuizz(q);
   }
   
   /*
    * Metodo para editar um quizz
    */
   public void editarQuizz(Quizz q, int index, Pergunta novapergunta)
   {
	   //aterar um elemento numa posicao especifica
	   q.getPerguntas().set(index, novapergunta);
   }
   
   /*
    * Metodo para remover um quizz
    */
   public void removerQuizz(Modulo modulo)
   {
	   modulo.setQuizz(null);
   }
   
   /*
    * Metodo para consultar os modulos existentes
    */
   public ArrayList<Modulo> consultarModulos(ArrayList<Modulo> lista)
   {
	   return lista;
   }

   @Override
   public String toString() 
   {
	   return "Gere: Opcoes administrativas disponiveis";
   }
   
   
}
