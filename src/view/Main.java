package view;

import controller.ManterAluno;
import model.Aluno;

import javax.swing.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args) 
	{

		ManterAluno manterAluno= new ManterAluno();
		Aluno aluno= new Aluno();
		aluno.setRa("1234567891011");
		aluno.setNome("Roberto");
		Aluno aluno1= new Aluno();
		aluno1.setRa("1234567891012");
		aluno1.setNome("Roberto");

		try {
			manterAluno.salvarDados(aluno);
			manterAluno.salvarDados(aluno1);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}

}
