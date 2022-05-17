package br.com.crud.entities.enums;

public enum CategoriaEnum {

	IMPORTACAO(1), EXPORTACAO(2);

	private Integer numero;

	private CategoriaEnum(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public static CategoriaEnum toEnum(Integer numero) {
		if (numero == 0)
			return null;
		for (CategoriaEnum tipo : CategoriaEnum.values()) {
			if (numero == tipo.getNumero())
				return tipo;
		}
		throw new IllegalArgumentException("Número Enum inválido!");

	}
}
