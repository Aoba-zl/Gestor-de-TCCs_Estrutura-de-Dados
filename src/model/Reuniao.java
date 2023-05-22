package model;

public class Reuniao
{
	private String data;
	private String assunto;
	private String passos;
	private int codigoGrupo;
	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getPassos() {
		return passos;
	}

	public void setPassos(String passos) {
		this.passos = passos;
	}

	public int getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(int codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
}
