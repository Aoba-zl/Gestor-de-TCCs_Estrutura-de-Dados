package model;

public class Aluno {

	private String RA;
	private String nome;
	
	public Aluno(String RA, String nomeAluno) 
	{
		this.RA = RA;
		this.nome = nomeAluno;
	}

	public String getRA() {
		return RA;
	}

	public String getNome() {
		return nome;
	}

}
