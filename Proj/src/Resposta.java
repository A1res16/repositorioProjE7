

/**@author team 7
 * @version 0.1
 * Esta classe guarda a resposta dada pelo aluno em um quizz 
 * 
 * Apresenta atributos e modificadores
 */
public class Resposta 
{
   private Pergunta pergunta;
   private String alternativaEscolhida;
   
   /*
    * Constrói uma resposta com parametros
    */
   public Resposta(Pergunta pergunta, String alternativaEscolhida) 
   {
		this.pergunta = pergunta;
		this.alternativaEscolhida = alternativaEscolhida;
   }

   public Pergunta getPergunta() 
   {
	   return pergunta;
   }

   public void setPergunta(Pergunta pergunta) 
   {
	   this.pergunta = pergunta;
   }

   public String getAlternativaEscolhida() 
   {
	   return alternativaEscolhida;
   }

   public void setAlternativaEscolhida(String alternativaEscolhida) 
   {
	   this.alternativaEscolhida = alternativaEscolhida;
   }

   @Override
   public String toString() 
   {
	   return "Resposta [pergunta = " + pergunta + ", alternativaEscolhida = " + alternativaEscolhida + "]";
   }
   
    
}
