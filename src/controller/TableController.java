package controller;

import br.fatec.ListObject.ListObject;
import model.Aluno;
import model.Grupo;


public class TableController {
    ListObject[] area;

    public TableController() {
        area = new ListObject[8];
        for (int i = 0 ; i < 8 ; i++) {
            area[i] = new ListObject();
        }
    }

    public int hashCode(String codigo) {
        int posicao= Integer.parseInt(String.valueOf(codigo.charAt(0)));
        return posicao;
    }

    public void adicionaGrupo(Grupo grupo) throws Exception {
        int hash = grupo.hashCode();
        ListObject l = area[hash];

        if (l.isEmpty()) {
            l.addFirst(grupo);
        } else {
            l.addLast(grupo);
        }
    }

    public Grupo busca(Grupo grupo) throws Exception {
        int hash = grupo.hashCode();
        ListObject l = area[hash];
        int tamanho = l.size();
        for (int i = 0 ; i < tamanho ; i++) {
            Grupo grupobusca= (Grupo) l.get(i);
            if (grupobusca.getArea().equals(grupo.getArea())) {
                return grupobusca;
            }
        }
        return null;
    }
}
