

/**@author team 7
 * @version 0.1
 * Esta classe contem os modulos em que um aluno frequenta
 * 
 * Apresenta os modificadores e o construtor do objeto
 */
public class ModuloFrequentado 
{
	private String idModulo;
	private EstadoModulo estado;
	private Aluno aluno;
	private Modulo modulo;
	//add
	private double notaQuizz;
	private double notaExame;
	 
	 /*
	  * Constroi um modulo frequentado com parametros
	  */
	 
	public ModuloFrequentado(String idModulo, EstadoModulo estado, Aluno aluno, Modulo modulo) 
	{
		this.idModulo = idModulo;
		this.estado = estado;
		this.aluno = aluno;
		this.modulo = modulo;
		this.notaQuizz = -1;
		this.notaExame = -1;
	}
	
	/*
	 * Constroi um modulo frequentado quando o aluno inicia um modulo
	 * */
    
	public ModuloFrequentado(Aluno aluno, Modulo modulo)
	{
		 this.idModulo = modulo.getTitulo(); // Ou usa um ID único se tiver
	     this.modulo = modulo;
	     this.aluno = aluno;
	     this.estado = EstadoModulo.NAO_INICIADO;
	     this.notaQuizz = -1;
	     this.notaExame = -1;
	}
	
	public String getIdModulo() 
	{
		return idModulo;
	}

	public void setIdModulo(String idModulo) 
	{
		this.idModulo = idModulo;
	}

	public EstadoModulo getEstado() 
	{
		return estado;
	}

	public void setEstado(EstadoModulo estado) 
	{
		this.estado = estado;
	}

	public Aluno getAluno() 
	{
		return aluno;
	}

	public void setAluno(Aluno aluno) 
	{
		this.aluno = aluno;
	}

	public Modulo getModulo() 
	{
		return modulo;
	}

	public void setModulo(Modulo modulo) 
	{
		this.modulo = modulo;
	}
	
	//add
	public double getNotaQuizz()
	{
		return notaQuizz;
	}
	
	//add
	public void setNotaQuizz(double notaQizz)
	{
		this.notaQuizz = notaQizz;
	}
	
	//add
	public double getNotaExame()
	{
		return notaExame;
	}
	
	//add
	public void setNotaExame(double notaExame)
	{
		this.notaExame = notaExame;
	}
	
	//add
	public void atualizarEstado()
	{
		if (notaExame >= 9.5 && notaQuizz >= 9.5)
		{
			estado = EstadoModulo.CONCLUIDO;
		}
		else if (notaQuizz >= 0)
		{
			estado = EstadoModulo.INICIADO;
		}
		else
		{
			estado = EstadoModulo.NAO_INICIADO;
		}
	}

	@Override
	public String toString() 
	{
		return "Modulo: " + modulo.getTitulo() +
	               " | Estado: " + estado +
	               " | Nota Quizz: " + notaQuizz +
	               " | Nota Exame: " + notaExame;
	}
	
	
	 
}
