

/**@author team 7
 * @version 0.1
 * Esta classe cria um quizz para um modulo
 * 
 * Apresenta a opcao de adicionar e remover uma pergunta, assim como calcular a nota de um aluno no quizz feito
 * 
 */

import java.util.ArrayList;

public class Quizz 
{
   private Modulo modulo; 
   private ArrayList<Pergunta> perguntas;
   
   /*
    * Constrói um quizz com argumento
    */
   public Quizz(Modulo modulo)
   {
	   this.modulo = modulo;
	   this.perguntas = new ArrayList<>();
   }
   
   /*
    * Constrói um quizz sem argumento
    */
   public Quizz()
   {
	   this.perguntas = new ArrayList<>();
   }
   
   public Modulo getModulo() 
   {
	   return modulo;
   }

   public void setModulo(Modulo modulo) 
   {
	   this.modulo = modulo;
   }

/*
    * Metodo para adicionar uma pergunta a um quizz
    */
   public void adicionarPergunta(Pergunta p)
   {
	   perguntas.add(p);
   }
   
   /*
    * Metodo para remover uma pergunta de um quizz
    */
   public void removerPergunta(Pergunta p)
   {
	   perguntas.remove(p);
   }
   
   /*
    * Metodo para a nota de um aluno em um quizz com base nas respostas dadas
    */
   public float calcularNota(ArrayList<Resposta> respostas)
   {
	   //contar quantas o aluno acertou
	   int corretas = 0;
	   
	   //percorrer as respostas dadas pelo aluno
	   for (int i = 0; i < respostas.size(); i++)
	   {
		   //pega a resposta numero do aluno
		   Resposta r = respostas.get(i);
		   
		   //pega a pergunta na qual esta resposta pertence
		   Pergunta p = r.getPergunta();
		   
		   //se a resposta escolhida for igual a resposta correta da pergunta
		   if (p.getRespostaCorreta().equalsIgnoreCase(r.getAlternativaEscolhida()))
		   {
			   //aumenta o contador de acertos
			   corretas++;
		   }
	   }
	   
	   // se não houver perguntas
	   if (perguntas.size() == 0)
	   {
		   return 0;
	   }
	   
	   // calculo da nota
	   //se houver 4 perguntas e 3 certas seria (3 * a nota maxima 20) / 4 = 15 valores
	   return (corretas * 20.0f) / perguntas.size();
	   
	   //o metodo retorna a nota em percentagem (de 0 a 20)
   }

   public ArrayList<Pergunta> getPerguntas() 
   {
	   return perguntas;
   }

   @Override
   public String toString() 
   {
	   return "Quizz [perguntas = " + perguntas.size() + "]";
   }
   
   
}
