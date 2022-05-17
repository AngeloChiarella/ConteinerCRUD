package br.com.crud.entities.enums;

public enum TipoConteinerEnum {
	TIPO_20(1), TIPO_40(2);

	private Integer numero;

	private TipoConteinerEnum(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public static TipoConteinerEnum toEnum(Integer numero) {
		if (numero == 0)
			return null;
		for (TipoConteinerEnum tipo : TipoConteinerEnum.values()) {
			if (numero == tipo.getNumero())
				return tipo;
		}
		throw new IllegalArgumentException("Número Enum inválido!");

	}
}
