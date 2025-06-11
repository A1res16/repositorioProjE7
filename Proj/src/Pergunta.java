

/**@author team 7
 * @version final
 * Esta classe gurda os detalhes de uma pergunta num quizz
 * 
 * Apresenta os atributos e os modificadores
 * 
 */

import java.util.ArrayList;

public class Pergunta 
{
   private String enunciado;
   private ArrayList<String> alternativas;
   private String respostaCorreta;
   private String justificativa;

   
   /*
    * Constrói uma pergunta com parametros
    */
   public Pergunta(String enunciado, ArrayList<String> alternativas, String respostaCorreta, String justificativa) 
   {
		this.enunciado = enunciado;
		this.alternativas = alternativas;
		this.respostaCorreta = respostaCorreta;
		this.justificativa = justificativa;
   }

   public String getEnunciado() 
   {
	   return enunciado;
   }

   public void setEnunciado(String enunciado) 
   {
	   this.enunciado = enunciado;
   }

   public ArrayList<String> getAlternativas() 
   {
	   return alternativas;
   }

   public void setAlternativas(ArrayList<String> alternativas) 
   {
	   this.alternativas = alternativas;
   }

   public String getRespostaCorreta() 
   {
	   return respostaCorreta;
   }

   public void setRespostaCorreta(String respostaCorreta) 
   {
	   this.respostaCorreta = respostaCorreta;
   }

   public String getJustificativa() 
   {
	   return justificativa;
   }

   public void setJustificativa(String justificativa) 
   {
	   this.justificativa = justificativa;
   }

   @Override
   public String toString() 
   {
	   return "Pergunta [enunciado = " + enunciado + ", alternativas = " + alternativas + ", respostaCorreta = "
			   + respostaCorreta + ", justificativa = " + justificativa + "]";
   }
   
   
}
