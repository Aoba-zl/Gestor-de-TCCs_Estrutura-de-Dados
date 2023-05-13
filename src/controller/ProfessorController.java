package controller;

import br.fatec.ListObject.ListObject;
import model.Professor;

public class ProfessorController
{
    Professor professor;

    public String getProfessorLogin() {
		return professor.login;
    }

    public void setProfessorLogin(String login) {
        professor.login = login;
    }

    public ListObject getProfessorArea() {
        return professor.area;
    }

    public void setProfessorArea(ListObject area) {
        professor.area = area;
    }

    public ListObject getProfessorGrupos() {
        return professor.grupos;
    }

    public void setProfessorGrupos(ListObject grupos) {
        professor.grupos = grupos;
    }

    public ListObject getProfessorReunioes() {
        return professor.reunioes;
    }

    public void setProfessorReunioes(ListObject reunioes) {
        professor.reunioes = reunioes;
    }
}
