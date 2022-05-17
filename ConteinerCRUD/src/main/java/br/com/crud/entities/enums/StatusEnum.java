package br.com.crud.entities.enums;

public enum StatusEnum {
	CHEIO(1), VAZIO(2);

	private Integer numero;

	private StatusEnum(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public static StatusEnum toEnum(Integer numero) {
		if (numero == 0)
			return null;
		for (StatusEnum tipo : StatusEnum.values()) {
			if (numero == tipo.getNumero())
				return tipo;
		}
		throw new IllegalArgumentException("Número Enum inválido!");

	}
}
