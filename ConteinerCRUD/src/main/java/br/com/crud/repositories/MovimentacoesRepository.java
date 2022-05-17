package br.com.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crud.entities.Conteiner;
import br.com.crud.entities.Movimentacoes;
import br.com.crud.entities.enums.TipoMovimentacaoEnum;

@Repository
public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {
	List<Movimentacoes> findByTipo(Integer tipo);
}
