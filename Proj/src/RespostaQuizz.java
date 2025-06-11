

/**@author team 7
 * @version final
 * Esta classe guarda os detalhes das respostas em um quizz 
 * 
 * Apresenta atributos e o metodo adicionarResposta ao quizz
 */

import java.util.ArrayList;

public class RespostaQuizz 
{
   //add
   private Quizz quizz;
   private float nota;
   private String idQuizz;
   private String idModulo;
   private ArrayList<Resposta> respostas;
   
   public RespostaQuizz(Quizz quizz, float nota)
   {
	   this.quizz = quizz;
	   this.nota = nota;
   }
   
   /*
    * Constrói uma resposta do quizz com parametros
    */
   public RespostaQuizz(String idQuizz, String idModulo) 
   {
		this.idQuizz = idQuizz;
		this.idModulo = idModulo;
		this.respostas = new ArrayList<>();
   }
   
   /*
    * Metodo para adicionar as respostas de um quizz
    */
   public void adicionarResposta(Resposta resposta)
   {
	   respostas.add(resposta);
   }

   public String getIdQuizz() 
   {
	   return idQuizz;
   }

   public void setIdQuizz(String idQuizz) 
   {
	   this.idQuizz = idQuizz;
   }

   public String getIdModulo() 
   {
	   return idModulo;
   }

   public void setIdModulo(String idModulo) 
   {
	   this.idModulo = idModulo;
   }

   public ArrayList<Resposta> getRespostas() 
   {
	   return respostas;
   }

   public void setRespostas(ArrayList<Resposta> respostas) 
   {
	   this.respostas = respostas;
   }
   
   public Quizz getQuizz() 
   {
	return quizz;
   }
   
   public float getNota() 
   {
	return nota;
   }

@Override
   public String toString() 
   {
	   return "RespostaQuizz [idQuizz = " + idQuizz + ", idModulo = " + idModulo + ", respostas = " + respostas + "]";
   }
   
   
   
}
