package br.com.sinosi.entidade;

import br.com.ambientinformatica.util.IEnum;

public enum EnumEventoAcidenteSimples implements IEnum {
	LIQUIDO("Derramamento de Líquidos"), 
	GAS("Vazamento de gases"), 
	DESASTRE_NATURAL("Desastre Natural"), 
	OUTROS("Outros");

	private final String descricao;

	private EnumEventoAcidenteSimples(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
