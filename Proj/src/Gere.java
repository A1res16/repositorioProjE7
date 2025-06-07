

/**@author team 7
 * @version 0.1
 * Esta classe é a que gere a plataforma
 * 
 * Ela pode criar, editar e remover modulos e quizzes.
 * 
 */

import java.util.ArrayList;

public class Gere 
{
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
