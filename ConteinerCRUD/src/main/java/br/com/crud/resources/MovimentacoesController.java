package br.com.crud.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.entities.Movimentacoes;
import br.com.crud.repositories.MovimentacoesRepository;

@RestController
@RequestMapping(value = "/conteiner/movimentacoes")
public class MovimentacoesController {

	@Autowired
	MovimentacoesRepository repository;

	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Movimentacoes> insert(@RequestBody Movimentacoes movimentacoes) throws Exception {
		return new ResponseEntity<Movimentacoes>(repository.save(movimentacoes), HttpStatus.CREATED);
	}

	@GetMapping(value = "/relatorio/{tipo}")
	public ResponseEntity<List<Movimentacoes>> report(@PathVariable Integer tipo) {
		return new ResponseEntity<List<Movimentacoes>>(repository.findByTipo(tipo), HttpStatus.OK);
	}

	@GetMapping(value = "/buscarId/{id}")
	public ResponseEntity<Optional<Movimentacoes>> findById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Movimentacoes>>(repository.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/buscarTodos")
	public ResponseEntity<List<Movimentacoes>> findAll() {
		return new ResponseEntity<List<Movimentacoes>>(repository.findAll(), HttpStatus.OK);
	}

	@PutMapping(value = "/alterar")
	public ResponseEntity<Movimentacoes> update(@RequestBody Movimentacoes movimentacoes) throws Exception {
		return new ResponseEntity<Movimentacoes>(repository.save(movimentacoes), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletarId/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}