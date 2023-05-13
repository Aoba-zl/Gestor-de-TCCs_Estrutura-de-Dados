package model;

public class Passo {

	
	private String dataL;
	private String descricao;
	
	public Passo(String data, String descricao) 
	{
		this.dataL = data;
		this.descricao = descricao;
	}

	public String getDataL() {
		return dataL;
	}

	public String getDescricao() {
		return descricao;
	}

}
