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

		try {
			manterAluno.salvarDados(aluno.getRa(), aluno.getNome());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}

}
