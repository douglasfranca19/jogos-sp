package com.doufsp.jogossp.controller;

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

import com.doufsp.jogossp.dto.JogosEntradaDto;
import com.doufsp.jogossp.entitie.Jogos_sp;
import com.doufsp.jogossp.exceptions.IdNotFound;
import com.doufsp.jogossp.service.JogosService;

@RestController
@RequestMapping(value = "/jogossp")
public class JogosController {

	@Autowired
	private JogosService jogosService;

	@GetMapping(value = "/todos")
	public ResponseEntity<List<Jogos_sp>> getJogos() {
		return ResponseEntity.ok().body(jogosService.listJogos());

	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Optional<Jogos_sp>> getJogosId(@PathVariable Long id) {
		return ResponseEntity.ok().body(jogosService.getJogosId(id));

	}

	@PostMapping(value = "/insere")
	public ResponseEntity<Jogos_sp> setJogos(@RequestBody JogosEntradaDto jogosDto) {

		Jogos_sp jogosEntitie = new Jogos_sp();

		jogosEntitie.setTimes(jogosDto.getTimes());
		jogosEntitie.setCampeonato(jogosDto.getCampeonato());
		jogosEntitie.setCasaFora(jogosDto.getCasaFora());
		jogosEntitie.setPlacarAdv(jogosDto.getPlacarAdv());
		jogosEntitie.setPlacarSp(jogosDto.getPlacarSp());
		jogosEntitie.setVitoriaDerrotaEmpate(jogosDto.getVitoriaDerrotaEmpate());

		return ResponseEntity.ok().body(jogosService.insertJogos(jogosEntitie));

	}

	@PutMapping(value = "/atualizaId/{id}")
	public ResponseEntity<Jogos_sp> atualizaJogo(@PathVariable Long id, @RequestBody JogosEntradaDto jogosDto) {

		Jogos_sp jogosEntitie = new Jogos_sp();

		jogosEntitie.setTimes(jogosDto.getTimes());
		jogosEntitie.setCampeonato(jogosDto.getCampeonato());
		jogosEntitie.setCasaFora(jogosDto.getCasaFora());
		jogosEntitie.setPlacarAdv(jogosDto.getPlacarAdv());
		jogosEntitie.setPlacarSp(jogosDto.getPlacarSp());
		jogosEntitie.setVitoriaDerrotaEmpate(jogosDto.getVitoriaDerrotaEmpate());

		return ResponseEntity.ok().body(jogosService.atualizaJogo(id, jogosEntitie));

	}

	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<String> deletarPartida(@PathVariable Long id) {

		try {
			jogosService.deletarPartida(id);
			return new ResponseEntity<>("Id deletado: " + id, HttpStatus.OK);
		} catch (IdNotFound e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/deletar/all")
	public void deletarAll() {
		jogosService.deletarAll();
	}

	@GetMapping(value = "/busca-tipo-resultado/{tipoResultado}")
	public ResponseEntity<List<Jogos_sp>> buscaTipoResultado(@PathVariable String tipoResultado) {
		return ResponseEntity.ok().body(jogosService.buscaTipoResultado(tipoResultado));

	}

	@GetMapping(value = "/busca-tipo-campeonato/{tipoCampeonato}")
	public ResponseEntity<List<Jogos_sp>> buscaTipoCampeonato(@PathVariable String tipoCampeonato) {
		return ResponseEntity.ok().body(jogosService.buscaTipoCampeonato(tipoCampeonato));
	}

	@GetMapping(value = "/busca-tipo-campo/{tipoCampo}")
	public ResponseEntity<List<Jogos_sp>> buscaTipoCampo(@PathVariable String tipoCampo) {
		return ResponseEntity.ok().body(jogosService.buscaTipoCampo(tipoCampo));
	}

	@GetMapping(value = "/busca-tipo-adv/{tipoAdv}")
	public ResponseEntity<List<Jogos_sp>> buscaTipoAdversario(@PathVariable String tipoAdv) {
		return ResponseEntity.ok().body(jogosService.buscaTipoAdversario(tipoAdv));
	}
}
