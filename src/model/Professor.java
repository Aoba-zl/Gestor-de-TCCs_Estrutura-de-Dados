package model;

import br.fatec.ListObject.ListObject;

public class Professor
{
	public String login;
	public ListObject area;
	public ListObject grupos;
	public ListObject reunioes;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public ListObject getArea() {
		return area;
	}

	public void setArea(ListObject area) {
		this.area = area;
	}

	public ListObject getGrupos() {
		return grupos;
	}

	public void setGrupos(ListObject grupos) {
		this.grupos = grupos;
	}

	public ListObject getReunioes() {
		return reunioes;
	}

	public void setReunioes(ListObject reunioes) {
		this.reunioes = reunioes;
	}
}
