package com.forneria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.forneria.model.Pizza;
import com.forneria.repository.PizzaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pizzas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PizzaController {

	@Autowired
	private PizzaRepository pizzaRepository;

	@GetMapping
	public ResponseEntity<List<Pizza>> getAll() {
		return ResponseEntity.ok(pizzaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pizza> buscarPorId(@PathVariable Long id) {
		return pizzaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/sabor/{sabor}")
	public List<Pizza> buscarPorSabor(@PathVariable String sabor) {
		return pizzaRepository.findAllBySaborContainingIgnoreCase(sabor);
	}
	
	@GetMapping("/tipo/{tipo}")
	public List<Pizza> buscarPorTipo(@PathVariable String tipo) {
		return pizzaRepository.findByTipoNomeIgnoreCase(tipo);
	}

	@PostMapping
	public ResponseEntity<Pizza> criar(@Valid @RequestBody Pizza pizza) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pizzaRepository.save(pizza));
	}

	@PutMapping
	public ResponseEntity<Pizza> atualizar(@Valid @RequestBody Pizza pizza) {
		return pizzaRepository.findById(pizza.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(pizzaRepository.save(pizza)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		Optional<Pizza> pizza = pizzaRepository.findById(id);

		if (pizza.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		pizzaRepository.deleteById(id);
	}

}