package controller;

import model.Reuniao;

public class ReuniaoController
{
    Reuniao reuniao;

    public String getData() {
        return reuniao.data;
    }

    public void setReuniaoData(String data) {
        reuniao.data = data;
    }

    public String getReuniaoAssunto() {
        return reuniao.assunto;
    }

    public void setReuniaoAssunto(String assunto) {
        reuniao.assunto = assunto;
    }

    public String getReuniaoPassos() {
        return reuniao.passos;
    }

    public void setReuniaoPassos(String passos) {
        reuniao.passos = passos;
    }

    public int getReuniaoCodigoGrupo() {
        return reuniao.codigoGrupo;
    }

    public void setReuniaoCodigoGrupo(int codigoGrupo) {
        reuniao.codigoGrupo = codigoGrupo;
    }
}
