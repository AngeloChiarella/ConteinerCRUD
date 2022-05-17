package br.com.crud.entities.enums;

public enum TipoMovimentacaoEnum {

	EMBARQUE(1), DESCARGA(2), GATEIN(3), GATEOUT(4), REPOSICIONAMENTO(5), PESAGEM(6), SCANNER(7);

	private Integer numero;

	private TipoMovimentacaoEnum(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public static TipoMovimentacaoEnum toEnum(Integer numero) {
		if (numero == 0)
			return null;
		for (TipoMovimentacaoEnum tipo : TipoMovimentacaoEnum.values()) {
			if (numero == tipo.getNumero())
				return tipo;
		}
		throw new IllegalArgumentException("Número Enum inválido!");

	}
}
