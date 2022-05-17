package br.com.crud.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.crud.entities.enums.CategoriaEnum;
import br.com.crud.entities.enums.StatusEnum;
import br.com.crud.entities.enums.TipoConteinerEnum;

@Entity
@Table(name = "conteiner")
public class Conteiner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Campo obrigatório!")
	private String cliente;
	
	@NotNull(message = "Campo obrigatório!")
	private String numeroConteiner;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer tipo;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer status;
	
	@NotNull(message = "Campo obrigatório!")
	private Integer categoria;
	
	@OneToMany(mappedBy = "conteiner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(name = "movimentacao")
	private List<Movimentacoes> movimentacoes;

	public Conteiner() {
		// TODO Auto-generated constructor stub
	}

	public Conteiner(String cliente, String numeroConteiner, TipoConteinerEnum tipo, StatusEnum status,
			CategoriaEnum categoria) {
		this.cliente = cliente;
		this.numeroConteiner = numeroConteiner;
		setTipo(tipo);
		setStatus(status);
		setCategoria(categoria);
	}

	public boolean validacaoNumero(String numero) throws Exception {
		if (!numero.substring(0, 4).matches("[A-Z]*")) {
			throw new IllegalArgumentException("Letras inválidas!");
		}
		if (!numero.substring(4, 11).matches("[0-9]*")) {
			throw new IllegalArgumentException("Números inválidos!");
		}
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNumeroConteiner() {
		return numeroConteiner;
	}

	public void setNumeroConteiner(String numeroConteiner) {
		this.numeroConteiner = numeroConteiner;
	}

	public TipoConteinerEnum getTipo() {
		return TipoConteinerEnum.toEnum(tipo);
	}

	public void setTipo(TipoConteinerEnum tipo) {
		if (tipo.getNumero() == 0)
			this.tipo = null;
		this.tipo = tipo.getNumero();
	}

	public StatusEnum getStatus() {
		return StatusEnum.toEnum(status);
	}

	public void setStatus(StatusEnum status) {
		if (status.getNumero() == 0)
			this.status = null;
		this.status = status.getNumero();
	}

	public CategoriaEnum getCategoria() {
		return CategoriaEnum.toEnum(categoria);
	}

	public void setCategoria(CategoriaEnum categoria) {
		if (categoria.getNumero() == 0)
			this.categoria = null;

		this.categoria = categoria.getNumero();
	}

}
