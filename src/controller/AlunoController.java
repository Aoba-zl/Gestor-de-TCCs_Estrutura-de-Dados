package controller;

import model.Aluno;

public class AlunoController
{
    private Aluno aluno;
    private boolean validaAlunoRA(String ra)
    {
        return (ra.length() == 13);
    }
    public String getAlunoRA () {
        return aluno.ra;
    }
    public void setAlunoRa(String ra) throws Exception
    {
        if (!validaAlunoRA(ra))
            throw new Exception("RA Inválido!");
        aluno.ra = ra;
    }
    public String getAlunoNome() {
        return aluno.nome;
    }
    public void setAlunoNome(String nome) {
        aluno.nome = nome;
    }
}
