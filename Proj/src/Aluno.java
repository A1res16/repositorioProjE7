

/**@author team 7
 * @version 0.1
 * Esta classe representa um aluno registado na plataforma
 * 
 * Apresenta herança com a classe Utilizador, e alguns metodos em
 * relação aos modulos inscritos
 */

import java.util.ArrayList;

//Classe aluno (um utili)

public class Aluno extends Utilizador 
{
   private ArrayList<ModuloFrequentado> modulosFrequentados;
   private ArrayList<RespostaQuizz> respostasQuizz;
   
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
	   System.out.println(getNome() + " esta a realizar o quizz: " + quizz.toString());
	   //Apenas a simulação da realização de um quizz.
	   //Ainda não se calcula a nota.
	   //A nota calcular-se-ha quando tivermos ligação das classes Resposta, RespostaQuizz com esta.
	   //Teremos quizz.calcularNota(respostasDadas);
	   return 20;
   }

   @Override
   public String toString() 
   {
	   return "Aluno [toString() = " + super.toString() + "]";
   }
   
   
}
