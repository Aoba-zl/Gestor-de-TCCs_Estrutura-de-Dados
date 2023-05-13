package controller;

import model.Aluno;
import model.Area;
import model.Grupo;

public class GrupoController
{
    Grupo grupo;
    public int getGrupoCodigo() {
        return grupo.codigo;
    }

    public void setGrupoCodigo(int codigo) {
        grupo.codigo = codigo;
    }

    public String getGrupoTema() {
        return grupo.tema;
    }

    public void setGrupoTema(String tema) {
        grupo.tema = tema;
    }

    public Aluno getGrupoAlunos() {
        return grupo.alunos;
    }

    public void setGrupoAlunos(Aluno alunos) {
        grupo.alunos = alunos;
    }

    public Area getGrupoArea() {
        return grupo.area;
    }

    public void setGrupoArea(Area area) {
        grupo.area = area;
    }
}
