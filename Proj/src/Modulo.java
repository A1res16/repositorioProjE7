

/**@author team 7

 * @version final
 * Esta classe guarda as informações de um modulo soobre os ODS
 * 
 * Apresenta os atributos e alguns metodos ligados ao administrador
 */

import java.util.ArrayList;

public class Modulo 
{
  
   private String titulo;
   private String descricao;
   private int ordem;
   private String objetivo;
   private ArrayList<Conteudo> conteudos;
   private Quizz quizz;
   
   /*
    * Constrói um modulo com parametros
    */
   public Modulo(String titulo, String descricao, int ordem, String objetivo, Quizz quizz) 
   {
	   
		this.titulo = titulo;
		this.descricao = descricao;
		this.ordem = ordem;
		this.objetivo = objetivo;
		this.conteudos = new ArrayList<>();
		this.quizz = quizz;
	}
   
   /*
    * Constroi um modulo com 4 parametros
    * */
   
   public Modulo(String titulo, String descricao, int ordem, String objetivo)
   {
	   this.titulo = titulo;
	   this.descricao = descricao;
	   this.ordem = ordem;
	   this.objetivo = objetivo;
	   this.conteudos = new ArrayList<>();
	   this.quizz = null;
   }
   
    /*
     * Metodo para adicionar conteúdos aos modulos 
     */
   
    public void adicionarConteudo(Conteudo c)
    {
    	conteudos.add(c);
    }
    
    /*
     * Metodo para ligar um quizz a um modulo
     */
    public void associarQuizz(Quizz q)
    {
    	this.quizz = q;
    }

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public String getDescricao() 
	{
		return descricao;
	}

	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}

	public int getOrdem() 
	{
		return ordem;
	}

	public void setOrdem(int ordem) 
	{
		this.ordem = ordem;
	}

	public String getObjetivo() 
	{
		return objetivo;
	}

	public void setObjetivo(String objetivo) 
	{
		this.objetivo = objetivo;
	}

	public ArrayList<Conteudo> getConteudos() 
	{
		return conteudos;
	}

	public Quizz getQuizz() 
	{
		return quizz;
	}

	public void setQuizz(Quizz quizz) 
	{
		this.quizz = quizz;
	}

	@Override
	public String toString() 
	{
		return "Modulo [titulo = " + titulo + ", descricao = " + descricao + ", ordem = " + ordem + ", objetivo = " + objetivo
				+ ", conteudos = " + conteudos + ", quizz = " + quizz + "]";
	}
	
	
    
    
}
