package controller;

import model.Aluno;

public class ManterAluno {

	
	public void salvarDados()
	{
		
	}
	
	public Aluno pesquisarAluno(String[] alunos, String ra)
	{
		if (raValido(ra))
		{
			for (String dadosAluno: alunos) {
				Aluno aluno = new Aluno();
				String[] dados = dadosAluno.split(",");
				if (dados.length == 2)
				{
					aluno.setRa(dados[0]);
					aluno.setNome(dados[1]);

					if (aluno.getRa().equals(ra))
						return aluno;
				}
			}
		}
		return null;
	}
	
	private boolean raValido(String ra)
	{
		return (ra.length() == 13);
	}

}
