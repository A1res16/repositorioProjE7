

/**@author team 7
 * @version final
 * 
 * Esta classe contem a  informacao de um exame final dos modulos
 */

//add
import java.util.ArrayList; 

public class ExameFinal 
{
   private ArrayList<Pergunta> perguntas;
   private int notaMinima;
   private boolean ativo;

   /*
    * Constroi um exame final sem parametros
    * */ 
   public ExameFinal() 
   {
	   this.perguntas = new ArrayList<>();
	   this.notaMinima = 8; //valor minimo(40%)
	   this.ativo = false;
   }
   
   //metodo que adiciona perguntas no exame
   public void adicionarPergunta(Pergunta p)
   {
	   if (perguntas.size() < 20)
	   {
		   perguntas.add(p);
	   }
	   else
	   {
		   System.out.println("O exame nao pode ter mais de 20 perguntas.");
	   }
   }
   
   //metodo que remove uma pergunta do exame
   public void removerPergunta(Pergunta p)
   {
	   perguntas.remove(p);
   }
   
   //metodo para editar a nota
   public void editarNotaMinima(int novaNota)
   {
	   this.notaMinima = novaNota;
   }

   public int getNotaMinima() 
   {
	   return notaMinima;
   }

   public void setNotaMinima(int notaMinima) 
   {
	   this.notaMinima = notaMinima;
   }

   public ArrayList<Pergunta> getPerguntas() 
   {
	   return perguntas;
   }
   
   //metodo para deixar o exame disponivel
   public boolean isAtivo()
   {
	   return ativo;
   }
   
   public void ativar()
   {
	   this.ativo = true;
   }
   
   public void desativar()
   {
	   this.ativo = false;
   }
   
   //metodo para ver as perguntas do exame
   public void listarPerguntas()
   {
	   if (perguntas.isEmpty())
	   {
		   System.out.println("O Exame ainda nao tem perguntas.");
	   }
	   else
	   {
		   int i = 1;
		   for (Pergunta p : perguntas)
		   {
			   System.out.println(i + ". " + p.getEnunciado());
			   i++;
		   }
	   }
   }
   
}
