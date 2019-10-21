package br.com.sinosi.entidade;


import br.com.ambientinformatica.util.IEnum;

public enum EnumUnidadeMedida implements IEnum {
	 UNIDADE("Unidade","UN"),
	   QUILOGRAMA("Quilograma","KG"),
	   TONELADA("Tonelada","T"),
	   LITRO("Litro","L"),
	   METRO_CUBICO("Metro Cúbico","M³");

	   private final String descricao;

	   private final String sigla;

	   private EnumUnidadeMedida(String descricao, String sigla){
	      this.descricao = descricao;
	      this.sigla = sigla;
	   }

	   @Override
	   public String getDescricao() {
	      return descricao;
	   }

	   public String getSigla() {
	      return sigla;
	   }
   
}
