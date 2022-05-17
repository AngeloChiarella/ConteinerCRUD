package br.com.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crud.entities.Conteiner;

@Repository
public interface ConteinerRepository extends JpaRepository<Conteiner, Long> {
//	Relatório com o total de movimentações agrupadas por cliente e tipo de movimentação.


}
