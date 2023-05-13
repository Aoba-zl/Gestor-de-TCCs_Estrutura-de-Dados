package model;

public class Reuniao {

	private String data;
	private String assunto;
	
	public String getData() {
		return data;
	}

	public String getAssunto() {
		return assunto;
	}

	public Reuniao(String data, String assunto) 
	{
		this.data = data;
		this.assunto = assunto;
	}

}
