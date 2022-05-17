package br.com.crud.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.crud.entities.enums.TipoMovimentacaoEnum;

@Entity
@Table(name = "movimentacoes")
public class Movimentacoes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Conteiner conteiner;

//	@NotNull(message = "Campo obrigatório!")
	private String cliente;

	@NotNull(message = "Campo obrigatório!")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraInicio;

	@NotNull(message = "Campo obrigatório!")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraFim;

	@NotNull(message = "Campo obrigatório!")
	private Integer tipo;

	public Movimentacoes() {
		// TODO Auto-generated constructor stub
	}

	public Movimentacoes(Conteiner conteiner, Date dataHoraInicio, Date dataHoraFim, TipoMovimentacaoEnum tipo) {
		this.conteiner = conteiner;
		setCliente(this.conteiner);
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		setTipo(tipo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conteiner getConteiner() {
		return conteiner;
	}

	public void setConteiner(Conteiner conteiner) {
		this.conteiner = conteiner;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(Conteiner conteier ) {
		this.cliente = conteiner.getCliente();
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public TipoMovimentacaoEnum getTipo() {
		return TipoMovimentacaoEnum.toEnum(tipo);
	}

	public void setTipo(TipoMovimentacaoEnum tipo) {
		if (tipo.getNumero() == 0)
			this.tipo = null;
		this.tipo = tipo.getNumero();
	}

}
