

/**@author team 7
 * @version 0.1
 * Esta classe guarda informações sobre um aluno e um administrador 
 * da plataforma de E-Learninng de Sustentabilidade
 * 
 * Apresenta os atributos de aluno e administrador, com alguns métodos, e é a SuperClasse deste projeto
 */


public class Utilizador 
{
    private String nome;
    private String email;
    private String password;
    private String tipo; // Aluno ou Administrador
    
    /*
     * Constrói um Utilizador com parametros
     */
    public Utilizador(String nome, String email, String password, String tipo) throws DadosInvalidosException
	{
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.tipo = tipo;
		validaDados(); //para validar automaticamente ao criar utilizadores.
	}
    
    /*
     * Criação do metodo de login para os utilizadores
     */
    public boolean login(String email, String password)
    {
    	//verifica se o email e a pssd recebidos são iguais aos armazenados
    	return this.email.equals(email) && this.password.equals(password);
    }
    
    /*
     * Criação do metodo de logout para todos.
     */
    public void logout()
    {
       System.out.println(nome + " fez o logout. ");
    }
    
     /*
      * Metodo para validar os dados de todos no login
      */
    
    //Deveremos tratar essa exceção,, em todos os locais onde estivermos a criar novos utilizadores
    private void validaDados() throws DadosInvalidosException
    {
    	if (!validarEmail())
    	{
    		throw new DadosInvalidosException("E-mail invalido. Deve conter '@' e um dominio valido.");
    	}
    	if (!validarPassword())
    	{
    		throw new DadosInvalidosException("Password fraca. Deve conter no mínimo 8 caracteres, uma letra maiuscula e um caractere especial. ");
    	}
    	if (!validarTipo())
    	{
    		throw new DadosInvalidosException("Tipo de utilizador invalido. Deve ser 'aluno' ou 'administrador'. ");
    	}
    }
    
    private boolean validarEmail()
    {
    	//expressão regular para validar um email:
    	
    	// ^  -> inicio da string
    	
    	// [\w.-]+  -> um ou mais caracteres alfanuméricos, pontos ou hífens(parte antes do @) 
    	
    	// @  -> símbolo obrigatório do email
    	
    	// [\w.-]+  -> um ou mais caracteres alfanuméricos, pontos ou hífens(parte do dominio) 
    	
    	// \\.[a-zA-Z]{2,}  -> ponto seguido de 2 ou mais letras (ex: .com, .pt)
    	
    	// $  -> fim da string
    	return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
    
    private boolean validarPassword()
    {
    	//expressão regular para validar uma password: 
    	
    	// .length() >=8   -> mínimo de 8 caracteres
    	
    	// .matches(".*[A-Z].*")  -> pelo menos uma letra maiúscula
    	
    	// .matches(".*[^a-zA-Z0-9].*")  -> pelo menos um caractere especial(não é letra e nem número)
    	return password != null && 
    		   password.length() >=8 && 
    		   password.matches(".*[A-Z].*") && 
    		   password.matches(".*[a-zA-Z0-9].*");
    }
    
    private boolean validarTipo()
    {
    	return tipo != null && (tipo.equalsIgnoreCase("aluno") || tipo.equalsIgnoreCase("administrador"));
    }

    /*
     * Metodos modificadores de acesso
     */
	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getTipo() 
	{
		return tipo;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}

	@Override
	public String toString() 
	{
		return "Utilizador [nome = " + nome + ", email = " + email + ", password = " + password + ", tipo = " + tipo + "]";
	}
	
}
