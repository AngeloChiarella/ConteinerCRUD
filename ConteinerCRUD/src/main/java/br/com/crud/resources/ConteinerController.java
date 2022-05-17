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

import br.com.crud.entities.Conteiner;
import br.com.crud.entities.Movimentacoes;
import br.com.crud.repositories.ConteinerRepository;

@RestController
@RequestMapping(value = "/conteiner")
public class ConteinerController {

	@Autowired
	ConteinerRepository repository;

	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Conteiner> insert(@RequestBody Conteiner conteiner) throws Exception {
		conteiner.validacaoNumero(conteiner.getNumeroConteiner());
		return new ResponseEntity<Conteiner>(repository.save(conteiner), HttpStatus.CREATED);
	}
	

	@GetMapping(value = "/buscarId/{id}")
	public ResponseEntity<Optional<Conteiner>> findById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Conteiner>>(repository.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/buscarTodos")
	public ResponseEntity<List<Conteiner>> findAll() {
		return new ResponseEntity<List<Conteiner>>(repository.findAll(), HttpStatus.OK);
	}

	@PutMapping(value = "/alterar")
	public ResponseEntity<Conteiner> update(@RequestBody Conteiner conteiner) throws Exception {
		conteiner.validacaoNumero(conteiner.getNumeroConteiner());
		return new ResponseEntity<Conteiner>(repository.save(conteiner), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletarId/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}