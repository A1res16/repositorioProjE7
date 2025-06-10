

/**@author team 7
 * @version 0.1
 * Esta classe mostra o que contem em um conteudo
 * 
 * Apresenta os detalhes do que se diz o conteudo de um modulo
 * 
 */

import java.util.ArrayList;

public class Conteudo 
{
   private String texto;
   private ArrayList<String> imagens;
   
   /*
    * Construtor da classe com argumento (texto)
    */
   public Conteudo (String texto)
   {
	   this.texto = texto;
	   this.imagens = new ArrayList<>();
   }
   
   public Conteudo()
   {
	   this.texto = texto;
	   this.imagens = new ArrayList<>();
   }
   
   /*
    * Metodo para dizer como sera mostrado o texto no conteudo
    */
   public void formatarTexto()
   {
	   // Para remover espaços em branco no início e no final de uma String
	   this.texto = this.texto.trim();
   }
   
   /*
    * Metodo para adicionar imagens aos conteudos dos modulos
    */
   public void adicionarImagem(String imagemPath)
   {
	   imagens.add(imagemPath);
   }

   public String getTexto() 
   {
	   return texto;
   }

   public void setTexto(String texto) 
   {
	   this.texto = texto;
   }

   public ArrayList<String> getImagens() 
   {
	   return imagens;
   }

   public void setImagens(ArrayList<String> imagens) 
   {
	   this.imagens = imagens;
   }

   @Override
   public String toString() 
   {
	   return "Conteudo [texto = " + texto + ", imagens = " + imagens + "]";
   }
   
   
   
   
}
